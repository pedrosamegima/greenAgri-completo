
$(document).ready(function() {
	loadGuests();
});

function loadGuests() {
	$.getJSON('/veiculos/', function(data) {
		$('#guestTableBody').empty();
		data.forEach(guest => {
			$('#guestTableBody').append(
				`<tr>
					<td>${guest.id}</td>
                    <td>${guest.modelo}</td>
                    <td>${guest.ano}</td>
                    <td>${guest.km}</td>
                    <td>${guest.status}</td>
                    <td>
                 </tr>`
			);
		});
	});
}

