package br.unipar.programacaointernet.servicecep.projetoframework.service;
import br.unipar.programacaointernet.servicecep.projetoframework.model.Habito;
import br.unipar.programacaointernet.servicecep.projetoframework.repository.HabitoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitoService {

    private final HabitoRepository habitoRepository;

    public HabitoService(HabitoRepository habitoRepository) {
        this.habitoRepository = habitoRepository;
    }

    public Habito save(Habito habito){
        return this.habitoRepository.save(habito);
    }

    public List<Habito> getAll(){
        return this.habitoRepository.findAll();
    }

    public List <Habito> getAllHabitoPorUsuarioId(Integer usuarioId){
        return this.habitoRepository.findHabitoByUsuarioId(usuarioId);
    }
}
