<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.DTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<style>
		
	body{
		display: flex;
		justify-content: center;
		align-items: center;
		margin-top: 150px;
		background-color: wheat;
	}
	.con{
		width: 400px;
		height: 300px;
		background-color: silver;
		display: flex;
		justify-content: center;
		align-items: center;
		border-radius: 10px;
		margin: 10px;
	}
	select{
		margin: 10px;
		width: 300px;
	}
	input[type="submit"]{
		width: 250px;
		background-color: blue;
		height: 30px;
		margin-left: 40px;
		color:white;
	}
	input{
		margin: 10px;
		width: 300px;
	}
</style>
</head>
<body >
	<%
	   List<DTO> data =(List<DTO>)request.getAttribute("result");%>
	<% List<DTO> data1 =(List<DTO>)request.getAttribute("result");%>
	<div class="container">
		<form action="movielink">
			<label>SELECT MOVIE NAME</label>
			<br>
			<select  name="moviename" id="selectmovie">
			 	<option></option>
				<%for(DTO list:data){ %>
					<option><%=list.getMovieName() %></option>
				<%} %> 
			</select>
			<br>
			<label>SELECT MOVIE THEATER</label>
			<br>
			<select name="movietheater">
			 	<option></option>
				<%for(DTO list:data1){ %>
					<option><%=list.getMovieTheater() %></option>
				<%} %>
			</select>
			<br>
			<label>ENTER NO OF TICKET</label>
			<br>
			<input type="text" name="ticket">
			<br>
			<input type="submit" value="GET BILL">
		</form>
	</div>
</body>
</html>