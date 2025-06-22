$(document).ready(function() {
	fetchStudentDetails();
});



function fetchStudentDetails() {
	$.ajax({
		url: 'loadStudentDetailsjson.action',
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			let studentHtml = '';
			$.each(data.studentDetails, function(index, studentDetail) {
				studentHtml += `
                    <tr>
                        <td>${studentDetail.student_id}</td>
                        <td>${studentDetail.studentName}</td>
                        <td>${studentDetail.year}</td>
                        <td>${studentDetail.department}</td>
                    </tr>
                `;
			});

			$('#studentListContainer').html(studentHtml);
		},
		error: function(error) {
			console.log('Error fetching books:', error);
		}
	});
}

