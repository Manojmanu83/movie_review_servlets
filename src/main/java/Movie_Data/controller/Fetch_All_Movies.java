package Movie_Data.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Movie_Data.dao.Movie_Logic;
import Movie_Data.dto.Movie_details;

@WebServlet("/fetch_all_movies")
public class Fetch_All_Movies extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("add_moviesclone");
		 EntityManager manager = factory.createEntityManager();
		 EntityTransaction transaction = manager.getTransaction();
		 
		 List<Movie_details> movies =manager.createQuery("select x from Movie_details x").getResultList();
		 if(movies.isEmpty())
		 {
			 resp.getWriter().print("<h1>NO Movies Found</h1>");
			 req.getRequestDispatcher("home.html").include(req, resp);
		 }
		 else {
			 req.setAttribute("movies", movies);
			 req.getRequestDispatcher("fetch_all_movies.jsp").include(req, resp);
		 }
	}
}
