<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/main.css" type="text/css" />
<title>Movie Display App</title>
</head>
<body>
	<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/movie_data" user="root"
		password="*****" />
	<sql:query dataSource="${ds}" var="result"> 
   	 SELECT * from categories;
	</sql:query>
	<label>${message}</label>
	<br>
	<img src="images/poster2_resized.jpg" alt="Movie" />
	<br>
	<h1>Movie Database</h1>
	<br>
	<form action="display" method="post">
		<label class="pad_top">Movie Title: </label> <input type="text"
			name="title" value=""> <br> <br> <label
			class="pad_top">Category: </label> <select name="category">
			<option></option>
			<c:forEach var="row" items="${result.rows}">
				<option value=<c:out value="${row.CategoryID}"/>><c:out
						value="${row.CategoryName}" /></option>
			</c:forEach>
		</select> <br>
		<br> <input type="hidden" name="action" value="add"> <input
			type="submit" value="Add Movies">
	</form>
	<br>
	<button onClick="javascript:window.location.href='View.jsp'">View
		Movies</button>

</body>
</html>