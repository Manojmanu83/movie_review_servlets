<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#box{
		background-color:red;
		border:2px solid black;
		height: 100px;
		width: 100px;
		margin: 5px;
	}
</style>
</head>
<body>
	<% for(int i=0; i<3;i++){ %>
	<div id="box">
		<%= i %>
	</div>
	<%} %>
	
	<h1>This is Html code</h1>
	<!-- This is Scriplet tag -->
	<% System.out.println("This is java code"); %>
	
	<!-- This is Declarative tag -->
	<!-- This is Global variable declaration -->
	<%! int a =6; %>
	
	<!-- This is local variable declaration -->
	<% int a = 10; %>
	
	<!-- This is Expression tag tag -->
	<!-- local variable value  i.e 10 -->
	<%= a %>
	
	<!-- global variable value  i.e 6 -->
	<%= this.a %>
	
	<!-- This is Comment tag -->
	<%-- <% System.out.println("This is java code"); %> --%>
	
	<!-- This is Directive tag1 -->
	<%@ page import="java.util.*" %>
	
	<!-- This is Directive tag2 -->
	<%@ include file="home.html" %>
	
	
</body>
</html>