package br.edu.ifrn.demo.model;

public class TarefaModel {
    private Long id;
    private String titulo;
    private boolean concluida;

    public TarefaModel(Long id, String titulo, boolean concluida) {
        this.id = id;
        this.titulo = titulo;
        this.concluida = concluida;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
