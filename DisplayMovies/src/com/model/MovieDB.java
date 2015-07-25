package com.model;

import java.sql.*;
import java.util.ArrayList;

public class MovieDB {

	static final String host = "jdbc:mysql://localhost:3306/movie_data";
	static final String userName = "root";
	static final String pass = "*********";
	static Connection conn;
	static Statement stmt;

	public static int add(MovieTitle movie) {
		conn = null;
		stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host, userName, pass);
			stmt = conn.createStatement();
			String sql = "INSERT INTO movietitles(Movie_Title,CategoryID) VALUES('" + movie.getMovieTitle() + "','"
					+ movie.getCategoryID() + "')";
			return stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return 0;

	}

	// public static int fetchCategoryID(String category) {
	// Connection conn = null;
	// Statement stmt = null;
	// int categoryID = 0;
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	// conn = DriverManager.getConnection(host, userName, pass);
	// stmt = conn.createStatement();
	// String selectquery = "SELECT CategoryID FROM categories WHERE
	// CategoryName ='" + category + "'";
	// ResultSet rs = stmt.executeQuery(selectquery);
	// if (rs.next()) {
	// categoryID = rs.getInt("CategoryID");
	// }
	//
	// } catch (SQLException se) {
	// se.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// if (stmt != null)
	// conn.close();
	// } catch (SQLException se) {
	// se.printStackTrace();
	// }
	// }
	//
	// return categoryID;
	// }

	public static ArrayList<String> fetchMovies(int categoryID) {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<String> titles = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host, userName, pass);
			stmt = conn.createStatement();
			String selectquery = "SELECT Movie_Title FROM movietitles WHERE CategoryID ='" + categoryID + "'";
			ResultSet rs = stmt.executeQuery(selectquery);
			while (rs.next()) {
				titles.add(rs.getString("Movie_Title"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return titles;

	}

}
