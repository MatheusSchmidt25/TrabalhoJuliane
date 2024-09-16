package br.unipar.programacaointernet.servicecep.projetoframework.controller;

import br.unipar.programacaointernet.servicecep.projetoframework.model.Habito;
import br.unipar.programacaointernet.servicecep.projetoframework.service.HabitoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HabitoWebController {

    private final HabitoService habitoService;

    public HabitoWebController(HabitoService habitoService) {
        this.habitoService = habitoService;
    }

    @GetMapping("/historico")
    public String getAllHistorico(Model model) {
        List<Habito> habitos = habitoService.getAll(); // Ou o método que busca os dados corretos para o histórico
        model.addAttribute("historico", habitos);
        return "historico"; // Nome do arquivo HTML (historico.html) na pasta templates
    }

    @PostMapping(path = "/habito/save")
    public String saveHabito(Habito habito) {
        habitoService.save(habito);
        return "redirect:/todasTarefas";
    }

    @GetMapping("/habitos")
    public String habito() {
        return "habitos";
    }

}
