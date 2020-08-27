package com.example.Pretraga.dto;

import java.time.LocalDateTime;

public class OglasDTO {
	protected Long id;
    protected LocalDateTime odDatuma;
    protected LocalDateTime  doDatuma;
    protected Long cenovnikId;
	//private Long commonDataId;
	private Long automobilId;
	
	//cenovnik
    //protected Long id;
    protected int cenaPoDanu;
    //protected String nazivCenovnika;
    protected int popustZaPreko30Dana;
    protected int cenaCollisionDamageWaiver;
    protected int cenaPoKilometru;
    
    //automobil: nema common data u klasi automobil
   // protected Long id;
   // protected Long markaAutomobilaId;
    //protected Long modelAutomobilaId;
    //protected Long klasaAutomobilaId;
    //protected Long vrstaGorivaId;
    //protected Long tipMenjacaId;
    protected float predjenaKilometraza;
    protected float planiranaKilometraza;
    protected boolean collisionDamageWaiver;
    protected int brojSedistaZaDecu;
    
    //commondata
	//protected Long id;
	protected LocalDateTime datumKreiranja;
	protected LocalDateTime datumIzmene;
	protected Long userId;
	
	//tadresa, cmd
   // protected Long id;
    protected String mesto;
    protected int postanskiBroj;
    protected String ulica;
    protected int broj;
   // protected float longitude;
   // protected float latitude;
    
    //Tklasa
    //protected Long id;
    protected String nazivKlase;
    //protected Long commonDataId;
    
    //tmarka
   // protected Long id;
    protected String nazivMarke;
   // protected Long commonDataId;
    
    //tmodel
    //protected Long id;
    protected String nazivModela;
    //protected Long commonDataId;
    //private Long markaAutomobilaId;
    
    //ttip goriva
    //protected Long id;
    protected String nazivTipaGoriva;
    //protected Long commonDataId;
    
