//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.20 at 04:31:20 PM CEST 
//


package schemaToJava;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TAutomobila complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAutomobila">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Marka_automobila" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Model_automobila" type="{http://www.ftn.uns.ac.rs/Automobil}TModel_automobila"/>
 *         &lt;element name="Klasa_automobila" type="{http://www.ftn.uns.ac.rs/Automobil}TKlasa_automobila"/>
 *         &lt;element name="Vrsta_goriva" type="{http://www.ftn.uns.ac.rs/Automobil}TTip_goriva"/>
 *         &lt;element name="Tip_menjaca" type="{http://www.ftn.uns.ac.rs/Automobil}TTip_menjaca"/>
 *         &lt;element name="Predjena_kilometraza" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Planirana_kilometraza" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="Collision_Damage_Waiver" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Broj_sedista_za_decu">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Slika" type="{http://www.ftn.uns.ac.rs/Automobil}TSlika_vozila" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAutomobila", propOrder = {
    "markaAutomobila",
    "modelAutomobila",
    "klasaAutomobila",
    "vrstaGoriva",
    "tipMenjaca",
    "predjenaKilometraza",
    "planiranaKilometraza",
    "collisionDamageWaiver",
    "brojSedistaZaDecu",
    "slika"
})
@XmlSeeAlso({
    Automobil.class
})
public class TAutomobila {

    @XmlElement(name = "Marka_automobila", required = true)
    protected String markaAutomobila;
    @XmlElement(name = "Model_automobila", required = true)
    protected TModelAutomobila modelAutomobila;
    @XmlElement(name = "Klasa_automobila", required = true)
    protected TKlasaAutomobila klasaAutomobila;
    @XmlElement(name = "Vrsta_goriva", required = true)
    protected TTipGoriva vrstaGoriva;
    @XmlElement(name = "Tip_menjaca", required = true)
    protected TTipMenjaca tipMenjaca;
    @XmlElement(name = "Predjena_kilometraza")
    protected float predjenaKilometraza;
    @XmlElement(name = "Planirana_kilometraza", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger planiranaKilometraza;
    @XmlElement(name = "Collision_Damage_Waiver")
    protected boolean collisionDamageWaiver;
    @XmlElement(name = "Broj_sedista_za_decu")
    protected int brojSedistaZaDecu;
    @XmlElement(name = "Slika", required = true)
    protected List<TSlikaVozila> slika;

    /**
     * Gets the value of the markaAutomobila property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarkaAutomobila() {
        return markaAutomobila;
    }

    /**
     * Sets the value of the markaAutomobila property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarkaAutomobila(String value) {
        this.markaAutomobila = value;
    }

    /**
     * Gets the value of the modelAutomobila property.
     * 
     * @return
     *     possible object is
     *     {@link TModelAutomobila }
     *     
     */
    public TModelAutomobila getModelAutomobila() {
        return modelAutomobila;
    }

    /**
     * Sets the value of the modelAutomobila property.
     * 
     * @param value
     *     allowed object is
     *     {@link TModelAutomobila }
     *     
     */
    public void setModelAutomobila(TModelAutomobila value) {
        this.modelAutomobila = value;
    }

    /**
     * Gets the value of the klasaAutomobila property.
     * 
     * @return
     *     possible object is
     *     {@link TKlasaAutomobila }
     *     
     */
    public TKlasaAutomobila getKlasaAutomobila() {
        return klasaAutomobila;
    }

    /**
     * Sets the value of the klasaAutomobila property.
     * 
     * @param value
     *     allowed object is
     *     {@link TKlasaAutomobila }
     *     
     */
    public void setKlasaAutomobila(TKlasaAutomobila value) {
        this.klasaAutomobila = value;
    }

    /**
     * Gets the value of the vrstaGoriva property.
     * 
     * @return
     *     possible object is
     *     {@link TTipGoriva }
     *     
     */
    public TTipGoriva getVrstaGoriva() {
        return vrstaGoriva;
    }

    /**
     * Sets the value of the vrstaGoriva property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTipGoriva }
     *     
     */
    public void setVrstaGoriva(TTipGoriva value) {
        this.vrstaGoriva = value;
    }

    /**
     * Gets the value of the tipMenjaca property.
     * 
     * @return
     *     possible object is
     *     {@link TTipMenjaca }
     *     
     */
    public TTipMenjaca getTipMenjaca() {
        return tipMenjaca;
    }

    /**
     * Sets the value of the tipMenjaca property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTipMenjaca }
     *     
     */
    public void setTipMenjaca(TTipMenjaca value) {
        this.tipMenjaca = value;
    }

    /**
     * Gets the value of the predjenaKilometraza property.
     * 
     */
    public float getPredjenaKilometraza() {
        return predjenaKilometraza;
    }

    /**
     * Sets the value of the predjenaKilometraza property.
     * 
     */
    public void setPredjenaKilometraza(float value) {
        this.predjenaKilometraza = value;
    }

    /**
     * Gets the value of the planiranaKilometraza property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPlaniranaKilometraza() {
        return planiranaKilometraza;
    }

    /**
     * Sets the value of the planiranaKilometraza property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPlaniranaKilometraza(BigInteger value) {
        this.planiranaKilometraza = value;
    }

    /**
     * Gets the value of the collisionDamageWaiver property.
     * 
     */
    public boolean isCollisionDamageWaiver() {
        return collisionDamageWaiver;
    }

    /**
     * Sets the value of the collisionDamageWaiver property.
     * 
     */
    public void setCollisionDamageWaiver(boolean value) {
        this.collisionDamageWaiver = value;
    }

    /**
     * Gets the value of the brojSedistaZaDecu property.
     * 
     */
    public int getBrojSedistaZaDecu() {
        return brojSedistaZaDecu;
    }

    /**
     * Sets the value of the brojSedistaZaDecu property.
     * 
     */
    public void setBrojSedistaZaDecu(int value) {
        this.brojSedistaZaDecu = value;
    }

    /**
     * Gets the value of the slika property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slika property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSlika().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TSlikaVozila }
     * 
     * 
     */
    public List<TSlikaVozila> getSlika() {
        if (slika == null) {
            slika = new ArrayList<TSlikaVozila>();
        }
        return this.slika;
    }

}
