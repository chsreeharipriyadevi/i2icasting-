<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CartPage</title>
</head>
<body>

<h2>THIS IS THE CART PAGE</h2>

<c:forEach items="${cartList}" var="cart">


<td><c:out value="${product.id}" /></td>
						<td><c:out value="${cart.id}" /></td>
						<td><c:out value="${cart.productName}" /></td>
						<td><c:out value="${product.quntity}" /></td>
						<td><c:out value="${product.productPrice}" /></td>
						

</c:forEach>


</body>
</html>