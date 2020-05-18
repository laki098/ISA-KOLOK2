package kolokvijum2vezba.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class StavkaPorudzbine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, columnDefinition = "text")
	private String naziv;
	@Column(nullable = false, columnDefinition = "text")
	private Double cena;
	
	@ManyToOne
	Porudzbina porudzbina;

	public StavkaPorudzbine(long id, String naziv, Double cena, Porudzbina porudzbina) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.porudzbina = porudzbina;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Porudzbina getPorudzbina() {
		return porudzbina;
	}

	public void setPorudzbina(Porudzbina porudzbina) {
		this.porudzbina = porudzbina;
	}
	
	
	
	
	
	
	
	
}
