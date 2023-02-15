package Onetoone;

import javax.persistence.*;

@Entity
class Person {
	@Id
	String name;
	@OneToOne
	PanCard pc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PanCard getPc() {
		return pc;
	}
	public void setPc(PanCard pc) {
		this.pc = pc;
	}
	
}
@Entity
class PanCard {
	@Id
	String panNumber;
	@OneToOne
	Person p;
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	
}

public class Driver1 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		PanCard p =new PanCard();
		p.setPanNumber("123agh");
		
	    Person per=new Person();
	    per.setName("gagan");
	    
	    p.setP(per);
	    per.setPc(p);
	    
	    entityTransaction.begin();
	    entityManager.persist(p);
	    entityManager.persist(per);
	    entityTransaction.commit();
		
	}

}
