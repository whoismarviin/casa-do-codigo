package br.com.casa_do_codigo.casa_do_codigo.models;


import br.com.casa_do_codigo.casa_do_codigo.validators.UniqueValue;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    @UniqueValue(domainClass = Category.class,fieldName = "nome")
    private String nome;

    public Category() {
    }

    public Category(Long id, @NotBlank String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Category{" +
                ", nome='" + nome + '\'' +
                '}';
    }
}
