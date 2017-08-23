<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Add page</title>
</head>
<body>
<html>
<body>
<title>Bootstrap Case</title>  
  <meta charset="utf-8">  
  <meta name="viewport" content="width=device-width, initial-scale=1">  
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
    
</head>  
<style>
body
{  background-image:""instrumental.jpg";
}
{background-color: #fff;}
.social-icon {
  list-style: none;
  padding: 0;
  margin: 0;
}
.social-icon li{
  display: inline-block;
  text-align: center;
}
.social-icon a {
  display: block;
  width: 44px;
  height: 44px;
  line-height: 44px;
  border-radius: 50%;
  margin-right: 5px;
}
.social-icon a {
  background: rgba(255, 255, 255, 0.85); /* social icon background color */
  color: #7fff00; /* social icon color */
}
.social-icon a:hover {
  background: rgba(255, 255, 255, 0.25); /* social icon hover background color */
  color: #fff; /* social icon hover color */
}
.footer {
  position: absolute;
  bottom: 0;
  padding-top: 5px;
  width: 100%;
  height: 60px;
  background-color: #7fff00;
}
</style>

<body>  

<div class="container">
<div class="page header">
<div class="row">
<div class="col-md-6">
<div class="panel with nav tabs panel-primary">
<div class="panel-heading">
ul class="nav tabs"
<li class="active"><a href="#tab1pimary" data toggle="tab">Category</a></li>
<li class="active"><a href="#tab2pimary" data toggle="tab">Supplier</a></li>
<li class="active"><a href="#tab3pimary" data toggle="tab">Product</a></li>
</div>
<div class>
<div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">BandStandLite</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Admin</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Category</a></li>
            <li><a href="#">Product</a></li>
            <li><a href="#">Supplier</a></li> 
            </li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul>
  </div>
</nav>
  ${message}
<div class="container">
  <h3>Navbar With Dropdown</h3>
  <p>This example adds a dropdown menu for the "Page 1" button in the navigation bar.</p>
</div>
<c:choose>
		<c:when test="${ProductPageClicked}">
			<c:import url="/WEB-INF/views/ProductPage.jsp"></c:import>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${CategoryPageClicked}">
			<c:import url="/WEB-INF/views/CategoryPage.jsp"></c:import>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${SupplierPageClicked}">
			<c:import url="/WEB-INF/views/SupplierPage.jsp"></c:import>
		</c:when>
	</c:choose>
</body>
</html>
            
          </ul>
        </li>
       
  </div>
</nav></div>


