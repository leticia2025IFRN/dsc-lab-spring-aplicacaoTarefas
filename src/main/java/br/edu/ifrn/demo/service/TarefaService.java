package br.edu.ifrn.demo.service;

import br.edu.ifrn.demo.dto.TarefaRequestDTO;
import br.edu.ifrn.demo.dto.TarefaResponseDTO;
import br.edu.ifrn.demo.model.TarefaModel;
import br.edu.ifrn.demo.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TarefaService {
    private final TarefaRepository repository;
    private final AtomicLong sequencia = new AtomicLong();

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public TarefaResponseDTO criar(TarefaRequestDTO dto) {
        String titulo = dto.titulo();
        TarefaModel tarefa = new TarefaModel(sequencia.incrementAndGet(),dto.titulo(),dto.descricao(),null);
        System.out.println("[SERVICE] Validando regra de negócio para: " + titulo);
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título da tarefa não pode ser vazio.");
        }
        TarefaModel salva = repository.salvar(tarefa);
        return paraResponseDTO(salva);
    }

    private TarefaResponseDTO paraResponseDTO(TarefaModel tarefa) {
        return new TarefaResponseDTO(
            tarefa.getId(),
            tarefa.getTitulo(),
            tarefa.isConcluida(),
            tarefa.getPrioridade()
        );
    }

    public List<TarefaModel> listar() {
        System.out.println("[SERVICE] Solicitando lista de tarefas ao repository");
        return repository.listarTodas();
    }

    public TarefaModel buscarPorId(Long id) {
        System.out.println("[SERVICE] Processando busca por id: " + id);
        return repository.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada: " + id));
    }

    public List<TarefaModel> listarConcluidos(){
        System.out.println("[SERVICE] Solicitando lista de tarefas concluídas.");
        List<TarefaModel> tarefas = listar();
        List<TarefaModel> tarefasConclidas = new ArrayList<>();

        for (TarefaModel tarefaModel: tarefas){
            if (tarefaModel.isConcluida()){
                tarefasConclidas.add(tarefaModel);
            }
        }

        return tarefasConclidas;
    }
}
