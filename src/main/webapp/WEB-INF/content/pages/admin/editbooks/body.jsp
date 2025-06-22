<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="back-button">
	<s:form action="back">
		<s:submit class="btn btn-delete" value="Back"></s:submit>
	</s:form>
</div>

<div class="container">
	<h1>Book List</h1>
	<table id="bookTable" border="1">
		<thead>
			<tr>
				<th>Book ID</th>
				<th>Name</th>
				<th>Category</th>
				<th>Quantity</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody id="bookListContainer">
		</tbody>
	</table>
</div>

<div id="editModal" class="modal">
	<div class="modal-content">
		<span class="close" onclick="closeModal()">&times;</span>
		<h1>Edit Book Details</h1>

		<label for="bookName">Name:</label> <input type="text" id="bookName"
			name="bookName" Class="form-control" required><br> <label
			for="bookCategory">Category:</label> <input type="text"
			id="bookCategory" name="category" Class="form-control" required><br>
		<label for="bookQuantity">Quantity:</label> <input type="number"
			id="bookQuantity" name="quantity" Class="form-control" required><br>
		<br> <input type="hidden" id="bookId" name="bookid">
		<button onclick="saveChanges()" class="btn btn-primary">Save
			Changes</button>
	</div>
</div>
