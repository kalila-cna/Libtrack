<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="main">
	<div class="signup-img-div">
		<img src="<%=request.getContextPath()%>/images/sign-up.webp" />
	</div>
	<div class="container">
		<h1>Sign Up</h1>
		<s:form action="newaccountcreated">
			<div class="form-group">
				<s:textfield label="Email id" name="emailId" cssClass="form-control"
					onblur="validateEmail()" id="email-field"
					placeholder="Eg: cna.kalila@gmail.com" required="true"></s:textfield>
			</div>
			<div class="form-group">
				<s:textfield label="Full Name" name="fullName"
					cssClass="form-control" required="true"></s:textfield>
			</div>

			<div class="form-group">
				<s:select name="year" list="yearModel.years" label="Select Year"
					cssClass="form-control" />
			</div>

			<div class="form-group">
				<s:select name="department" list="departmentModel.departments"
					label="Select Department" cssClass="form-control" required="true" />
			</div>

			<div class="form-group">
				<s:password label="Password" name="password" cssClass="form-control"
					required="true"></s:password>
			</div>
			<div class="form-group">
				<s:password label="Confirm Password" name="confirmPassword"
					cssClass="form-control" required="true"></s:password>
			</div>
			<div class="form-group">
				<s:submit value="Sign Up" cssClass="btn btn-primary"></s:submit>
			</div>
		</s:form>
	</div>
</div>