package br.edu.ifrn.demo.repository;

import br.edu.ifrn.demo.model.Tarefa;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class InMemoryTarefaRepository implements TarefaRepository {
    private final Map<Long, Tarefa> banco = new LinkedHashMap<>();

    public Tarefa salvarTarefa(Tarefa tarefa) {
        System.out.println("[REPOSITORY] Salvando tarefa em memória: " + tarefa.getTitulo());
        banco.put(tarefa.getId(), tarefa);
        return tarefa;
    }

    public List<Tarefa> listarTodasTarefas() {
        System.out.println("[REPOSITORY] Buscando todas as tarefas em memória");
        return new ArrayList<>(banco.values());
    }

    public Optional<Tarefa> buscarTarefaPorId(Long id) {
        System.out.println("[REPOSITORY] Buscando tarefa por id: " + id);
        return Optional.ofNullable(banco.get(id));
    }

    public boolean deletarTarefa(Long id) {
        System.out.println("[REPOSITORY] Removendo a tarefa do banco");
        return banco.remove(id) != null;
    }
}
