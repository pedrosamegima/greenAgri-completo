
document.addEventListener("DOMContentLoaded", function () {
    const cadastroForm = document.getElementById("cadastroForm");

    cadastroForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const nome = document.getElementById("nome").value;
        const cnpj = document.getElementById("cnpj").value;
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;


        if (nome === "pedro" && cnpj === "1234567-8" && email === "phsamegima@gmail.com" && password === "123456") {
            window.location.href = "home.html";
        } else {
            alert("Credenciais inválidas!");
        }
    });
});

