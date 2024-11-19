package Movie_Data.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Movie_Data.dao.Movie_Logic;
import Movie_Data.dto.Movie_details;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Movie_Logic ml = new Movie_Logic();
		ml.delete(id);
		resp.getWriter().print("<h1>Movie Deleted Successfully</h1>");
		req.getRequestDispatcher("fetch_all_movies").include(req, resp);
	}
}
