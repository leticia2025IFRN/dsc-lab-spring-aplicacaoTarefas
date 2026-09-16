package br.edu.ifrn.demo.model;

import java.time.LocalDate;

public class TarefaModel {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private boolean concluida;
    private String prioridade;

    public TarefaModel(Long id, String titulo, String descricao, LocalDate prazo) {
        this.id = id;
        this.titulo = titulo;
        this.descricao= descricao;
        this.prazo= prazo;
        this.concluida = false;
        this.prioridade="alta";
        System.out.println("Criando Tarefa...");
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public String getPrioridade(){
        return this.prioridade;
    }
}
