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
	<form method="post">
		<table>
			<tr>
				<td>Pizza name</td>
				<td>Price</td>
				<td>Type</td>
			</tr>
			<tr>
				<td><input type="text" name="pizzaName" value="${pizza.pizzaName}" /></td>
				<td><input type="text" name="price" value="${pizza.price}" /></td>
				<td><select name="pizzaType">
						<c:forEach items="${pizzaTypes}" var="type">
							<option value="${type}"
								<c:if test="${pizza.pizzaType eq type}">selected</c:if>>${type}</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<input type="hidden" name="id" value="${pizza.id}" />
		<input type="submit" value="Edit!" />
	</form>
	<a href="/pizzas">Back</a> to the list
</body>
</html>