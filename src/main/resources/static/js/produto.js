
$(document).ready(function() {
	loadGuests();
});

function loadGuests() {
	$.getJSON('/produtos/', function(data) {
		$('#guestTableBody').empty();
		data.forEach(guest => {
			$('#guestTableBody').append(
				`<tr>
					<td>${guest.id}</td>
                    <td>${guest.categoria}</td>
                    <td>${guest.nome}</td>
                    <td>${guest.descricao}</td>
                    <td>
					<button class="btn btn-sm btn-danger" onclick="deleteGuest(${guest.id})">Excluir</button>	
                 </tr>`
			);
		});
	});
}
function closeGuestForm() {
	$('#guestFormModal').hide();
}
function deleteGuest(id) {
	if (confirm('Realmente vai deletar?')) {
		$.ajax({
			url: `/produtos/${id}`,
			type: 'DELETE',
			success: function() {
				loadGuests();
			}
		});
	}
}
