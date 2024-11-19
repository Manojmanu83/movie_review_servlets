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
@WebServlet("/update-movie")
public class Update_Movie extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String name = req.getParameter("name"); 
		 String description = req.getParameter("description");
		 String[] language= req.getParameterValues("language");
		 int rating= Integer.parseInt(req.getParameter("rating"));
		 
		 int id =Integer.parseInt(req.getParameter("id"));
		 Part image = req.getPart("poster");
		 byte[] data = new byte[image.getInputStream().available()];
		 image.getInputStream().read(data);
		 
		 
		 Movie_Logic ml = new Movie_Logic();
		 Movie_details am = ml.edit(id);
		 am.setName(name);
		 am.setDescription(description);
		 am.setLanguage(language);
		 am.setRating(rating);
		 if(data.length>0)
			 am.setImage(data);

		 ml.update_movie(am); 
		 
		 
		 resp.getWriter().print("<h1>Movie Updated Successfully");
		 req.getRequestDispatcher("fetch_all_movies").include(req, resp);	 
	}
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getRequestDispatcher("add_movie.html").forward(req, resp);
//	}
}
