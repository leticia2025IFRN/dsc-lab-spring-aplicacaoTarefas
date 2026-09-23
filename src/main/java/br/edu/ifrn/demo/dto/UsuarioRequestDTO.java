package br.edu.ifrn.demo.dto;

public record UsuarioRequestDTO(
        Long id,
        String nome,
        String email,
        String cargo
) {
}
