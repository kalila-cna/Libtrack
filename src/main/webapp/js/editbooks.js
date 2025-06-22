$(document).ready(function() {
	fetchBooksDetails();
});



function fetchBooksDetails() {
	$.ajax({
		url: 'bookjson.action',
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			let booksHtml = '';
			$.each(data.bookDetails, function(index, bookDetail) {
				booksHtml += `
                    <tr>
                        <td>${bookDetail.book_id}</td>
                        <td>${bookDetail.bookName}</td>
                        <td>${bookDetail.category}</td>
                        <td>${bookDetail.quantity}</td>
                        <td>
                            <i class="fas fa-edit icon-button-edit" onclick="editBook(${bookDetail.book_id})"></i>
                            <i class="fas fa-trash-alt icon-button-delete" onclick="deleteBook(${bookDetail.book_id})"></i>
                        </td>
                    </tr>
                `;
			});

			$('#bookListContainer').html(booksHtml);
		},
		error: function(error) {
			console.log('Error fetching books:', error);
		}
	});
}


function editBook(bookId) {

	$.ajax({
		url: 'loadEditBookJson.action',
		type: 'GET',
		data: { id: bookId },
		success: function(data) {
			let bookDetails = data.bookDetails[0];

			$('#bookName').val(bookDetails.bookName);
			$('#bookCategory').val(bookDetails.category);
			$('#bookQuantity').val(bookDetails.quantity);
			$('#bookId').val(bookDetails.book_id);
			$('#editModal').show();
		},
		error: function(error) {
			console.log('Error fetching book details:', error);
		}
	});
}


function closeModal() {
	$('#editModal').hide();
	fetchBooksDetails();

}


function saveChanges() {
	var bookid = document.getElementById("bookId").value;
	var bookname = document.getElementById("bookName").value;
	var quantity = document.getElementById("bookQuantity").value;
	var category = document.getElementById("bookCategory").value;

	$.ajax({
		url: 'saveBookJson.action',
		type: 'POST',
		data: {
			book_id: bookid,
			bookName: bookname,
			quantity: quantity,
			category: category
		},
		success: function(response) {
			alert('Book updated successfully');

		},
		error: function(error) {
			console.log('Error updating book:', error);
		}
	});
}



function deleteBook(bookId) {
	$.ajax({
		url: 'deleteBookJson.action',
		type: 'GET',
		data: { book_id: bookId },
		success: function(data) {
			alert('Book Deleted');
			fetchBooksDetails();
		},
		error: function(error) {
			console.log('Error fetching book details:', error);
		}
	});
}


