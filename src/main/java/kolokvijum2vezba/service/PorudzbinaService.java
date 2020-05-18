package kolokvijum2vezba.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import kolokvijum2vezba.model.Porudzbina;
import kolokvijum2vezba.repository.PorudzbinaRepository;

public class PorudzbinaService {
	@Autowired
	PorudzbinaRepository porudzbinaRepository;
	
	public Iterable<Porudzbina> findAll(){
		return porudzbinaRepository.findAll();
		}
	
	public Iterable<Porudzbina> findAll(Pageable pageable){
		return porudzbinaRepository.findAll(pageable);
		
	}
	public Optional<Porudzbina> findOne(Long id){
		return porudzbinaRepository.findById(id);
		}
	
	public void remove(Long id){
		porudzbinaRepository.deleteById(id);
	}
	public Porudzbina save(Porudzbina porudzbina){
		return porudzbinaRepository.save(porudzbina);

}

}
