
const inputTipo = document.getElementById('tipoCliente');
const campoCpf = document.getElementById('campoCpf');
const campoCnpj = document.getElementById('campoCnpj');


// Checa se foi escolhido pessoa fisica ou juridica
inputTipo.addEventListener('change', checarTipoCliente)

function checarTipoCliente(){
    if (inputTipo.value === 'PF') {
        campoCnpj.style.display = 'none';
        campoCpf.style.display = 'block';
    }
    else if (inputTipo.value === 'PJ') {
        campoCnpj.style.display = 'block';
        campoCpf.style.display = 'none';
    }
    else {
        campoCnpj.style.display = 'none';
        campoCpf.style.display = 'none';
    }
}