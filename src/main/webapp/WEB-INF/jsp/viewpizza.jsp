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
	<table border="2" cellpadding="2">
		<tr>
			<td>Pizza name</td>
			<td>Price</td>
			<td>Type</td>
		</tr>
		<c:forEach items="${pizzas}" var="pizza">
			<tr>
				<td>${pizza.pizzaName}</td>
				<td>${pizza.price}</td>
				<td>${pizza.pizzaType}</td>
				<td>
					<form action="/pizzas/edit" method="get">
						<input type="hidden" name="id" value="${pizza.id}" /> <input
							type="submit" value="Edit" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/pizzas/create">Create</a> new pizza.
</body>
</html>