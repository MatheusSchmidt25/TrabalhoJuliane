package br.unipar.programacaointernet.servicecep.projetoframework.controller;

import br.unipar.programacaointernet.servicecep.projetoframework.model.Usuario;
import br.unipar.programacaointernet.servicecep.projetoframework.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class UsuarioWebController {

    private final UsuarioService usuarioService;

    public UsuarioWebController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(path = "/login")
    public String getAllUsuario(Model model) {
        List<Usuario> usuario = usuarioService.getAll();
        model.addAttribute("usuario", usuario);
        return "login";
    }

    @GetMapping("/cadastrar")
    public String getCadastroPage() {
        return "cadastrar"; // Nome do arquivo sem extensão, assume que está em src/main/resources/templates
    }

    @PostMapping(path = "/usuario/save")
    public String saveUsuario(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String nome, @RequestParam String senha, HttpSession session, Model model) {
        Optional<Usuario> usuario = usuarioService.validateUser(nome, senha);
        if (usuario.isPresent()) {
            // Armazenar o ID do usuário na sessão
            session.setAttribute("usuarioId", usuario.get().getId());
            return "redirect:/todasTarefas"; // Redireciona para /todasTarefas após o login
        } else {
            model.addAttribute("error", "Nome ou senha inválidos");
            return "login";
        }
    }

    @GetMapping("/adicionarTarefas")
    public String adicionarTarefasPage() {
        return "adicionarTarefas"; // Nome do template para adicionar tarefas
    }



}
