<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<h1>Shopping Cart</h1>

	<c:if test="${not empty cart}">
		<table border="2" cellpadding="2">
			<tr>
				<td>Pizza name</td>
				<td>Price</td>
				<td>Type</td>
				<td>Amount</td>
			</tr>
			<c:forEach items="${cart.cart}" var="pizza">
				<tr>
					<td>${pizza.key.pizzaName}</td>
					<td>${pizza.key.price * pizza.value}</td>
					<td>${pizza.key.pizzaType}</td>
					<td><form action="/cart/edit" method="post">
							<input type="hidden" name="pizzaId" value="${pizza.key.id}" /> <input
								type="text" name="amount" value="${pizza.value}" /> <input
								type="submit" value="Save" />
						</form></td>
					<td>
						<form action="/cart/remove" method="post">
							<input type="hidden" name="pizzaId" value="${pizza.key.id}" /> <input
								type="submit" value="Remove" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<c:out value="Total sum: ${cart.totalSum}" />
		<form method="post">
			<input type="submit" value="Place order" />
		</form>
	</c:if>
	<a href="/pizzas">Back</a>
</body>
</html>