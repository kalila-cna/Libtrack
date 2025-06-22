<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="back-button">
	<s:form action="back">
		<s:submit class="btn btn-delete" value="Back"></s:submit>
	</s:form>
</div>
<div class="main">

	<div class="container">
		<h1>Student Details</h1>
		<table id="studentTable" border="1">
			<thead>
				<tr>
					<th>Student ID</th>
					<th>Name</th>
					<th>Year</th>
					<th>Department</th>
				</tr>
			</thead>
			<tbody id="studentListContainer">
			</tbody>
		</table>
	</div>
</div>