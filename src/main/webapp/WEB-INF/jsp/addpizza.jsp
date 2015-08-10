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
	<form action="create" method="post">
		<table>
			<tr>
				<td>Pizza name</td>
				<td>Price</td>
				<td>Type</td>
			</tr>
			<tr>
				<td><input type="text" name="pizzaName" /></td>
				<td><input type="text" name="price" /></td>
				<td><select name="pizzaType" >
				<c:forEach items="${pizzaTypes}" var="type">
					<option value="${type}">${type}</option>
				</c:forEach>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="Add"/>
	</form>
</body>
</html>