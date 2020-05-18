package kolokvijum2vezba.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import kolokvijum2vezba.model.StavkaPorudzbine;

@Repository
public interface StavkaPorudzbineRepository extends PagingAndSortingRepository<StavkaPorudzbine, Long> {

}
