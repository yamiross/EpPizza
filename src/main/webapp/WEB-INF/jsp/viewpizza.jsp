<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizzas</title>
</head>
<body>
	<h1>Pizzas</h1>
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
				<sec:authorize access="hasRole('CUSTOMER')">
					<td>
						<form method="post">
							<input type="hidden" name="pizzaId" value="${pizza.id}" /> <input
								type="text" name="amount" value="0" /> <input type="submit"
								value="Add to cart" />
						</form>
					</td>
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN')">
					<td>
						<form action="/pizzas/edit" method="get">
							<input type="hidden" name="pizzaId" value="${pizza.id}" /> <input
								type="submit" value="Edit" />
						</form>
					</td>
				</sec:authorize>
			</tr>
		</c:forEach>
	</table>
	<sec:authorize access="hasRole('ADMIN')">
		<a href="/pizzas/create">Create</a> new pizza.
	<br />
		<a href="/orders">View</a> all orders.
	</sec:authorize>
	<sec:authorize access="hasRole('CUSTOMER')">
		<a href="/profile/cart">Shopping Cart</a>
		<br />
		<a href="/profile/orders">View</a> orders.
	</sec:authorize>
</body>
</html>