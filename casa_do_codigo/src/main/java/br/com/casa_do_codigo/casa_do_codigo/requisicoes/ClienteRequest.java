package br.com.casa_do_codigo.casa_do_codigo.requisicoes;


import br.com.casa_do_codigo.casa_do_codigo.models.City;
import br.com.casa_do_codigo.casa_do_codigo.models.Client;
import br.com.casa_do_codigo.casa_do_codigo.models.Country;
import br.com.casa_do_codigo.casa_do_codigo.models.State;
import br.com.casa_do_codigo.casa_do_codigo.validators.CpfCnpj;
import br.com.casa_do_codigo.casa_do_codigo.validators.ExistsId;
import br.com.casa_do_codigo.casa_do_codigo.validators.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {
    @Email
    @NotBlank
    @UniqueValue(domainClass = Client.class, fieldName = "email")
    private String Email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @UniqueValue(domainClass = Client.class, fieldName = "documento")
    @CpfCnpj
    private String documento;

    @NotBlank
    private String endereco;

    @NotNull
    @ExistsId(domainClass = Country.class, fieldName = "id")
    private Long idPais;


    @NotNull
    @ExistsId(domainClass = State.class, fieldName = "id")
    private Long idEstado;


    @NotNull
    @ExistsId(domainClass = City.class, fieldName = "id")
    private Long idCidade;

    @NotNull
    private String telefone;

    @NotNull
    private String cep;


    public ClienteRequest(@javax.validation.constraints.Email @NotBlank String email,
                          @NotBlank String nome,
                          @NotBlank String sobrenome,
                          @NotBlank String documento,
                          @NotBlank String endereco,
                          @NotNull Long idPais,
                          @NotNull Long idEstado,
                          @NotNull Long idCidade,
                          @NotNull String telefone,
                          @NotNull String cep) {
        Email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.idCidade = idCidade;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Client toModel(EntityManager manager) {
        @NotNull Country pais = manager.find(Country.class,this.idPais);
        State estado = null;

        if (this.idEstado!= null){
            estado = manager.find(State.class,this.idEstado);
        }

        @NotNull City cidade = manager.find(City.class,this.idCidade);

        return new Client(Email,nome,sobrenome,documento,endereco,cidade,estado,pais,telefone,cep);
    }

    public String getEmail() {
        return Email;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public Long getIdCidade() {
        return idCidade;
    }

}
