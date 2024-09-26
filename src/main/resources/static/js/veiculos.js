
document.getElementById('imageUpload').addEventListener('change', function(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            document.getElementById('imagePreview').src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
});

function addVeiculos() {
	const veiculos = {
        modelo: $('#modelo').val(),
		ano: $('#ano').val(),
		km: $('#km').val(),
		status: $('#status').val(),

	};
	$.ajax({
		url: '/veiculos/',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(veiculos),
		success: function() {
            console.log('funcionou')
		},
        error: function(error){
            console.log(error);
        }
	});

}
