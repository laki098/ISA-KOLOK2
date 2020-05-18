package kolokvijum2vezba.Dto;

import kolokvijum2vezba.model.Korisnik;

public class KorisnikDto {
	private long id;
	private String korisnickoIme;
	private String lozinka;
	private PorudzbinaDto porudzbinaDTO;
	
	public KorisnikDto() {
		
		
	}
	
	public KorisnikDto(Korisnik rp) {
		this.id =rp.getId();
		this.korisnickoIme=rp.getKorisnickoIme();
		this.lozinka=rp.getLozinka();
		
		
		
		
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
	public PorudzbinaDto getPorudzbinaDTO () {
        return this.porudzbinaDTO;
    }

    public void setPorudzbinaDTO (PorudzbinaDto porudzbinaDTO) {
        this.porudzbinaDTO = porudzbinaDTO;
    }
}
