package br.unipar.programacaointernet.servicecep.projetoframework.controller;

import br.unipar.programacaointernet.servicecep.projetoframework.model.Tarefa;
import br.unipar.programacaointernet.servicecep.projetoframework.model.Usuario;
import br.unipar.programacaointernet.servicecep.projetoframework.service.TarefaService;
import br.unipar.programacaointernet.servicecep.projetoframework.service.UsuarioService;
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

    public TarefaWebController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping(path = "/todasTarefas")
    public String getAllTarefa(Model model) {
        List<Tarefa> tarefa = tarefaService.getAll();
        model.addAttribute("todasTarefas", tarefa);
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



}
