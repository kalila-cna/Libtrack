<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="back-button">
	<s:form action="back">
		<s:submit class="btn btn-delete" value="Back"></s:submit>
	</s:form>
</div>

<div class="container">
	<h1>DeFaulters</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Defaulter Id</th>
				<th>Student Id</th>
				<th>Student Name</th>
				<th>Year</th>
				<th>Department</th>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>OverDue Days</th>
				<th>Fine Amount</th>
				<th>Fine Status</th>
			</tr>
		</thead>
		<tbody id="defaulterListContainer">
		</tbody>
	</table>
	<div id="noRecords"></div>
</div>

