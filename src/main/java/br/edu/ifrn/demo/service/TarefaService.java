package br.edu.ifrn.demo.service;

import br.edu.ifrn.demo.dto.TarefaRequestDTO;
import br.edu.ifrn.demo.dto.TarefaResponseDTO;
import br.edu.ifrn.demo.model.Prioridade;
import br.edu.ifrn.demo.model.Tarefa;
import br.edu.ifrn.demo.repository.InMemoryTarefaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TarefaService {
    private final InMemoryTarefaRepository repository;
    private final AtomicLong sequencia = new AtomicLong();

    public TarefaService(InMemoryTarefaRepository repository) {
        this.repository = repository;
    }

    private TarefaResponseDTO paraResponseDTO(Tarefa tarefa) {
        return new TarefaResponseDTO(
            tarefa.getId(),
            tarefa.getTitulo(),
            tarefa.isConcluida(),
            tarefa.getPrioridade().toString()
        );
    }

    public TarefaResponseDTO criar(TarefaRequestDTO dto) {
        String titulo = dto.titulo();
        Tarefa tarefa = new Tarefa(sequencia.incrementAndGet(),dto.titulo(),false, Prioridade.BAIXA);
        System.out.println("[SERVICE] Validando regra de negócio para: " + titulo);
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título da tarefa não pode ser vazio.");
        }
        Tarefa salva = repository.salvarTarefa(tarefa);
        return paraResponseDTO(salva);
    }

    public List<Tarefa> listar() {
        System.out.println("[SERVICE] Solicitando lista de tarefas ao repository");
        return repository.listarTodasTarefas();
    }

    public Tarefa buscarPorId(Long id) {
        System.out.println("[SERVICE] Processando busca por id: " + id);
        return repository.buscarTarefaPorId(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada: " + id));
    }

    public List<Tarefa> listarConcluidos(){
        System.out.println("[SERVICE] Solicitando lista de tarefas concluídas.");
        List<Tarefa> tarefas = listar();
        List<Tarefa> tarefasConclidas = new ArrayList<>();

        for (Tarefa tarefa: tarefas){
            if (tarefa.isConcluida()){
                tarefasConclidas.add(tarefa);
            }
        }

        return tarefasConclidas;
    }

    public TarefaResponseDTO atualizar (Long id, TarefaRequestDTO dto) {
        Tarefa tarefa = buscarPorId(id);
        tarefa.setTitulo(dto.titulo());
        tarefa.setConcluida(dto.concluido());
        tarefa.setPrioridade(Prioridade.valueOf(dto.prioridade()));
        Tarefa atualizado = repository.salvarTarefa(tarefa);
        return paraResponseDTO(atualizado);
    }

    public boolean deletar(Long id) {
        if (repository.buscarTarefaPorId(id).isEmpty()) {
            throw new RuntimeException("Não foi possível deletar. Tarefa não encontrada: " + id);
        }
        System.out.println("[SERVICE] Removendo tarefa: " + id);
        return repository.deletarTarefa(id);
    }
}
