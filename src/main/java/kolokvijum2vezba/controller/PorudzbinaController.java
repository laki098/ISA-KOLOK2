package kolokvijum2vezba.controller;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kolokvijum2vezba.Dto.PorudzbinaDto;
import kolokvijum2vezba.model.Porudzbina;
import kolokvijum2vezba.service.PorudzbinaService;

@Controller
@RequestMapping(path = "api/porudzbina")
public class PorudzbinaController {

	// @Autowired
	PorudzbinaService porudzbinaService;
	
	
//	getAll za Dto klase
	@RequestMapping(path = "/dobavi-sve", method = RequestMethod.GET)
	
	public ResponseEntity<Iterable<PorudzbinaDto>> getAll() {
		ArrayList<PorudzbinaDto> result = new ArrayList<PorudzbinaDto>();
		for (Porudzbina r:porudzbinaService.findAll()) {
			result.add(new PorudzbinaDto(r));
		}
		return new ResponseEntity<Iterable<PorudzbinaDto>>(result, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Porudzbina>> getOne(@PathVariable("id") Long id) {
		Optional<Porudzbina> k = porudzbinaService.findOne(id);
//		RobaDto result = new RobaDto(k);
		if (k == null)
			return new ResponseEntity<Optional<Porudzbina>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Optional<Porudzbina>>(k,HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<PorudzbinaDto> save(@RequestBody() Porudzbina n) {
		
		
		return new ResponseEntity<PorudzbinaDto>(new PorudzbinaDto(porudzbinaService.save(n)), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Porudzbina> remove(@PathVariable("id") Long id) {
		Optional<Porudzbina> n = porudzbinaService.findOne(id);
		if (n == null) {
			return new ResponseEntity<Porudzbina>(HttpStatus.NOT_FOUND);
		}
		porudzbinaService.remove(id);
		return new ResponseEntity<Porudzbina>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "", method = RequestMethod.PUT)
	public ResponseEntity<Optional<Porudzbina>> edit(@RequestBody() Porudzbina n) {
		Optional<Porudzbina> porudzbina = porudzbinaService.findOne(n.getId());
		if (porudzbina == null) {
			return new ResponseEntity<Optional<Porudzbina>>(HttpStatus.NOT_FOUND);
		}
		porudzbinaService.save(n);
		return new ResponseEntity<Optional<Porudzbina>>(HttpStatus.OK);
	}
}