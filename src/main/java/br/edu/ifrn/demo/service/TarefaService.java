package br.edu.ifrn.demo.service;

import br.edu.ifrn.demo.model.TarefaModel;
import br.edu.ifrn.demo.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public TarefaModel criar(String titulo) {
        System.out.println("[SERVICE] Validando regra de negócio para: " +
                titulo);
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título da tarefa não pode ser vazio.");
        }
        return repository.salvar(titulo.trim());
    }

    public List<TarefaModel> listar() {
        System.out.println("[SERVICE] Solicitando lista de tarefas ao repository");
        return repository.listarTodas();
    }

    public TarefaModel buscarPorId(Long id) {
        System.out.println("[SERVICE] Processando busca por id: " + id);
        return repository.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada: " + id));
    }
}
