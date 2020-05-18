package kolokvijum2vezba.controller;

import java.util.HashMap;
import java.util.HashSet;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import kolokvijum2vezba.hibernateSession.HibernateSessionFactory;
import kolokvijum2vezba.model.Korisnik;
import kolokvijum2vezba.model.KorisnikRola;
import kolokvijum2vezba.model.Rola;
import kolokvijum2vezba.repository.KorisnikRepository;
import kolokvijum2vezba.service.KorisnikService;
import kolokvijum2vezba.utils.TokenUtils;

@Controller
@RequestMapping("/api")
public class KorisnikController {
	@Autowired
	KorisnikService userService;

	@Autowired
	KorisnikRepository ur;

	@Autowired
    private KorisnikService korisnikService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private HibernateSessionFactory hibernateSessionFactory;
	
	
	
	 @RequestMapping(path = "/register", method = RequestMethod.POST)
	    public ResponseEntity<String> register(
		    @RequestBody Korisnik korisnik) {

		korisnik.setLozinka(passwordEncoder.encode(korisnik.getLozinka()));

		this.korisnikService.save(korisnik);
		korisnik.setKorisnikRole(new HashSet<KorisnikRola>());

//		get session
		Session session = this.hibernateSessionFactory.getSession();
//		begin transaction
		session.beginTransaction();

		korisnik.getKorisnikRole()
			.add(new KorisnikRola(null, korisnik, session.get(Rola.class, 1l)));

//		commit transaction
		session.getTransaction().commit();

//		close session
		session.close();

		this.korisnikService.save(korisnik);

		return new ResponseEntity<String>(korisnik.getKorisnickoIme(), HttpStatus.OK);
	    }
	

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<HashMap<String, String>> login(@RequestBody Korisnik korisnik) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(korisnik.getKorisnickoIme(),
					korisnik.getLozinka());
			
			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			UserDetails details = userDetailsService.loadUserByUsername(korisnik.getKorisnickoIme().toString());
			String userToken = tokenUtils.generateToken(details);
			
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("token", userToken);
			
			return new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(path = "/test" ,method = RequestMethod.GET)
	@Secured("ROLE_KORISNIK") //ovo je za pristup 
	
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Test success!", HttpStatus.OK);
	}

}
