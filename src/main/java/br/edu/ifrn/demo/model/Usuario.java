package br.edu.ifrn.demo.model;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String cargo;

    public Usuario(Long id, String nome, String email, String cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }

    public String getEmail() { return email; }

    public String getCargo() { return cargo; }
}
