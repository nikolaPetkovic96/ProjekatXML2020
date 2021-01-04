package com.example.LoginReg.DTO;

public class UpdateTAdresaDTO extends TAdresaDTO {
	private Long id;
	
	

	public UpdateTAdresaDTO(Long id, TAdresaDTO adresa) {
		super(adresa);
		this.id=id;
		}

	public UpdateTAdresaDTO(Long id,String mesto, String ulica, String broj, String postanskiBroj) {
		super(mesto, ulica, broj, postanskiBroj);
		this.id=id;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
