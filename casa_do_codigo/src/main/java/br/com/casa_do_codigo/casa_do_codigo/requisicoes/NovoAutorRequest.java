package br.com.casa_do_codigo.casa_do_codigo.requisicoes;

import br.com.casa_do_codigo.casa_do_codigo.models.Autor;
import br.com.casa_do_codigo.casa_do_codigo.validators.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoAutorRequest {
    @NotBlank
    @NotNull
    private final String nome;
    @NotBlank
    @Email
    @UniqueValue(domainClass = Autor.class,fieldName = "email")
    private final String email;
    @NotBlank
    @Length(max= 400)
    private final String descricao;



    public NovoAutorRequest(@NotBlank @NotNull String nome,
                            @NotBlank @javax.validation.constraints.Email String email,
                            @NotBlank @Length(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }


    public Autor toModel() {
        return new Autor(this.nome,this.email,this.descricao);
    }
}
