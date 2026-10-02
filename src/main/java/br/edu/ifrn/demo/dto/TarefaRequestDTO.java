package br.edu.ifrn.demo.dto;

public record TarefaRequestDTO(
        String titulo,
        boolean concluido,
        String prioridade
) {}
