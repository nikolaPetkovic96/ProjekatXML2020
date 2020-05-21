//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.20 at 04:31:20 PM CEST 
//


package schemaToJava;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for common_data complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="common_data">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Datum_kreiranja" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Datum_izmene" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "common_data", namespace = "http://www.ftn.uns.ac.rs/AdminKlijent", propOrder = {
    "datumKreiranja",
    "datumIzmene"
})
@XmlSeeAlso({
    CommonDataFirma.class,
    CommonDataOsoba.class
})
public abstract class CommonData {

    @XmlElement(name = "Datum_kreiranja", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumKreiranja;
    @XmlElement(name = "Datum_izmene", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumIzmene;

    /**
     * Gets the value of the datumKreiranja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumKreiranja() {
        return datumKreiranja;
    }

    /**
     * Sets the value of the datumKreiranja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumKreiranja(XMLGregorianCalendar value) {
        this.datumKreiranja = value;
    }

    /**
     * Gets the value of the datumIzmene property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumIzmene() {
        return datumIzmene;
    }

    /**
     * Sets the value of the datumIzmene property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumIzmene(XMLGregorianCalendar value) {
        this.datumIzmene = value;
    }

}
