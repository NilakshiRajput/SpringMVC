<%@page import="java.util.ArrayList"%>
<%@page import="com.tcs.ilp.bean.Menu"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		ArrayList<Menu> menulist = (ArrayList<Menu>) request.getAttribute("menulist");  %>
	
	<table border="1"  height="50%" width="100%" cellpadding="10" cellspacing="0">
	<h1>Veg Items are : </h1>
	<tr bgcolor="lightgreen">
				<td>MenuID</td>
				<td>MenuName</td>
				<td>Cost</td>
				<td>Status</td>
				<td>Action</td>
	</tr>
	
		
		

		<%  for (Menu m : menulist) {
			if (m.getType().equals("veg")) { %>
				
				
				<tr>
				
				<td><% out.print(m.getMenuId()); %></td>
				<td><% out.print(m.getMenuName());%></td>
				<td><%out.print(m.getCost());%></td>
				<td><%out.print(m.getStatus());%></td>
				
				<% if(m.getStatus().equals("NA")){ %>
					<td><a href="MenuController?source=delete&id=<%out.print(m.getMenuId());%>">delete</a></td></tr>
					
				<% }
				else if(m.getStatus().equals("Available")){ %>
					<td><%out.print("NA");%></td></tr>
				<% } %>
				
				
			<% }
		} %>
		 
		  </table>
		  
		  
		  <table  border="1"   height="50%" width="100%" cellpadding="10" cellspacing="0">
	<h1>Non Veg Items are : </h1>
	<tr bgcolor="red">
				<td>MenuID</td>
				<td>MenuName</td>
				
				<td>Cost</td>
				<td>Status</td>
				<td>Action</td>
	</tr>
	
		
		

		<%  for (Menu m : menulist) {
			if (m.getType().equals("nonveg")) { %>
				
			
				<tr>
				<td><% out.print(m.getMenuId()); %></td>
				<td><% out.print(m.getMenuName());%></td>
				<td><%out.print(m.getCost());%></td>
				<td><%out.print(m.getStatus());%></td>
				
				<% if(m.getStatus().equals("NA")){ %>
					<td><a href="MenuController?source=delete&id=<%out.print(m.getMenuId());%>">delete</a></td></tr>
					
				<% }
				else if(m.getStatus().equals("Available")){ %>
					<td><%out.print("NA");%></td>
				<% } %>
				
				
			<% }
		} %>
		 
		  </table>


</body>
</html> 