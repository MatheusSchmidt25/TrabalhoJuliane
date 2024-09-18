document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Previne o envio padrão do formulário

    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    fetch('/api/usuarios', { // Envia a solicitação POST para a sua API
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            nome: nome,
            email: email,
            senha: senha,
        }),
    })
        .then(response => response.json())
        .then(data => {
            // Aqui você pode tratar a resposta da API, por exemplo:
            if (data.id) { // Se o ID foi retornado, o usuário foi cadastrado com sucesso
                alert('Cadastro bem-sucedido!');
                window.location.href = '/login'; // Redireciona para a página de login após o cadastro
            } else {
                alert('Erro ao cadastrar: ' + (data.message || 'Erro desconhecido'));
            }
        })
        .catch(error => {
            console.error('Erro:', error);
            alert('Erro na conexão com o servidor');
        });
});
