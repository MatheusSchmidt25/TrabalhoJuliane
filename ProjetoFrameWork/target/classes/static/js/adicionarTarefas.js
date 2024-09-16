async function loadUsuarios() {
    try {
        const response = await fetch('/api/usuarios');
        const usuarios = await response.json();
        const select = document.getElementById('usuario');

        usuarios.forEach(usuario => {
            const option = document.createElement('option');
            option.value = usuario.id;
            option.textContent = usuario.nome;
            select.appendChild(option);
        });
    } catch (error) {
        console.error('Erro ao carregar usuários:', error);
    }
}

// Carregar usuários ao carregar a página
document.addEventListener('DOMContentLoaded', loadUsuarios);

// Lidar com o envio do formulário

function voltar(){
    window.location.href = '/todasTarefas';
}