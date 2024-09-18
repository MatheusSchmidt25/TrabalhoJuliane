package br.unipar.programacaointernet.servicecep.projetoframework.service;

import br.unipar.programacaointernet.servicecep.projetoframework.model.Usuario;
import br.unipar.programacaointernet.servicecep.projetoframework.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

     public List<Usuario> getAll() {
        return this.usuarioRepository.findAll();
    }

     public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Optional<Usuario> validateUser(String nome, String senha) {
        // Procura o usuário pelo nome (login)
        Optional<Usuario> usuarioOptional = usuarioRepository.findByNome(nome);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            // Compara a senha fornecida com a senha armazenada
            if (senha.equals(usuario.getSenha())) {
                return Optional.of(usuario); // Senha correta, retorna o usuário
            }
        }

        return Optional.empty(); // Usuário não encontrado ou senha incorreta
    }

    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }



}