    //ttipmenjaca
    //protected Long id;
    protected String nazivMenjaca;
    //protected Long commonDataId;
    protected String korisnickoIme;
   // protected Long id;
    protected Long adresaId;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getOdDatuma() {
		return odDatuma;
	}
	public void setOdDatuma(LocalDateTime odDatuma) {
		this.odDatuma = odDatuma;
	}
	public LocalDateTime getDoDatuma() {
		return doDatuma;
	}
	public void setDoDatuma(LocalDateTime doDatuma) {
		this.doDatuma = doDatuma;
	}
	public Long getCenovnikId() {
		return cenovnikId;
	}
	public void setCenovnikId(Long cenovnikId) {
		this.cenovnikId = cenovnikId;
	}
	public Long getAutomobilId() {
		return automobilId;
	}
	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}
	public int getCenaPoDanu() {
		return cenaPoDanu;
	}
	public void setCenaPoDanu(int cenaPoDanu) {
		this.cenaPoDanu = cenaPoDanu;
	}
	public int getPopustZaPreko30Dana() {
		return popustZaPreko30Dana;
	}
	public void setPopustZaPreko30Dana(int popustZaPreko30Dana) {
		this.popustZaPreko30Dana = popustZaPreko30Dana;
	}
	public int getCenaCollisionDamageWaiver() {
		return cenaCollisionDamageWaiver;
	}
	public void setCenaCollisionDamageWaiver(int cenaCollisionDamageWaiver) {
		this.cenaCollisionDamageWaiver = cenaCollisionDamageWaiver;
	}
	public int getCenaPoKilometru() {
		return cenaPoKilometru;
	}
	public void setCenaPoKilometru(int cenaPoKilometru) {
		this.cenaPoKilometru = cenaPoKilometru;
	}
	public float getPredjenaKilometraza() {
		return predjenaKilometraza;
	}
	public void setPredjenaKilometraza(float predjenaKilometraza) {
		this.predjenaKilometraza = predjenaKilometraza;
	}
	public float getPlaniranaKilometraza() {
		return planiranaKilometraza;
	}
	public void setPlaniranaKilometraza(float planiranaKilometraza) {
		this.planiranaKilometraza = planiranaKilometraza;
	}
	public boolean isCollisionDamageWaiver() {
		return collisionDamageWaiver;
	}
	public void setCollisionDamageWaiver(boolean collisionDamageWaiver) {
		this.collisionDamageWaiver = collisionDamageWaiver;
	}
	public int getBrojSedistaZaDecu() {
		return brojSedistaZaDecu;
	}
	public void setBrojSedistaZaDecu(int brojSedistaZaDecu) {
		this.brojSedistaZaDecu = brojSedistaZaDecu;
	}
	public LocalDateTime getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(LocalDateTime datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	public LocalDateTime getDatumIzmene() {
		return datumIzmene;
	}
	public void setDatumIzmene(LocalDateTime datumIzmene) {
		this.datumIzmene = datumIzmene;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	public int getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(int postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
	}
	public String getNazivKlase() {
		return nazivKlase;
	}
	public void setNazivKlase(String nazivKlase) {
		this.nazivKlase = nazivKlase;
	}
	public String getNazivMarke() {
		return nazivMarke;
	}
	public void setNazivMarke(String nazivMarke) {
		this.nazivMarke = nazivMarke;
	}
	public String getNazivModela() {
		return nazivModela;
	}
	public void setNazivModela(String nazivModela) {
		this.nazivModela = nazivModela;
	}
	public String getNazivTipaGoriva() {
		return nazivTipaGoriva;
	}
	public void setNazivTipaGoriva(String nazivTipa) {
		this.nazivTipaGoriva = nazivTipa;
	}
	public String getNazivMenjaca() {
		return nazivMenjaca;
	}
	public void setNazivMenjaca(String nazivMenjaca) {
		this.nazivMenjaca = nazivMenjaca;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public Long getAdresaId() {
		return adresaId;
	}
	public void setAdresaId(Long adresaId) {
		this.adresaId = adresaId;
	}
	public OglasDTO(Long id, LocalDateTime odDatuma, LocalDateTime doDatuma, Long cenovnikId, Long automobilId,
			int cenaPoDanu, int popustZaPreko30Dana, int cenaCollisionDamageWaiver, int cenaPoKilometru,
			float predjenaKilometraza, float planiranaKilometraza, boolean collisionDamageWaiver, int brojSedistaZaDecu,
			LocalDateTime datumKreiranja, LocalDateTime datumIzmene, Long userId, String mesto, int postanskiBroj,
			String ulica, int broj, String nazivKlase, String nazivMarke, String nazivModela, String nazivTipaGoriva,
			String nazivMenjaca, String korisnickoIme, Long adresaId) {
		super();
		this.id = id;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.cenovnikId = cenovnikId;
		this.automobilId = automobilId;
		this.cenaPoDanu = cenaPoDanu;
		this.popustZaPreko30Dana = popustZaPreko30Dana;
		this.cenaCollisionDamageWaiver = cenaCollisionDamageWaiver;
		this.cenaPoKilometru = cenaPoKilometru;
		this.predjenaKilometraza = predjenaKilometraza;
		this.planiranaKilometraza = planiranaKilometraza;
		this.collisionDamageWaiver = collisionDamageWaiver;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
		this.datumKreiranja = datumKreiranja;
		this.datumIzmene = datumIzmene;
		this.userId = userId;
		this.mesto = mesto;
		this.postanskiBroj = postanskiBroj;
		this.ulica = ulica;
		this.broj = broj;
		this.nazivKlase = nazivKlase;
		this.nazivMarke = nazivMarke;
		this.nazivModela = nazivModela;
		this.nazivTipaGoriva = nazivTipaGoriva;
		this.nazivMenjaca = nazivMenjaca;
		this.korisnickoIme = korisnickoIme;
		this.adresaId = adresaId;
	}

	public OglasDTO() {}

}
