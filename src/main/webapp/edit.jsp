<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="Movie_Data.dto.Movie_details"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        form{
            width: 200px;
        }
        fieldset{
            background-color: darkorchid;
        }
        fieldset div{
            padding: 10px;
        }
        fieldset h1{
            text-align: center;
        }
        #name{
            width: 250px;
        }
        #submit{
            text-align: center;
        }
        #submit input{
           background-color: rgb(88, 88, 217);
           width: 120px;
           font-size: 20px;
           padding: 4px;
           border: none;
           border-radius: 10px;
        }
    </style>

</head>
<body>
	<% Movie_details movie = (Movie_details) request.getAttribute("movies"); %>
	<form action="update-movie" method="post" enctype="multipart/form-data">
        <fieldset>
            <h1>ADD MOVIES</h1>
            <legend>ADD MOVIES</legend>
            <div>
                <input id="movid" type="hidden" name="id" readonly value="<%= movie.getId()%>">
            </div>
            <div>
                <input id="name" type="text" name="name" placeholder="Enter your name" value="<%= movie.getName()%>">
            </div>
            <div>
                 <textarea name="description" id="" cols="32" rows="4" placeholder="Enter description"><%= movie.getDescription()%></textarea>
            </div>
            <div>
                <input type="file" name="poster">
                <img alt="<%=movie.getName() %>" height="250" width="220" 
                src="data:image/png;base64,<%=Base64.encodeBase64String(movie.getImage())%>">
            </div>
            <div>
                <input type="checkbox" name="language" value="Kannada" placeholder="Language">Kannada
                <input type="checkbox" name="language" value="English" placeholder="Language">English
                <input type="checkbox" name="language" value="Tamil" placeholder="Language">Tamil
            </div>
            <div>
                <input type="number" name="rating" placeholder="Provide Rating" value="<%=movie.getRating()%>">
            </div>
            <div id="submit">
                <button>Update</button>
            </div>
        </fieldset>
    </form>
</body>
</html>