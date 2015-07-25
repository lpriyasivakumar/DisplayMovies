<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" href ="styles/main.css" type="text/css" />
<title>Movie Display App</title>
</head>
<body>
	<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/movie_data" user="root" password="Lpriya46_"/>
	<sql:query dataSource="${ds}" var="result"> 
   	 SELECT * from categories;
	</sql:query>
	<img src = "images/poster2_resized.jpg" alt="Movie"/>
	<br>
	<h1>Movie Database</h1>
	<form action="display" method="post">		
	<label class="pad_top">Choose Category: </label>
	<select name="category">
		<option></option>
		<c:forEach var="row" items="${result.rows}">   
      		<option value =<c:out value="${row.CategoryID}"/> ><c:out value="${row.CategoryName}"/></option>
		</c:forEach>
	</select>
		<br>	
		<input type="hidden" name ="action" value="view"> 
		<input type="submit" value="Show Movies">
		<button onClick="javascript:window.location.href='index.jsp'">Home</button>
	</form>
	<br>	
	<table border = "2">
	
  	<tr>
  		<th>Movie Title</th>    	
  	</tr>
  		  <c:forEach var="c" items="${movies}">    
  	<tr>
   		 <td>${c}</td>    	
  	</tr>
 	 </c:forEach>  
	</table>
	
</body>
</html>