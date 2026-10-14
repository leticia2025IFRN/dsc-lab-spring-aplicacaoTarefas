package br.edu.ifrn.demo.repository;

import br.edu.ifrn.demo.model.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import java.util.*;

@Slf4j
@Repository
public class InMemoryUsuarioRepository implements UsuarioRepository {
    private final Map<Long, Usuario> banco = new LinkedHashMap<>();

    public Usuario salvar(Usuario usuario) {
        log.info("[REPOSITORY] Salvando usuário em memória: " + usuario.getId());
        banco.put(usuario.getId(), usuario);
        return usuario;
    }

    public List<Usuario> listar() {
        log.info("[REPOSITORY] Buscando todos os usuários.");
        return new ArrayList<>(banco.values());
    }

    public Optional<Usuario> buscarPorId(Long id) {
        log.info("[REPOSITORY] Buscando usuário por id: " + id);
        return Optional.ofNullable(banco.get(id));
    }

    public Optional<Usuario> remover(Long id) {
        log.info("[REPOSITORY] Removendo o usuário do banco por id: " + id);
        return Optional.ofNullable(banco.remove(id));
    }
}
