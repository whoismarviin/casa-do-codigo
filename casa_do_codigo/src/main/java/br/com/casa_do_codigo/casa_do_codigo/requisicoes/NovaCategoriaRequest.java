package br.com.casa_do_codigo.casa_do_codigo.requisicoes;


import br.com.casa_do_codigo.casa_do_codigo.models.Category;
import br.com.casa_do_codigo.casa_do_codigo.validators.UniqueValue;
import com.sun.istack.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @UniqueValue(domainClass = Category.class,fieldName = "nome")
    private String nome;


    public NovaCategoriaRequest(Long id, @NotBlank @NotNull String nome) {
        this.id = id;
        this.nome = nome;
    }


    public Category toModel() {
       return new Category(this.id,this.nome);
    }
}
