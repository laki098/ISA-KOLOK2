package kolokvijum2vezba.hibernateSession;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManagerFactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")

public class HibernateSessionFactory {

    private SessionFactory hibernateFactory;

    public SessionFactory getHibernateFactory() {
	return this.hibernateFactory;
    }

    public void setHibernateFactory(SessionFactory hibernateFactory) {
	this.hibernateFactory = hibernateFactory;
    }

    public Session getSession() {
	Session session;
	try {
	    session = this.hibernateFactory.getCurrentSession();
	} catch (HibernateException e) {
	    session = this.hibernateFactory.openSession();
	}

	return session;
    }

    @Autowired
    public void setSessionFactory(EntityManagerFactory factory) {
	if (factory.unwrap(SessionFactory.class) == null) {
	    throw new NullPointerException("factory is not a hibernate factory");
	}
	this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }

    @PreDestroy
    public void onDestroy() {
	this.hibernateFactory.close();
    }

}