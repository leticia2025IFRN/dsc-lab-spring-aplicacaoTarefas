package br.edu.ifrn.demo.controller;

import br.edu.ifrn.demo.model.Usuario;
import br.edu.ifrn.demo.dto.*;
import br.edu.ifrn.demo.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody UsuarioRequestDTO corpo) {
        System.out.println("[CONTROLLER] Requisição recebida: POST /usuarios");
        UsuarioResponseDTO criado = service.criar(corpo);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        System.out.println("[CONTROLLER] Requisição recebida: GET /usuarios");
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorID(@PathVariable Long id) {
        System.out.println("[CONTROLLER] Requisição recebida: GET /usuarios/" + id);
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody UsuarioRequestDTO corpo) {
        System.out.println("[CONTROLLER] Requisição recebida: PUT /usuarios/" + id);
        return ResponseEntity.ok(service.atualizar(id, corpo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> remover(@PathVariable Long id) {
        System.out.println("[CONTROLLER] Requisição recebida: DEL /usuarios/" + id);
        boolean removido = service.remover(id);
        if  (removido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
