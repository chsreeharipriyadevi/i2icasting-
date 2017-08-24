<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CartPage</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
</head>
<body>



 <div class="container">
	<div class="row">
	
	<c:forEach items="${cartList}" var="cart">
				
		<div class="col-xs-8">
			<div class="panel panel-info">
				<div class="panel-heading"><h1>My Cart</h1></div>
				
				<div class="panel-body">
				
				<!-- PRODUCT IMAGE -->
				
						<div class="col-xs-2"><img class="img-responsive" src=""></div>
						
				<!-- PRODUCT NAME & DESCRIPTION -->	
					
						<div class="col-xs-4">
							<h4 class="productName"><strong>${cart.productName}</strong></h4>
							<h4><small>${cart.productDescription}</small></h4>
							
						</div>
				<!-- PRODUCT PRICE -->	
				
						<div class="col-xs-6">
							<div class="col-xs-6 text-right">
								<h6><strong>${cart.productPrice}<span class="text-muted">x</span></strong></h6>
							</div>
							
				<!-- PRODUCT QUANTITY -->	
							
							<div class="col-xs-4">
								<input type="text" class="form-control input-sm" value="${cart.productQuantity}">
							</div>
							
				<!-- TRASH ICON // DELETE PRODUCT -->	
							
							<div class="col-xs-2">
								<a href="removeCart/{id}"> <button type="button" class="btn btn-link btn-xs">
									<span class="glyphicon glyphicon-trash"> </span>
								</button></a>
							</div>
						</div>
			   
					<hr>
					
				 <!-- UPDATE CART FUNCTION -->
				 	
					<div class="row">
						<div class="text-center">
							<div class="col-xs-9">
								<h6 class="text-right">Added items?</h6>
							</div>
							<div class="col-xs-3">
								<button type="button" class="btn btn-default btn-sm btn-block">  
								<!-- 
								
								ADD EDITCART FUNCTIONALITY URL HERE IN THIS CODE: 
								
								<c:out value="${}"/>
								
								 -->
									Update cart
								</button>
							</div>
						</div>
					</div>
				</div></div></div>
				
				</c:forEach>
				
		      <!-- FOOTER TOTAL PRICE DISPLAY -->
				
				<div class="panel-footer">
					<div class="row text-center">
						<div class="col-xs-9">
							<h4 class="text-right">Total <strong>$50.00</strong></h4>
						</div>
						<div class="col-xs-3">
							<button type="button" class="btn btn-success btn-block"> 
							<!-- 
								
								ADD CHECKOUT PAGE URL HERE IN THIS CODE: 
								
								<c:out value="${}"/>
								
								 -->
								Checkout
							</button>
						</div>
					</div>
				</div>
			</div>
		</div> 
 
</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
 <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"> 
<link rel="stylesheet" href="<c:url value="/resources/css/cart.css"/>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CartPage</title>
<style>#myCarousel{display:none;}
#myproduct{display:none;}
</style>
</head>
<body>
<h1 align="center" style="margin-top:60px;">My Cart</h1>
${emptycart}
<div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Update</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${cartList}" var="cart">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin"><c:out value="${cart.productName }"/></h4>
									</div>
								</div>
							</td>
							<td data-th="Price"><c:out value="${cart.productPrice}"/></td>
							<td data-th="Quantity"><c:out value="${cart.productQuantity}"/></td>
							<td data-th="Quantity">
							 <c:url var="action" value="editCart/${cart.id}"></c:url>
		                       <form:form action="${action}" name="formID" modelAttribute="cart" method="post">
								<form:input type="number" class="form-control text-center" path="productQuantity" id="sel1" name="quantity" onchange="checkAndSubmit()" />
								</form:form>
							</td>
							<td data-th="Subtotal" class="text-center"><c:out value="${cart.subTotal}"/></td>
							<td class="actions" data-th="">
								<a href="removeCart/${cart.id}"><button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button></a>								
							</td>
						</tr>
						
						</c:forEach>
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total </strong></td>
						</tr>
						<tr>
							<td><a href="" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total:<c:out value="${cartprice}"></c:out> </strong></td>
							<td><a href="checkoutFlow" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
</div>



 

<script type="text/javascript">
function checkAndSubmit()
{
  if (document.getElementById('sel1').selectedIndex > -1)
  {
      document.formID.submit();
     // alert('both have been selected!');
  }
}
</script>
</body>
</html>