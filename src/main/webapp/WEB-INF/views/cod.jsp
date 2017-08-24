<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">

</head>
<body>

	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<form class="form-horizontal" role="form">
				<fieldset>

					<!-- Form Name -->
					<legend>Address Details</legend>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">Line
							1</label>
						<div class="col-sm-10">
							<input type="text" placeholder="Address Line 1"
								class="form-control">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">Line
							2</label>
						<div class="col-sm-10">
							<input type="text" placeholder="Address Line 2"
								class="form-control">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">City</label>
						<div class="col-sm-10">
							<input type="text" placeholder="City" class="form-control">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">State</label>
						<div class="col-sm-4">
							<input type="text" placeholder="State" class="form-control">
						</div>

						<label class="col-sm-2 control-label" for="textinput">Postcode</label>
						<div class="col-sm-4">
							<input type="text" placeholder="Post Code" class="form-control">
						</div>
					</div>



					<!-- Text input-->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">Country</label>
						<div class="col-sm-10">
							<input type="text" placeholder="Country" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="pull-right">
								<a href="Success" class="btn btn-primary"> Place Order!</a>
							</div>
						</div>
					</div>

				</fieldset>
			</form>
		</div>

	</div>





</body>
</html>