<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<style>
	body{
		justify-content: center;
		align-items: center;
		display: flex;
		flex-direction: column;
		height: 100vh;
		margin: 0;
	}

</style>

<body>

		<%int i=1; %>
		<%boolean found=(boolean)request.getAttribute("found"); %>
		<%if(found==true){ %>
			<table border="2" style="width: 600px;">
		<thead>
			<tr>
				<th>SR. NO</th>
				<th>MOVIE NAME</th>
				<th>MOVIE THEATER</th>
				<th>Per Ticket price</th>
				<th>NO OF TICKET</th>
			</tr> 
		</thead>
		<tbody>
			<tr>
				<td><%=i++ %></td>
				<td><%=request.getParameter("moviename") %></td>
				<td><%=request.getParameter("movietheater") %></td>
				<td><%=request.getAttribute("Price") %></td>
				<td><%=request.getParameter("ticket") %></td>
				
			</tr>
		</tbody>
	</table>
		<h1>Your Bill : <%=request.getAttribute("result") %></h1>	
		<% }%>
			<% if(found==false){ %>
				<h1> <%=request.getAttribute("result") %></h1>
			<%} %>
			
</body>
</html>