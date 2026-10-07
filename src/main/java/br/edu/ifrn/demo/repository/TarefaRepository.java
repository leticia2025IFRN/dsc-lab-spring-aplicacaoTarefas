package br.edu.ifrn.demo.repository;

import br.edu.ifrn.demo.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    boolean deleteTarefaById(Long id);

    List<Tarefa> id(Long id);
}