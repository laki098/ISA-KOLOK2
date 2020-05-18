package kolokvijum2vezba.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;



@Entity
public class Korisnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, columnDefinition = "text")
	private String korisnickoIme;
	@Column(nullable = false, columnDefinition = "text")
	private String lozinka;
	

	@OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL)
    private Set<Porudzbina> porudzbina;

	@OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL)
    private Set<KorisnikRola> korisnikRole;

	public Korisnik(long id, String korisnickoIme, String lozinka, Set<Porudzbina> porudzbina,
			Set<KorisnikRola> korisnikRole) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.porudzbina = porudzbina;
		this.korisnikRole = korisnikRole;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public Set<Porudzbina> getPorudzbina() {
		return porudzbina;
	}

	public void setPorudzbina(Set<Porudzbina> porudzbina) {
		this.porudzbina = porudzbina;
	}

	public Set<KorisnikRola> getKorisnikRole() {
		return korisnikRole;
	}

	public void setKorisnikRole(Set<KorisnikRola> korisnikRole) {
		this.korisnikRole = korisnikRole;
	}


	
}
