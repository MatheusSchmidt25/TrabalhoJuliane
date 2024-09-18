package br.unipar.programacaointernet.servicecep.projetoframework.service;
import br.unipar.programacaointernet.servicecep.projetoframework.model.Tarefa;
import br.unipar.programacaointernet.servicecep.projetoframework.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> getAll() {
        return this.tarefaRepository.findAll();
    }

    public Tarefa save(Tarefa tarefa) {
        return this.tarefaRepository.save(tarefa);
    }


    public void deleteTarefa(Integer id) {
        tarefaRepository.deleteById(id);
    }

    public List<Tarefa> getAllTarefaPorUsuarioId(Integer usuarioId) {
        return this.tarefaRepository.findTarefasByUsuarioId(usuarioId);
    }
}
