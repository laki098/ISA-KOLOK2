package kolokvijum2vezba.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kolokvijum2vezba.model.Korisnik;
import kolokvijum2vezba.repository.KorisnikRepository;

@Service
public class KorisnikService {
	@Autowired
	KorisnikRepository korisnikRepository;
	
	public Iterable<Korisnik> findAll(){
		return korisnikRepository.findAll();
		}
	
	public Iterable<Korisnik> findAll(Pageable pageable){
		return korisnikRepository.findAll(pageable);
		
	}
	public Optional<Korisnik> findOne(Long id){
		return korisnikRepository.findById(id);
		}
	
	public void remove(Long id){
		korisnikRepository.deleteById(id);
	}
	public Korisnik save(Korisnik korisnik){
		return korisnikRepository.save(korisnik);
	}
		
//	dve funkcije za security
	public Optional<Korisnik> getKorisnik(String korisnickoIme) {
			return korisnikRepository.getByKorisnickoIme(korisnickoIme);
		}
		
	public Optional<Korisnik> getKorisnik(String korisnickoIme, String lozinka) {
			return korisnikRepository.getByKorisnickoImeAndLozinka(korisnickoIme, lozinka);
		}

}


