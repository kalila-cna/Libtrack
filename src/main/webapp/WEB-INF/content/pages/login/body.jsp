<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<script>
	let successMessage = "<s:property value='actionMessages[0]' default=''/>";
	if (successMessage != '') {
		alert(successMessage);
	}
</script>
<div class="main">
	<div class="home-img-div">
		<img src="<%=request.getContextPath()%>/images/home.png" />
	</div>

	<div class="container">
		<h1>Login</h1>
		<s:form action="login">
			<div class="form-group">

				<s:textfield label="Email ID" name="emailId" cssClass="form-control"
					placeholder="Eg: cna.kalila@gmail.com" id="email-field"
					onblur="validateEmail()" required="true"></s:textfield>
			</div>
			<div class="form-group">
				<s:password label="Password" name="password" cssClass="form-control"
					required="true"></s:password>
			</div>
			<div>
				<s:submit value="Login Account" cssClass="btn btn-primary"></s:submit>
			</div>

		</s:form>

	</div>
</div>
