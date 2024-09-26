function updateGuest(id) {
	const guest = {
		id: $('#id').val(),
		nome: $('#nome').val(),
		descricao: $('#descricao').val(),
		quantidade: $('#quantidade').val(),
		categoria: $('#categoria').val(),
		localizacao: $('#localizacao').val(),
	};
	$.ajax({
		url: `/produto/${id}`,
		type: 'PUT',
		contentType: 'application/json',
		data: JSON.stringify(guest),
		success: function() {
			 alert("Cadastrado com sucesso!!")
			},
        error: function(){
            alert("Erro ao cadastrar produto");
		}
	});
}