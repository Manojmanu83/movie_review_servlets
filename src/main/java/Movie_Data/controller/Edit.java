package Movie_Data.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Movie_Data.dao.Movie_Logic;
import Movie_Data.dto.Movie_details;

@WebServlet("/edit")
public class Edit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Movie_Logic ml = new Movie_Logic();
		Movie_details details = ml.edit(id);
		req.setAttribute("movies", details);
		req.getRequestDispatcher("edit.jsp").forward(req, resp);
	}
}
