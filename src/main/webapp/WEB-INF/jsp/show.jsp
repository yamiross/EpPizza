<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="edit" method="get">
		<table border="2">
			<tr>
				<td>Id</td>
				<td>Pizza name</td>
				<td>Price</td>
				<td>Type</td>
			</tr>

			<c:forEach items="${pizzas}" var="pizza">
				<tr>
					<td><c:out value="${pizza.id}" /></td>
					<td><c:out value="${pizza.pizzaName}" /></td>
					<td><c:out value="${pizza.price}" /></td>
					<td><c:out value="${pizza.pizzaType}" /></td>
					<td><button type="submit" name="id" value="${pizza.id}">Edit</button>
				</tr>
			</c:forEach>
		</table>
	</form>
	<a href="create">Add</a> new pizza.
</body>
</html>