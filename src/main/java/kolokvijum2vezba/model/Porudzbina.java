package kolokvijum2vezba.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Porudzbina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, columnDefinition = "text")
	private String brojPorudzbine;
	
	@Column(nullable = false, columnDefinition = "text")
	private Long restoran;
	
	@Column(nullable = false, columnDefinition = "text")
	private LocalDateTime datumPorudzbine;
	
	@Column(nullable = false, columnDefinition = "text")
	private String status;
	
	@ManyToOne
	Korisnik korisnik;
	
	@OneToMany(mappedBy = "porudzbina",cascade = CascadeType.REMOVE)
	private List<StavkaPorudzbine> stavkaPorudzbine;

	public Porudzbina(long id, String brojPorudzbine, Long restoran, LocalDateTime datumPorudzbine, String status,
			Korisnik korisnik, List<StavkaPorudzbine> stavkaPorudzbine) {
		super();
		this.id = id;
		this.brojPorudzbine = brojPorudzbine;
		this.restoran = restoran;
		this.datumPorudzbine = datumPorudzbine;
		this.status = status;
		this.korisnik = korisnik;
		this.stavkaPorudzbine = stavkaPorudzbine;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<StavkaPorudzbine> getStavkaPorudzbine() {
		return stavkaPorudzbine;
	}

	public void setStavkaPorudzbine(List<StavkaPorudzbine> stavkaPorudzbine) {
		this.stavkaPorudzbine = stavkaPorudzbine;
	}


	
	
	
	
	

}
