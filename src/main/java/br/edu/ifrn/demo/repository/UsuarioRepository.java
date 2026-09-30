package br.edu.ifrn.demo.repository;

import br.edu.ifrn.demo.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
// public interface UsuarioRepository {
public class UsuarioRepository {
    private final Map<Long, Usuario> banco = new LinkedHashMap<>();

    public Usuario salvar(Usuario usuario) {
        System.out.println("[REPOSITORY] Salvando usuário: " + usuario.getNome());
        banco.put(usuario.getId(), usuario);
        return usuario;
    }

    public List<Usuario> listar() {
        System.out.println("[REPOSITORY] Buscando todos os usuários.");
        return new ArrayList<>(banco.values());
    }

    public Optional<Usuario> buscarPorId(Long id) {
        System.out.println("[REPOSITORY] Buscando tarefa por id: " + id);
        return Optional.ofNullable(banco.get(id));
    }

    public boolean remover(Long id) {
        System.out.println("[REPOSITORY] Removendo o usuário do banco");
        return banco.remove(id) != null;
    }
}
