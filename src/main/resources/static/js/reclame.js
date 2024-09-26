const textarea = document.querySelector('.custom-input');

textarea.addEventListener('input', function () {
  this.style.height = 'auto';  // Redefine a altura
  this.style.height = this.scrollHeight + 'px';  // Ajusta a altura de acordo com o conteúdo
});
function alert(){
alert("Reclamação foi envianda com sucesso!!");
}