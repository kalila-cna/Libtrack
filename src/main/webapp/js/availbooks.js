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
						<i class="fas fa-book icon-available icon-button-edit"  onclick="availBook(${bookDetail.book_id},${bookDetail.quantity})"></i>
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

function availBook(bookId, quantity) {
	if (quantity <= 0) {
		alert("Book currently not Available");
		return;
	}

	$.ajax({
		url: 'availBookJson.action',
		type: 'POST',
		data: {
			bookId: bookId,
			userId: userId,
			quantity: quantity
		},
		success: function(response) {
			
			if (response.alreadyAvailed) {
				alert('You have already availed this Book. Try availing other Books');
			}
			else {
				if (response.availed) {
					alert('Book Availed! Happy Reading');
					fetchBooksDetails();
				}
				else {
					alert('Error availing book');
				}
			}
		},
		error: function(error) {
			console.log('Error availing book:', error);
		}
	});

}

