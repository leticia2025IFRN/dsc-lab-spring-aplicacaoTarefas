package br.edu.ifrn.demo.repository;

import br.edu.ifrn.demo.model.Usuario;
import java.util.*;

public interface UsuarioRepository {
    Usuario salvar(Usuario usuario);
    List<Usuario> listar();
    Optional<Usuario> buscarPorId(Long id);
    Optional<Usuario> remover(Long id);
}
