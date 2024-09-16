package br.unipar.programacaointernet.servicecep.projetoframework.controller;

import br.unipar.programacaointernet.servicecep.projetoframework.model.Habito;
import br.unipar.programacaointernet.servicecep.projetoframework.service.HabitoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HabitoApiController {

    private final HabitoService habitoService;

    public HabitoApiController(HabitoService habitoService) {
        this.habitoService = habitoService;
    }

    @GetMapping (path="/api/habito")
    public ResponseEntity<List<Habito>> getAll(){
        return ResponseEntity.ok(habitoService.getAll());
    }

    @PostMapping(path = "/api/habito")
    public ResponseEntity<Habito> save(@RequestBody Habito habito){
        return ResponseEntity.ok(habitoService.save(habito));
    }
}
