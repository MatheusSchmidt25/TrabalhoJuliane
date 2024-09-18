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
        if (usuarioId != null) {
            List<Tarefa> tarefas = tarefaService.getAllTarefaPorUsuarioId(usuarioId);
            model.addAttribute("todasTarefas", tarefas);
        } else {
            model.addAttribute("todasTarefas", List.of());
        }

        return "todasTarefas";
    }

    @PostMapping(path = "/tarefa/save")
    public String saveTarefa(Tarefa tarefa, HttpSession session) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId != null) {
            Usuario usuario = usuarioService.getUsuarioById(usuarioId);
            tarefa.setUsuario(usuario);
            tarefaService.save(tarefa);
        }
        return "redirect:/todasTarefas";
    }

    @PostMapping("/tarefa/delete/{id}")
    public String deleteTarefa(@PathVariable Integer id) {
        tarefaService.deleteTarefa(id);
        return "redirect:/todasTarefas";
    }

    private Integer getUsuarioLogadoId() {
        return 1;
    }



}
