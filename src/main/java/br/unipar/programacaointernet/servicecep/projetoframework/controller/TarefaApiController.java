package br.unipar.programacaointernet.servicecep.projetoframework.controller;

import br.unipar.programacaointernet.servicecep.projetoframework.model.Tarefa;
import br.unipar.programacaointernet.servicecep.projetoframework.model.Usuario;
import br.unipar.programacaointernet.servicecep.projetoframework.service.TarefaService;
import br.unipar.programacaointernet.servicecep.projetoframework.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TarefaApiController {

    private final TarefaService tarefaService;

    public TarefaApiController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping(path = "/api/tarefa")
    public ResponseEntity<List<Tarefa>> getAll() {
        return ResponseEntity.ok(tarefaService.getAll());
    }

    @PostMapping(path = "/api/tarefa")
    public ResponseEntity<Tarefa> save(@RequestBody Tarefa tarefa){
        return ResponseEntity.ok(tarefaService.save(tarefa));
    }



}
