package br.com.casa_do_codigo.casa_do_codigo.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nome;
    @ManyToOne
    @NotNull
    private State estado;

    public City(Long id, @NotNull String nome, @NotNull State estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    @Deprecated
    public City() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public State getEstado() {
        return estado;
    }
}
