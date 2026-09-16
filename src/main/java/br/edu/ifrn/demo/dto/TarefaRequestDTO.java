package br.edu.ifrn.demo.dto;

import java.time.LocalDate;

public record TarefaRequestDTO(
   String titulo,
   String descricao,
   LocalDate prazo
) {}
