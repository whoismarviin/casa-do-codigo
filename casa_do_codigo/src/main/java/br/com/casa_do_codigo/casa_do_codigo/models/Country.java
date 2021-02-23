package br.com.casa_do_codigo.casa_do_codigo.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotBlank
    private String nome;
    @OneToMany(mappedBy = "país")
    private List<State> estado;


    public Country(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Country() {
    }
}
