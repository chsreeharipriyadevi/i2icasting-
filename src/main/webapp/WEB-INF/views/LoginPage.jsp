<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:url var="actionUrl" value="j_spring_security_check" />

<form  method="post" action="${actionUrl }" class="form-horizontal" >







	<div class="form-group">
		<label for="Enter email address" class="col-xs-4 control-label">Email</label>
		<div class="col-xs-4">
			<input name="j_username" type ="text"  class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="code" class="col-xs-4 control-label">Password</label>
		<div class="col-xs-4">
			<input name="j_password" id="merocode"  type ="password" placeholder="Enter Password" maxlength="15" class="form-control" />
		</div>
	</div>



	<div class="form-group">
	<label for="code" class="col-xs-4 control-label"></label>
		
		<div class="col-xs-4">
		
			
	
		
	   <input type="submit" value="Login" id="btn-update" class="btn btn-primary" >

		
		</div>
	</div>
</form>

${error}