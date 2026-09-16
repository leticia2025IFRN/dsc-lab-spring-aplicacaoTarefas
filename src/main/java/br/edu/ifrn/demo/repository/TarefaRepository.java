package br.edu.ifrn.demo.repository;

import br.edu.ifrn.demo.model.TarefaModel;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class TarefaRepository {
    private final Map<Long, TarefaModel> banco = new LinkedHashMap<>();

    public TarefaModel salvar(TarefaModel tarefaModel) {
        System.out.println("[REPOSITORY] Salvando tarefa em memória: " + tarefaModel.getTitulo());
        banco.put(tarefaModel.getId(), tarefaModel);
        return tarefaModel;
    }

    public List<TarefaModel> listarTodas() {
        System.out.println("[REPOSITORY] Buscando todas as tarefas em memória");
        return new ArrayList<>(banco.values());
    }

    public Optional<TarefaModel> buscarPorId(Long id) {
        System.out.println("[REPOSITORY] Buscando tarefa por id: " + id);
        return Optional.ofNullable(banco.get(id));
    }
}
