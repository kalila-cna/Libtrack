$(document).ready(function() {
	fetchDefaulterDetails();
});


function fetchDefaulterDetails() {
	$.ajax({
		url: 'viewFinesJson.action',
		type: 'GET',
		data: {
			userId: userId,
		},
		dataType: 'json',
		success: function(data) {
			$('#finesContainer').empty();
			if (data.fineDetails.length > 0) {
				let Html = '';
				$.each(data.fineDetails, function(index, fineDetail) {
					Html += `
                    <tr>
                        <td>${fineDetail.bookId}</td>
						<td>${fineDetail.bookName}</td>
						<td>${fineDetail.overDueDays}</td>
						<td>${fineDetail.fineAmount}</td>
						<td>
						<i class="fas fa-money-bill-wave icon-pay-fine icon-button-pay icon-button-edit" onclick="payFine(${fineDetail.bookId},${fineDetail.fineAmount})"></i>
						</td>
                    </tr>
                `;
				});

				$('#finesContainer').html(Html);
			}
			else {
				let Html = '';
				Html += `<h1 style="text-align:center">Nice Discipline. Maintain It!</h1>`;
				$('#noRecords').html(Html)
			}
		},
		error: function(error) {
			console.log('Error fetching Defaulters:', error);
		}
	});
}


function payFine(bookId, fineAmount){
	let fine = prompt("fine Amount:", fineAmount);
	if (fine == null || fine == "" || fine > fineAmount || fine < fineAmount) {
	    alert("Enter the correct Fine amount")
	} else {
		$.ajax({
				url: 'payFineJson.action',
				type: 'POST',
				data: {
					bookId: bookId,
					userId: userId,
				},
				success: function(response) {
					if (response.paid) {
						alert('Fine paid Successfully');
						fetchDefaulterDetails();
					}
					else {
						alert('Error Paying Fine');
					}
				},
				error: function(error) {
					console.log('Error Paying Fine:', error);
				}
			});
	  }
}