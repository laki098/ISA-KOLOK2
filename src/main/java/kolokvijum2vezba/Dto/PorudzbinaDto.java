package kolokvijum2vezba.Dto;

import java.time.LocalDateTime;

import kolokvijum2vezba.model.Porudzbina;


public class PorudzbinaDto {
	private Long id;
	private String brojPorudzbine;
	private Long restoran; 
	private LocalDateTime datumPorudzbine; 
	private String status; 
	
	public PorudzbinaDto() {
		
	}
	
	public PorudzbinaDto(Porudzbina porudzbina) {
		this.id = porudzbina.getId();
		this.brojPorudzbine = porudzbina.getBrojPorudzbine();
		this.restoran = porudzbina.getRestoran(); 
		this.datumPorudzbine = porudzbina.getDatumPorudzbine(); 
		this.status = porudzbina.getStatus(); 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrojPorudzbine() {
		return brojPorudzbine;
	}

	public void setBrojPorudzbine(String brojPorudzbine) {
		this.brojPorudzbine = brojPorudzbine;
	}
	
	public Long getRestoran() {
		return restoran;
	}

	public void setRestoran(Long restoran) {
		this.restoran = restoran;
	}

	public LocalDateTime getDatumPorudzbine() {
		return datumPorudzbine;
	}

	public void setDatumPorudzbine(LocalDateTime datumPorudzbine) {
		this.datumPorudzbine = datumPorudzbine;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
