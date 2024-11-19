<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="java.util.Arrays"%>
<%@page import="Movie_Data.dto.Movie_details"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px">
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Poster</th>
			<th>Language</th>
			<th>Rating</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<% List<Movie_details> movies = (List<Movie_details>)request.getAttribute("movies"); %>
		<% for(Movie_details movie:movies ) {%>
		<tr>
			<th><%=movie.getName() %></th>
			<th><%=movie.getDescription() %></th>
			<th><img alt="<%=movie.getName() %>" height="250" width="220" src="data:image/png;base64,<%=  Base64.encodeBase64String(movie.getImage())%>"> </th>
			<th><%=Arrays.toString(movie.getLanguage()) %></th>
			<th><%=movie.getRating() %></th>
			<th> <a href="edit?id=<%=movie.getId()%>"><button>Edit</button></a> </th>
			<th> <a href="delete?id=<%=movie.getId()%>"><button>Delete</button></a> </th>
		</tr>
		<% } %>
	</table>
</body>
</html>