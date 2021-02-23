package br.com.casa_do_codigo.casa_do_codigo.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @NotNull
    private String nome;

    @ManyToOne
    @NotNull
    private Country país;


    public State(@NotBlank @NotNull String nome, @NotNull Country país) {
        this.nome = nome;
        this.país = país;
    }

    @Deprecated
    public State() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}