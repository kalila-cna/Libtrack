$(document).ready(function() {
	fetchBooksDetails();

});


function fetchBooksDetails() {
	$.ajax({
		url: 'trackBookJson.action',
		type: 'GET',
		data: {
			userId: userId,
		},
		dataType: 'json',
		success: function(data) {
			if (data.trackBookDetails.length > 0) {
				let booksHtml = '';


				$.each(data.trackBookDetails, function(index, trackBookDetail) {



					booksHtml += `
                    <tr>
                        <td>${trackBookDetail.bookId}</td>
                        <td>${trackBookDetail.bookName}</td>
                        <td>${trackBookDetail.issueDate}</td>
                        <td>${trackBookDetail.dueDate}</td>
						<td>${trackBookDetail.returnDate}</td>
						<td>${trackBookDetail.status}</td>
                    </tr>
                `;
				});

				$('#bookListContainer').html(booksHtml);
			} else {
				let booksHtml = '';
				booksHtml += `<h1 style="text-align:center">No History Found</h1>`;
				$('#noRecords').html(booksHtml)
			}
		},
		error: function(error) {
			console.log('Error fetching books:', error);
		}
	});
}