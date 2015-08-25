<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Orders</title>
</head>
<body>
	<h1>My Orders</h1>
	<table border="2" cellpadding="2">
		<tr>
			<td>Order Id</td>
			<td>Pizzas</td>
			<td>Amount</td>
			<td>Total price</td>
		</tr>
		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.id}</td>
				<td><table>
						<c:forEach items="${order.pizzas}" var="pizza">
							<tr>
								<td>${pizza.key.pizzaName}</td>
							</tr>
						</c:forEach>
					</table></td>
				<td><table>
						<c:forEach items="${order.pizzas}" var="pizza">
							<tr>
								<td>${pizza.value}</td>
							</tr>
						</c:forEach>
					</table></td>
				<td>${order.price}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/pizzas">Back</a> to store.
</body>
</html>