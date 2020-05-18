package kolokvijum2vezba.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import kolokvijum2vezba.model.Korisnik;

@Repository
public interface KorisnikRepository extends PagingAndSortingRepository<Korisnik, Long> {
//	za security
	Optional<Korisnik> getByKorisnickoIme(String korisnickoIme);
	Optional<Korisnik> getByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);

}
