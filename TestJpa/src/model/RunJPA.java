package model;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import oracle.net.jdbc.TNSAddress.Address;

public class RunJPA {

	public static void main(String[] args) {
		Userdetail userDetails= new Userdetail();
		Userlogin userLogin = new Userlogin();
		Addre addres = new Addre();
		
		userLogin.setUsername("saby");
		userLogin.setPassword("saby");
		userLogin.setUserdetail(userDetails);
		
		userDetails.setFirstname("Ashok");
		userDetails.setLastname("Mukherjee");
		userDetails.setEmail("sabyam8@live.in");
		userDetails.setPhonenumber("9474540063");
		userDetails.setConstituincy("Kolkata");
		userDetails.setStatus("Registered");
		userDetails.setUserlogin(userLogin);
		userDetails.addAddre(addres);
		
		addres.setAddrline1("D 12, Mohini Apartment");
		addres.setAddrline2("Mohish Gote, Krishnapur Road");
		addres.setCity("Kolkata");
		addres.setState("WB");
		addres.setZip(new BigDecimal(700102));
		//addres.addUserdetails(userDetails);

		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestJpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = null;
		try{
			et = em.getTransaction();
			et.begin();
			em.persist(userDetails);
			et.commit();
		}catch(Exception e){
			if(et.isActive()){
				et.rollback();
			}
			throw e;	
		}

	}

}
