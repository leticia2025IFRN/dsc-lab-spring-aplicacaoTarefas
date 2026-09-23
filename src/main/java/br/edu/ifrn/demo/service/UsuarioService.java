package br.edu.ifrn.demo.service;

import br.edu.ifrn.demo.model.Usuario;
import br.edu.ifrn.demo.dto.*;
import br.edu.ifrn.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final AtomicLong id = new AtomicLong();

    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getCargo()
        );
    }

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        String nome = dto.nome();
        Usuario usuario = new Usuario(id.incrementAndGet(), dto.nome(), dto.email(), dto.cargo());
        System.out.println("[SERVICE] Validando regra de negócio para: " + nome);
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("[SERVICE] O nome não pode ser nulo ou vazio.");
        }
        Usuario salva = repository.criar(usuario);
        return toResponseDTO(salva);
    }

    public List<Usuario> listar() {
        System.out.println("[SERVICE] Solicitando lista de usuários ao repository.");
        return repository.listar();
    }

    public Usuario buscarPorId(Long id) {
        System.out.println("[SERVICE] Processando busca por id: " + id);
        return repository.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada: " + id));
    }

    public Usuario atualizar(Long id , Usuario usuario) {
        UsuarioRepository.atualizar(id, usuario);
    }

    public void remover(Long id) {
        return UsuarioRepository.remover(id);
    }
}
