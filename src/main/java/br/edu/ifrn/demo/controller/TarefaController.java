package br.edu.ifrn.demo.controller;

import br.edu.ifrn.demo.dto.TarefaRequestDTO;
import br.edu.ifrn.demo.dto.TarefaResponseDTO;
import br.edu.ifrn.demo.model.TarefaModel;
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
    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criar(@RequestBody TarefaRequestDTO corpo) {
        TarefaResponseDTO criada=service.criar(corpo);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
        // System.out.println("[CONTROLLER] Requisição recebida: POST/tarefas");
    }
    @GetMapping
    public ResponseEntity<List<TarefaModel>> listar() {
        System.out.println("[CONTROLLER] Requisição recebida: GET /tarefas");
        return ResponseEntity.ok(service.listar());
    }

    // Retorna todas as tarefas concluidas
    @GetMapping("/concluidos")
    public ResponseEntity<List<TarefaModel>> listarConcluidos(){
        System.out.println("[Controller] Requisição recebida: GET /tarefas/concluidos");
        return ResponseEntity.ok(service.listarConcluidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> buscar(@PathVariable Long id) {
        System.out.println("[CONTROLLER] Requisição recebida: GET /tarefas/" + id);
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
