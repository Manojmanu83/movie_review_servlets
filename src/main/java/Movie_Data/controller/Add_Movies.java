package Movie_Data.controller;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Movie_Data.dao.Movie_Logic;
import Movie_Data.dto.Movie_details;

@MultipartConfig
@WebServlet("/add_movie")
public class Add_Movies extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String name = req.getParameter("name"); 
		 String description = req.getParameter("description");
		 String[] language= req.getParameterValues("language");
		 int rating= Integer.parseInt(req.getParameter("rating"));
		 Part image = req.getPart("poster");
		 byte[] data = new  byte[image.getInputStream().available()];
		 image.getInputStream().read(data);
		 
		 Movie_details am = new Movie_details();
		 am.setName(name);
		 am.setDescription(description);
		 am.setImage(data);
		 am.setLanguage(language);
		 am.setRating(rating);
		 Movie_Logic ml = new Movie_Logic();
		 ml.add_movie(am); 
		 resp.getWriter().print("<h1>Movie added Successfully");
		 req.getRequestDispatcher("add_movie.html").include(req, resp);	 
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("add_movie.html").forward(req, resp);
	}
}
