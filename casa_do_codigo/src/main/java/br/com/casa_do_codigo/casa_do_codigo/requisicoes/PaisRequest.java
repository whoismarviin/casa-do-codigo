package br.com.casa_do_codigo.casa_do_codigo.requisicoes;

import br.com.casa_do_codigo.casa_do_codigo.models.Country;
import br.com.casa_do_codigo.casa_do_codigo.validators.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequest {
    @NotBlank
    @UniqueValue(domainClass = Country.class,fieldName = "nome")
    private String nome;

    public PaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    @Deprecated
    public PaisRequest() {
    }

    public String getNome() {
        return nome;
    }
}
