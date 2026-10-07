package br.edu.ifrn.demo.dto;

import br.edu.ifrn.demo.model.Usuario;

public record TarefaResponseDTO(
    Long id,
    String titulo,
    String prioridade,
    String status,
    Usuario usuario
) {}
