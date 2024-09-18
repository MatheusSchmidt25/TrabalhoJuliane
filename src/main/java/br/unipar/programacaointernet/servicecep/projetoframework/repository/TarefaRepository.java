package br.unipar.programacaointernet.servicecep.projetoframework.repository;

import br.unipar.programacaointernet.servicecep.projetoframework.model.Tarefa;
import br.unipar.programacaointernet.servicecep.projetoframework.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    @Query("SELECT t FROM Tarefa t WHERE t.usuario.id = :usuarioId")
    List<Tarefa> findTarefasByUsuarioId(@Param("usuarioId") Integer usuarioId);

}
