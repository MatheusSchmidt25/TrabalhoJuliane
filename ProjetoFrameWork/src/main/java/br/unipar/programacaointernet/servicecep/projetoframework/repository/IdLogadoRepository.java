package br.unipar.programacaointernet.servicecep.projetoframework.repository;

import br.unipar.programacaointernet.servicecep.projetoframework.model.Habito;
import br.unipar.programacaointernet.servicecep.projetoframework.model.IdLogado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdLogadoRepository extends JpaRepository<IdLogado, Integer> {
}
