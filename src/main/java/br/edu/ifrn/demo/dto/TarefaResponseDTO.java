package br.edu.ifrn.demo.dto;

public record TarefaResponseDTO(
    Long id,
    String titulo,
    boolean concluido,
    String prioridade
) {}
