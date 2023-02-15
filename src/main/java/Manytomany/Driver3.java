package Manytomany;
import java.util.*;

import javax.persistence.*;

@Entity
class TouristPlace {
	@Id
	String place;
	@ManyToMany
	List<Traveller>t;
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public List<Traveller> getT() {
		return t;
	}
	public void setT(List<Traveller> t) {
		this.t = t;
	}
	
}
@Entity
class Traveller {
	@Id
	String tname;
	@ManyToMany
	List<TouristPlace>tp;
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public List<TouristPlace> getTp() {
		return tp;
	}
	public void setTp(List<TouristPlace> tp) {
		this.tp = tp;
	}
	
}
public class Driver3 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		TouristPlace a=new TouristPlace();
		a.setPlace("delhi");
		
		TouristPlace a2=new TouristPlace();
		a2.setPlace("sagara");
		
		TouristPlace a3=new TouristPlace();
		a3.setPlace("honnavara");
		
		List<TouristPlace>l=new ArrayList<TouristPlace>();
		l.add(a3);
		l.add(a2);
		l.add(a);
		
		Traveller b=new Traveller();
		b.setTname("pammi");
		
		Traveller b2=new Traveller();
		b2.setTname("virat");
		
		Traveller b3=new Traveller();
		b3.setTname("punith");
		
		List<Traveller>l2=new ArrayList<Traveller>();
		l2.add(b3);
		l2.add(b2);
		l2.add(b);
		
		a.setT(l2);
		a2.setT(l2);
		a3.setT(l2);
		
		b.setTp(l);
		b.setTp(l);
		b.setTp(l);
		
		entityTransaction.begin();
		entityManager.persist(a);
		entityManager.persist(a2);
		entityManager.persist(a3);
		
		entityManager.persist(b);
		entityManager.persist(b2);
		entityManager.persist(b3);
		entityTransaction.commit();
	}

}
