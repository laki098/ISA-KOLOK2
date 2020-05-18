package kolokvijum2vezba.Dto;



import kolokvijum2vezba.model.StavkaPorudzbine;

public class StavkaPorudzbineDto {
	private Long id;
	private String naziv;
	private Double cena; 
	
	
	public StavkaPorudzbineDto() {
		
	}
	
	public StavkaPorudzbineDto(StavkaPorudzbine stavkaPorudzbine) {
		this.id = stavkaPorudzbine.getId();
		this.naziv = stavkaPorudzbine.getNaziv();
		this.cena = stavkaPorudzbine.getCena(); 
	}

//	public RobaDto(Optional<Roba> k) {
//		// TODO Auto-generated constructor stub
//		this.id =k.get().getId();
//		this.naziv =k.get().getNaziv();
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}
	
	
}
