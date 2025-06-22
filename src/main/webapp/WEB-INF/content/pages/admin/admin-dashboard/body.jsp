<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="logout-button">
	<s:form action="logout">
		<s:submit class="btn btn-delete" value="Logout"></s:submit>
	</s:form>
</div>
<div class="main">
	<div class="admin-img-div">
		<img
			src="<%=request.getContextPath()%>/images/admin-dashboard-pic.png" />
	</div>

	<div class="container">
		<h1>Dash Board</h1>
		<div class="options-flex">
			<div class="options">
				<img src="<%=request.getContextPath()%>/images/addbook.jpeg" />
				<s:form action="addbookbtn">
					<s:submit class="btn btn-primary" value="Add Books"></s:submit>
				</s:form>
			</div>

			<div class="options">
				<img src="<%=request.getContextPath()%>/images/view-students.png" />
				<s:form action="viewstudentsbtn">
					<s:submit class="btn btn-primary" value="View Students"></s:submit>
				</s:form>
			</div>

		</div>

		<div class="options-flex">
			<div class="options">
				<img src="<%=request.getContextPath()%>/images/editbook.webp" />
				<s:form action="editbookbtn">
					<s:submit class="btn btn-primary" value="Edit Books"></s:submit>
				</s:form>
			</div>

			<div class="options">
				<img src="<%=request.getContextPath()%>/images/defaulter.png" />
				<s:form action="viewDefaulterbtn">
					<s:submit class="btn btn-primary" value="View Defaulters"></s:submit>
				</s:form>
			</div>

		</div>

	</div>
</div>