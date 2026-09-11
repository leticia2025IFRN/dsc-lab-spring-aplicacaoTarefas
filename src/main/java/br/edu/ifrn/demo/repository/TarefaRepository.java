package br.edu.ifrn.demo.repository;

import br.edu.ifrn.demo.model.TarefaModel;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TarefaRepository {
    private final Map<Long, TarefaModel> banco = new LinkedHashMap<>();
    private final AtomicLong sequencia = new AtomicLong();

    public TarefaModel salvar(String titulo) {
        System.out.println("[REPOSITORY] Salvando tarefa em memória: " +
                titulo);
        Long id = sequencia.incrementAndGet();
        TarefaModel tarefa = new TarefaModel(id, titulo, false);
        banco.put(id, tarefa);
        return tarefa;
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
