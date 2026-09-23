package br.edu.ifrn.demo.dto;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String cargo
) {
}
