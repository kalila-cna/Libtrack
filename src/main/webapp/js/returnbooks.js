$(document).ready(function() {
	fetchBooksDetails();

});


function fetchBooksDetails() {
	$.ajax({
		url: 'loadReturnBookJson.action',
		type: 'GET',
		data: {
			userId: userId,
		},
		dataType: 'json',
		success: function(data) {
			
			$('#bookListContainer').empty();
			if(data.returnBookDetails.length > 0){
			let booksHtml = '';
			
			
			$.each(data.returnBookDetails, function(index, returnBookDetail) {


				booksHtml += `
                    <tr>
                        <td>${returnBookDetail.bookId}</td>
                        <td>${returnBookDetail.bookName}</td>
                        <td>${returnBookDetail.issueDate}</td>
                        <td>${returnBookDetail.dueDate}</td>
						<td>${returnBookDetail.status}</td>
                        <td>
						<i class="fas fa-arrow-left icon-return-arrow icon-button-delete"  onclick="returnBook(${returnBookDetail.bookId})"></i>
                        </td>
                    </tr>
                `;
			});

			$('#bookListContainer').html(booksHtml);
			}
			else{
				let booksHtml = '';
				booksHtml += `<h1 style="text-align:center">No Books to Return</h1>`;
				$('#noRecords').html(booksHtml)
			}
		},
		error: function(error) {
			console.log('Error fetching books:', error);
		}
	});
}


function returnBook(bookId) {

	$.ajax({
		url: 'returnBookJson.action',
		type: 'POST',
		data: {
			bookId: bookId,
			userId: userId,
		},
		success: function(response) {
			if (response.returned) {
				alert('Book Returned Successfully');
				fetchBooksDetails();
			}
			else {
				alert('Error returning book');
			}
		},
		error: function(error) {
			console.log('Error returning book:', error);
		}
	});
}
