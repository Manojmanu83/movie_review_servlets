package Movie_Data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Movie_Data.dto.Movie_details;

public class Movie_Logic {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("add_moviesclone");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	public void add_movie(Movie_details md) {
		transaction.begin();
		manager.persist(md);
		transaction.commit();
	}
	
	public void delete(int id) {
		Movie_details det = manager.find(Movie_details.class, id);
		transaction.begin();
		manager.remove(det);
		transaction.commit();
	}

	public Movie_details edit(int id) {
	Movie_details edit = manager.find(Movie_details.class, id);
	return edit;
	}

	public void update_movie(Movie_details am) {
		transaction.begin();
		manager.merge(am);
		transaction.commit();
	}
	
}
