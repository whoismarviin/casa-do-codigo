package br.com.casa_do_codigo.casa_do_codigo.validators;

import br.com.casa_do_codigo.casa_do_codigo.models.Country;
import br.com.casa_do_codigo.casa_do_codigo.requisicoes.ClienteRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Validator;
import java.util.List;

@Component
public abstract class PaisPossuiEstadosValidator  implements Validator {

    @PersistenceContext
    EntityManager manager;

    public boolean supports(Class<?> klass){
        return ClienteRequest.class.isAssignableFrom(klass);
    }

    public void validate(Object o, Errors errors) {
        ClienteRequest request = (ClienteRequest) o;

        if(errors.hasErrors() || request.getIdEstado() !=null){
            return;
        }

        Country pais = manager.find(Country.class, request.getIdPais());

        Query query = manager.createQuery("select e from State e Where e.país=:idPais");
        query.setParameter("idPais",pais);
        List<?> list = query.getResultList();

        if(list.size()>0){
            errors.rejectValue("idEstado",null,"Estado é obrigatório para o país selecionado.");

        }

    }
}
