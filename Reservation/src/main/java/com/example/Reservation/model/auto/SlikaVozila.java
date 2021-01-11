package com.example.Reservation.model.auto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for TSlika_vozila complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TSlika_vozila">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="slika" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="Common_data" type="{http://www.ftn.uns.ac.rs/AdminKlijent}common_data"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TSlika_vozila", propOrder = {
    "id",
    "slika",
    "commonData"
})

@Entity
public class SlikaVozila {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
	@Column(name = "slika", nullable = false)
    @XmlElement(required = true)
	
    protected String[] slika;
    
    @XmlElement(name = "Common_data", required = true)
    @Column(name = "common_data_id", nullable = false)
    protected Long commonDataId;

	 //Jedna slika se odnosi na samo jedan autombil(druga strana bidirekcije)
    @Column(name = "automobil_id", nullable = false)
    private Long automobilId;


	public SlikaVozila() {
		super();
	}

	public SlikaVozila(Long id, String[] slika, Long commonDataId, Long automobilId) {
		super();
		this.id = id;
		this.slika = slika;
		this.commonDataId = commonDataId;
		this.automobilId = automobilId;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long value) {
        this.id = value;
    }

    public String[] getSlika() {
        return slika;
    }

	public void setSlika(String[] slika) {
		this.slika = slika;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}


	public Long getAutomobilId() {
		return automobilId;
	}


	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}



}
