package kolokvijum2vezba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class KorisnikRola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Korisnik korisnik;

    @ManyToOne
    private Rola rola;

    public KorisnikRola() {
    }

    public KorisnikRola(Long id, Korisnik korisnik, Rola rola) {
	super();
	this.id = id;
	this.korisnik = korisnik;
	this.rola = rola;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Korisnik getKorisnik() {
	return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
	this.korisnik = korisnik;
    }

    public Rola getRola() {
	return rola;
    }

    public void setRola(Rola rola) {
	this.rola = rola;
    }

}
