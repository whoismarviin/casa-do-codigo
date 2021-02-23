package br.com.casa_do_codigo.casa_do_codigo.requisicoes;


import br.com.casa_do_codigo.casa_do_codigo.models.Country;
import br.com.casa_do_codigo.casa_do_codigo.models.State;
import br.com.casa_do_codigo.casa_do_codigo.validators.ExistsId;
import br.com.casa_do_codigo.casa_do_codigo.validators.UniqueState;
import br.com.casa_do_codigo.casa_do_codigo.validators.UniqueValues;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;



//@UniqueValues(domainClass = State.class,fields = {"nome","idPais"},aliases = {"nome","pais.id"}, message = "O país ja foi cadastrado")

@UniqueState
public class EstadoRequest {
    @PersistenceContext
    private EntityManager manager;
    @NotNull
    private String nome;

    @ExistsId(domainClass = Country.class, fieldName = "id")
    @NotNull
    private Long idPais;

    public EstadoRequest(@NotNull String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }


    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public State toModel(EntityManager manager){
         @NotNull Country país = manager.find(Country.class, this.idPais);

        Assert.state(país!= null,"Você está tentando cadastrar um país que não existe no nosso banco");
        return new State(nome,país);
    }
}
