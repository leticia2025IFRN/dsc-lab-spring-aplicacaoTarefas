package br.edu.ifrn.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    private String cargo;

    @OneToMany(mappedBy = "dono")
    private Set<Tarefa> tarefas = new HashSet<>();
}
