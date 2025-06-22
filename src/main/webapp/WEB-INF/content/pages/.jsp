<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign Up</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/createaccount.css">
</head>
<body>
	<s:include value="header.jsp"></s:include>
	<div class="container">
		<h1>Create Account</h1>
		<s:form action="newaccountcreated">
			<div class="form-group">
				<s:textfield label="User Name" name="name" cssClass="form-control"></s:textfield>
			</div>
			<div class="form-group">
				<s:textfield label="Full Name" name="fullname"
					cssClass="form-control"></s:textfield>
			</div>
			<div class="form-group">
				<s:password label="Password" name="password" cssClass="form-control"></s:password>
			</div>
			<div class="form-group">
				<s:password label="Confirm Password" name="confirmPassword"
					cssClass="form-control"></s:password>
			</div>
			<div class="form-group">
				<s:submit value="Create Account" cssClass="btn btn-primary"></s:submit>
			</div>
		</s:form>
	</div>
</body>
</html>