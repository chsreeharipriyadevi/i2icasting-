
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Checkout</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

	<!-- NAVBAR START -->

	<nav class="navbar navbar-inverse">
	<div class="container-fluid"></div>

	<div class="navbar-header">
		<a class="navbar-brand" href="/">i2iCasting</a>
	</div>

	<form class="navbar-form navbar-left">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Search">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
	<ul class="nav navbar-nav navbar-right">

		<sec:authorize access="isAuthenticated()">
			<li><a href="home"><span class="glyphicon glyphicon-user">
						Welcome:<sec:authentication property="principal.username" />
				</span></a></li>
		</sec:authorize>

		<sec:authorize access="!isAuthenticated()">
			<li><a href="register"><span
					class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
		</sec:authorize>

		<sec:authorize access="isAuthenticated()">
			<li><a href="yourCart" id="cart-popover" class="btn"
				data-placement="bottom" title="Cart"> Cart <span
					class="glyphicon glyphicon-shopping-cart"></span></a></li>
		</sec:authorize>

		<sec:authorize access="isAuthenticated()">
			<li><a href="<c:url value="j_spring_security_logout" />">Logout</a></li>
		</sec:authorize>

	</ul>

	</nav>

	<!-- NAVBAR END -->

	<!-- CHECKOUT PROCESS START -->

	<div class='container'>
		<div class='row' style='padding-top: 25px; padding-bottom: 25px;'>
			<div class='col-md-12'>
				<div id='mainContentWrapper'>
					<div class="col-md-8 col-md-offset-2">
						<h2 style="text-align: center;">Review Your Order</h2>
						
						<div class="shopping_cart">
							<form class="form-horizontal" role="form" action="" method="post" id="payment-form">
								<div class="panel-group">
								
								<!-- CHECKOUT PROCESS 1 -->
						
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse"
													href="#collapseOne">Review Your Order</a>
											</h4>
										</div>
										<div id="collapseOne" class="panel-collapse collapse in">
											<div class="panel-body">
												<h1 align="center">Cart</h1>

												<table id="cart">
													<thead>
														<tr>
															<th>Product</th>
															<th>Quantity</th>
															<th class="text-center">Price</th>

															<th></th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${cartList}" var="cart">
															<tr>
																<td data-th="Product">
																	<div class="row">
																		<div class="img-thumbnail, col-sm-2 hidden-xs">
																			<img
																				src=""
																				alt="Product Image" width="50" height="70">
																		</div>

																		<div class="col-sm-10">
																			<h4 class="nomargin">
																				<c:out value="${cart.cartProductName }" />
																			</h4>
																		</div>
																	</div>
																</td>

																<!-- ITEM QUANTITY EDITABLE -->
																<td data-th="Quantity" class="col-md-1"
																	style="text-align: center"><input type="text"
																	class="form-control" value="${cart.cartQuantity }"
																	id="exampleInputEmail1"> <c:url var="action"
																		value="saveorupdate/${cart.cartId}"></c:url> <form:form
																		action="${action}" name="formID" modelAttribute="cart"
																		method="post">
																	</form:form></td>

																<!-- ITEM PRICE -->
																<td data-th="Price"><strong><c:out
																			value="Rs.${cart.cartPrice }" /></strong></td>

															</tr>
														</c:forEach>
														<hr>
														<tr>
															<td> </td>
															<td> </td>
															<td> </td>
															<td><h5>Subtotal</h5></td>
															<td class="text-right"><h5>
																	<strong><c:out value="${cartPrice}"></c:out></strong>
																</h5></td>
														</tr>

													</tbody>
													<tfoot>

														<tr>
														   <td><a href="Cart"
															class="btn btn-success btn-block"> Go Back</a></td>
														   <td colspan="2" class="hidden-xs"></td>
														
															<td><a href="billing"
																class="btn btn-success btn-block">Continue</a></td>
														</tr>
													</tfoot>
												</table>

												<hr>
												
											</div>
										</div>

									</div>
								</div>
						</div>
					</div>
				</form>
				</div>
			</div>
		</div>
		</div>

		<!-- BOOTSNIPP CHECKOUT PROCESS END -->
</body>
</html>