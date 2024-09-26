
function addProdutos() {
	const produtos = {
        nome: $('#nome').val(),
		descricao: $('#descricao').val(),
		quantidade: $('#quantidade').val(),
		categoria: $('#categoria').val(),
		localizacao: $('#localizacao').val(),

	};
	$.ajax({
		url: '/produtos/',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(produtos),
		success: function() {
            alert("Cadastrado com sucesso!!")
		},
        error: function(){
            alert("Erro ao cadastrar produto");
        }
	});

}
