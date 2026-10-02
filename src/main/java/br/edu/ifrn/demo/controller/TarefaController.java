package br.edu.ifrn.demo.controller;

import br.edu.ifrn.demo.dto.TarefaRequestDTO;
import br.edu.ifrn.demo.dto.TarefaResponseDTO;
import br.edu.ifrn.demo.model.Tarefa;
import br.edu.ifrn.demo.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService service;
    public TarefaController(TarefaService service) {
        this.service = service;
    }

    // Cria uma tarefa
    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criar(@RequestBody TarefaRequestDTO corpo) {
        TarefaResponseDTO criada=service.criar(corpo);
        System.out.println("[CONTROLLER] Requisição recebida: POST/tarefas");
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    // Retorna todas as tarefas
    @GetMapping
    public ResponseEntity<List<Tarefa>> listar() {
        System.out.println("[CONTROLLER] Requisição recebida: GET /tarefas");
        return ResponseEntity.ok(service.listar());
    }

    // Retorna todas as tarefas concluídas
    @GetMapping("/concluidos")
    public ResponseEntity<List<Tarefa>> listarConcluidos(){
        System.out.println("[Controller] Requisição recebida: GET /tarefas/concluidos");
        return ResponseEntity.ok(service.listarConcluidos());
    }

    // Retorna a tarefa pelo ID especificado
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(@PathVariable Long id) {
        System.out.println("[CONTROLLER] Requisição recebida: GET /tarefas/" + id);
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Atualiza a tarefa pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizar(@PathVariable Long id, @RequestBody TarefaRequestDTO corpo) {
        System.out.println("[CONTROLLER] Requisição recebida: PUT /tarefas/" + id);
        return ResponseEntity.ok(service.atualizar(id, corpo));
    }

    // Remove a tarefa pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletar(@PathVariable Long id) {
        System.out.println("[CONTROLLER] Requisição recebida: DEL /tarefas/" + id);
        boolean removido = service.deletar(id);
        if (removido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
