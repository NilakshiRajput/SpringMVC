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
	<table>
		<tr><jsp:include page="Header.jsp" />
		</tr>
		<table border="1">

			<h2>Veg list</h2>
		
			<tr>
				<td>MenuID</td>
				<td>MenuName</td>
				<td>Category</td>
				<td>Cost</td>
				<td>Status</td>
				<td>Action</td>
			</tr>
			<%
				ArrayList<Menu> menulist = (ArrayList<Menu>) request.getAttribute("menulist");

				for (Menu m : menulist) {
					if (m.getType().equals("veg")) {
			%>

			<tr>
				<td>
					<%
						out.print(m.getMenuId());
					%>
				</td>
				<td>
					<%
						out.print(m.getMenuName());
					%>
				</td>
				<td>
					<%
						out.print(m.getCategory());
					%>
				</td>
				<td>
					<%
						out.print(m.getCost());
					%>
				</td>
				<td>
					<%
						out.print(m.getStatus());
					%>
				</td>

	<% if(m.getStatus().equals("Available")) {%>
				<td>NA</td>
				<%} %>
				
				<% if(m.getStatus().equals("NA")) {%>
				<td><a href="">delete</a></td></tr>
				<%} } %>








			
		</table>
		<h2>Non veg list</h2>
		<table border="2">

			<tr>
				<td>MenuID</td>
				<td>MenuName</td>
				<td>Category</td>
				<td>Cost</td>
				<td>Status</td>
				<td>Action</td>
			</tr>


		<%
		

			if (m.getType().equals("nonveg")) {
		%>
		


			<tr>
				<td>
					<%
						out.print(m.getMenuId());
					%>
				</td>
				<td>
					<%
						out.print(m.getMenuName());
					%>
				</td>
				<td>
					<%
						out.print(m.getCategory());
					%>
				</td>
				<td>
					<%
						out.print(m.getCost());
					%>
				</td>
				<td>
					<%
						out.print(m.getStatus());
					%>
				</td>


				<% if(m.getStatus().equals("Available")) {%>
				<td>NA</td>
				<%} %>
				
				<% if(m.getStatus().equals("NA")) {%>
				<td><a href="">delete</a></td></tr>
				<%} }%>




		<%
			
				}
			
		%>



				



			
		</table>









		<tr><jsp:include page="footer.jsp" />
		</tr>
</body>
</html>