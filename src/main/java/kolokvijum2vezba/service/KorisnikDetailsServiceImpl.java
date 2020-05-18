package kolokvijum2vezba.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kolokvijum2vezba.model.Korisnik;
import kolokvijum2vezba.model.KorisnikRola;

@Service
public class KorisnikDetailsServiceImpl implements UserDetailsService{
	@Autowired
	KorisnikService korisnikService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Korisnik> korisnik = korisnikService.getKorisnik(username);
//		Optional<RegistrovanaProdavnica> registrovanaProdavnica = this.findOne(Long.parseLong(id));
		
		if (korisnik.isPresent()) {
		    /**
		     * buduci da u UserDetails interfejsu imamo username, password i listu
		     * GrantedAuthority-a(interfejs koji ima metodu getAuthority koja vraca String),
		     */
		    ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		    for (KorisnikRola korisnikRola : korisnik.get().getKorisnikRole()) {
			/**
			 * kreiramo instancu klase SimpleGrantedAuthority koja implemetira
			 * GrantedAuthority interfejs i kao argument prima role tipa String
			 */
			grantedAuthorities.add(new SimpleGrantedAuthority(korisnikRola.getRola().getTitle()));
		    }

		    /**
		     * kreiramo instancu klase User, koja implmentira interfejs UserDetails i kao
		     * argumente prima username, password i listu GrantedAuthority-a, koju smo
		     * prethodno kreirali
		     */
		    return new org.springframework.security.core.userdetails.User(korisnik.get().getKorisnickoIme().toString(),
			    korisnik.get().getLozinka(), grantedAuthorities);
		}

		return null;
	    }
	

}
