<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="back-button">
	<s:form action="back">
		<s:submit class="btn btn-delete" value="Back"></s:submit>
	</s:form>
</div>
<div class="container">
	<h1>Add Books</h1>
	<s:actionerror />
	<s:actionmessage cssClass="success-message" />
	<s:form action="addbook">
		<div class="form-group">
			<s:textfield label="Book Name" name="bookName"
				cssClass="form-control"></s:textfield>
		</div>
		<div class="form-group">
			<s:textfield label="Quantity" name="quantity" type="number"
				cssClass="form-control"></s:textfield>
		</div>
		<div class="form-group">
			<s:select name="category" list="categoryModel.categories"
				label="Select Category" cssClass="form-control" />
		</div>
		<div>
			<s:submit value="Add Book" cssClass="btn btn-primary"></s:submit>
		</div>
	</s:form>
</div>