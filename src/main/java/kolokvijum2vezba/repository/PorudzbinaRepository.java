package kolokvijum2vezba.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import kolokvijum2vezba.model.Porudzbina;

@Repository
public interface PorudzbinaRepository extends PagingAndSortingRepository<Porudzbina, Long> {

}
