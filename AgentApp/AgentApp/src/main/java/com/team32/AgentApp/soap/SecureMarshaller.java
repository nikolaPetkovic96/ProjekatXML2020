package com.team32.AgentApp.soap;

import java.io.StringReader;
import java.io.StringWriter;


import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.oxm.mime.MimeContainer;

public class SecureMarshaller extends Jaxb2Marshaller {
	@Override
	public Object unmarshal(Source source) throws XmlMappingException {
		try {
			StringWriter sw = new StringWriter();
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
					"no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.transform(source, new StreamResult(sw));

			StreamSource s= new StreamSource(new StringReader(sw.toString())); 
			
			return super.unmarshal(s);
		} catch (Exception e) {
		}
		return null;
	}
	
	
	@Override
	public Object unmarshal(Source arg0, MimeContainer arg1)
			throws XmlMappingException {
		try {
			StringWriter sw = new StringWriter();
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
					"no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.transform(arg0, new StreamResult(sw));

			StreamSource s= new StreamSource(new StringReader(sw.toString())); 
			
			return super.unmarshal(s, arg1);
		} catch (Exception e) {
		}
		return null;
	}
}
