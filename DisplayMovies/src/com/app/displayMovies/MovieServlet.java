package com.app.displayMovies;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MovieDB;
import com.model.MovieTitle;

@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MovieServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = null;
		String message = "";
		int categoryID = 0;
		String url = "/index.jsp";
		action = request.getParameter("action");
		try {
			categoryID = Integer.parseInt(request.getParameter("category"));
		} catch (NumberFormatException e) {
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}

		if (action.equals("add")) {
			String title = request.getParameter("title");
			url = "/index.jsp";
			MovieTitle movie = new MovieTitle();
			movie.setCategoryID(categoryID);
			movie.setMovieTitle(title);
			message = MovieDB.add(movie) + " row(s) added.";
			request.setAttribute("message", message);

		} else if (action.equals("view")) {
			url = "/View.jsp";
			ArrayList<String> movies = MovieDB.fetchMovies(categoryID);
			request.setAttribute("movies", movies);

		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
