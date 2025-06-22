<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<s:set var="userId" value="\${param.user_id}" />
<div class="logout-button">
	<s:form action="logout">
		<s:submit class="btn btn-delete" value="Logout"></s:submit>
	</s:form>
</div>
<div class="main">
	<div class="container">
		<h1>Profile</h1>
		<div class="profile">
			<img src="<%=request.getContextPath()%>/images/profile.png" />

			<table class="student-table">
				<tr>
					<td class="label">Name:</td>
					<td>${studentDetails.studentName}</td>
				</tr>
				<tr>
					<td class="label">ID:</td>
					<td>${studentDetails.student_id}</td>
				</tr>
				<tr>
					<td class="label">Year:</td>
					<td>${studentDetails.year}</td>
				</tr>
				<tr>
					<td class="label">Course:</td>
					<td>${studentDetails.department}</td>
				</tr>
			</table>

		</div>

	</div>

	<div class="container">
		<h1>Dash Board</h1>
		<div class="options-flex">
			<div class="options">
				<img src="<%=request.getContextPath()%>/images/avail-book.png" />
				<s:form action="availbooksbtn">
					<s:hidden name="userId" value="%{userId}" />
					<s:submit class="btn btn-primary" value="Avail Books"></s:submit>
				</s:form>
			</div>

			<div class="options">
				<img src="<%=request.getContextPath()%>/images/track-book.webp" />
				<s:form action="trackbookbtn">
					<s:hidden name="userId" value="%{userId}" />
					<s:submit class="btn btn-primary" value="Track Book"></s:submit>
				</s:form>
			</div>
		</div>

		<div class="options-flex">
			<div class="options">
				<img src="<%=request.getContextPath()%>/images/return-book.webp" />
				<s:form action="returnbookbtn">
					<s:hidden name="userId" value="%{userId}" />
					<s:submit class="btn btn-primary" value="Return Books"></s:submit>
				</s:form>
			</div>

			<div class="options">
				<img src="<%=request.getContextPath()%>/images/fine.png" />
				<s:form action="viewFinebtn">
					<s:hidden name="userId" value="%{userId}" />
					<s:submit class="btn btn-primary" value="View Fines.."></s:submit>
				</s:form>
			</div>

		</div>

	</div>
</div>
