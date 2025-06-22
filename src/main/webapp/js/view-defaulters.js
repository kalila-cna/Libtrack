$(document).ready(function() {
	fetchDefaulterDetails();
});



function fetchDefaulterDetails() {
	$.ajax({
		url: 'defaulterJson.action',
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			if (data.defaulterDetails.length > 0) {
				let Html = '';
				$.each(data.defaulterDetails, function(index, defaulterDetail) {
					Html += `
                    <tr>
                        <td>${defaulterDetail.defaulterId}</td>
                        <td>${defaulterDetail.studentId}</td>
						<td>${defaulterDetail.studentName}</td>
						<td>${defaulterDetail.year}</td>
						<td>${defaulterDetail.department}</td>
						<td>${defaulterDetail.bookId}</td>
						<td>${defaulterDetail.bookName}</td>
						<td>${defaulterDetail.overDueDays}</td>
						<td>${defaulterDetail.fineAmount}</td>
						<td>${defaulterDetail.fineStatus}</td>
                    </tr>
                `;
				});

				$('#defaulterListContainer').html(Html);
			}
			else {
				let Html = '';
				Html += `<h1 style="text-align:center">No Defaulters. Good Management!</h1>`;
				$('#noRecords').html(Html)
			}
		},
		error: function(error) {
			console.log('Error fetching Defaulters:', error);
		}
	});
}