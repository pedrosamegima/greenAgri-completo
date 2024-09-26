
document.addEventListener("DOMContentLoaded", function () {
			const loginForm = document.getElementById("loginForm");

			loginForm.addEventListener("submit", function (event) {
				event.preventDefault();

				const email = document.getElementById("email").value;
                const cnpj = document.getElementById("cnpj").value;
				const password = document.getElementById("password").value;

				if (email === "phsamegima@gmail.com" && cnpj === "111111-1" && password === "123456") {
					window.location.href = "home.html";
				} else {
					alert("Credenciais inválidas!");
				}
			});
		});
