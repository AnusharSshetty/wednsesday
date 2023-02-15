package Onetomanyandmanytoone;
import java.util.*;

import javax.persistence.*;

@Entity
class Student {
	@Id
	String Sname;
	@OneToMany
	List<Insta> i;
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public List<Insta> getI() {
		return i;
	}
	public void setI(List<Insta> i) {
		this.i = i;
	}
	
}
@Entity
class Insta {
	@Id
	String Iname;
	@ManyToOne
	Student t;
	public String getIname() {
		return Iname;
	}
	public void setIname(String iname) {
		Iname = iname;
	}
	public Student getT() {
		return t;
	}
	public void setT(Student t) {
		this.t = t;
	}
	
}

public class Driver2 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student s=new Student();
		s.setSname("shalini"); 
		
		Insta i=new Insta();
		i.setIname("madhu");
		i.setT(s);
		
		Insta i2=new Insta();
		i2.setIname("suchii");
		i2.setT(s);
		
		Insta i3=new Insta();
		i3.setIname("chethu");
		i3.setT(s);
		
		List<Insta>l=new ArrayList<Insta>();
		l.add(i3);
		l.add(i2);
		l.add(i);
		
		s.setI(l);
		
		entityTransaction.begin();
		entityManager.persist(s);
		entityManager.persist(i);
		entityManager.persist(i2);
		entityManager.persist(i3);
		entityTransaction.commit();
		
	}

}

