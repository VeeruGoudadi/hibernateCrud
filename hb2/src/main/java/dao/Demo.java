package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Sample;

public class Demo {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void addStd(int id,String name,String city)
	{
		Sample sample=new Sample();
		sample.setId(id);
		sample.setName(name);
		sample.setCity(city);
		entityTransaction.begin();
		entityManager.persist(sample);
		entityTransaction.commit();
	}
	public void updateStd(int id,String name)
	{
		Sample e=entityManager.find(Sample.class, id);
		if (e!=null) {
		e.setName(name);
		entityTransaction.begin();
		entityManager.merge(e);
		entityTransaction.commit();
		}else {
			System.out.println("Data not found");
		}
	}
	
	public void fetchStd(int id)
	{
		Sample e=entityManager.find(Sample.class, id);
		if (e!=null) 
		{
			System.out.println(e);
			
		} else {
			System.out.println("Data not found");

		}
	}
	public void removeStd(int id)
	{
		Sample e=entityManager.find(Sample.class, id);
		if (e!=null) 
		{
			entityTransaction.begin();
			entityManager.remove(e);
			entityTransaction.commit();
		}else{
			System.out.println("Data not found");
		}
	}
	public void fetchAll()
	{
		Query e=entityManager.createQuery("select a from Sample a");
		if (e!=null) 
		{
			List<Sample>l=e.getResultList();
			for (Sample q : l) 
			{
				System.out.println(q);	
			}
		} else {
			System.out.println("Data not found");
		}
	}
	public void removeAll()
	{
		Query e=entityManager.createQuery("delete from Sample");
		if (e!=null) 
		{
			entityTransaction.begin();
			e.executeUpdate();
			entityTransaction.commit();
			
		} else {
			System.out.println("Data not found");
		}
	}
}