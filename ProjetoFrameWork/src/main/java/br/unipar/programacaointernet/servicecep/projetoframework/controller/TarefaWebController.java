package br.unipar.programacaointernet.servicecep.projetoframework.controller;

import br.unipar.programacaointernet.servicecep.projetoframework.model.Tarefa;
import br.unipar.programacaointernet.servicecep.projetoframework.model.Usuario;
import br.unipar.programacaointernet.servicecep.projetoframework.service.TarefaService;
import br.unipar.programacaointernet.servicecep.projetoframework.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class TarefaWebController {

    private final TarefaService tarefaService;
    private final UsuarioService usuarioService;
    public TarefaWebController(TarefaService tarefaService, UsuarioService usuarioService) {
        this.tarefaService = tarefaService;
        this.usuarioService = usuarioService;
    }

    @GetMapping(path = "/todasTarefas")
    public String getAllTarefa(Model model, HttpSession session) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        System.out.println("ID do usuário logado: " + usuarioId); // Adicione esta linha

        if (usuarioId != null) {
            List<Tarefa> tarefas = tarefaService.getAllTarefaPorUsuarioId(usuarioId);
            System.out.println("Número de tarefas encontradas: " + tarefas.size()); // Adicione esta linha
            model.addAttribute("todasTarefas", tarefas);
        } else {
            model.addAttribute("todasTarefas", List.of()); // Ou outra lógica para quando não houver ID
        }

        return "todasTarefas";
    }

    @PostMapping(path = "/tarefa/save")
    public String saveTarefa(Tarefa tarefa) {
        tarefaService.save(tarefa);
        return "redirect:/todasTarefas";
    }

    @PostMapping("/tarefa/delete/{id}")
    public String deleteTarefa(@PathVariable Integer id) {
        tarefaService.deleteTarefa(id);
        return "redirect:/todasTarefas";
    }

    private Integer getUsuarioLogadoId() {
        // Implementar a lógica para obter o ID do usuário logado
        // Pode ser algo como: return SecurityContextHolder.getContext().getAuthentication().getPrincipal().getId();
        return 1; // Exemplo estático para testes
    }



}
