<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<script>
	var userId = "${userId}";
</script>
<s:set var="userId" value="\${param.user_id}" />
<div class="back-button">
	<s:form action="backToStudentDashboard">
		<s:hidden name="userId" value="%{userId}" />
		<s:submit class="btn btn-delete" value="Back"></s:submit>
	</s:form>
</div>

<div class="container">
	<h1>Fines</h1>
	<table id="bookTable" border="1">
		<thead>
			<tr>
				<th>Book ID</th>
				<th>Name</th>
				<th>OverDue Days</th>
				<th>Fine Amount</th>
				<th>Pay Fine</th>
			</tr>
		</thead>
		<tbody id="finesContainer">
		</tbody>
	</table>
	<div id="noRecords"></div>
</div>
