package kolokvijum2vezba.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @OneToMany(mappedBy = "rola")
    private Set<KorisnikRola> korisnikRola;

    public Rola() {

    }

    public Rola(Long id, String title, Set<KorisnikRola> korisnikRola) {
	super();
	this.id = id;
	this.title = title;
	this.korisnikRola = korisnikRola;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public Set<KorisnikRola> getKorisnikRola() {
	return korisnikRola;
    }

    public void setKorisnikRola(Set<KorisnikRola> korisnikRola) {
	this.korisnikRola = korisnikRola;
    }

}
