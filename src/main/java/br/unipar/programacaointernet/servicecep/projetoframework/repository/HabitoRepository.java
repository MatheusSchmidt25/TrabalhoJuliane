package br.unipar.programacaointernet.servicecep.projetoframework.repository;


import br.unipar.programacaointernet.servicecep.projetoframework.model.Habito;
import br.unipar.programacaointernet.servicecep.projetoframework.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitoRepository extends JpaRepository<Habito, Integer> {

    @Query("SELECT h FROM Habito h WHERE h.usuario.id = :usuarioId")
    List<Habito> findHabitoByUsuarioId(@Param("usuarioId") Integer usuarioId);
}
