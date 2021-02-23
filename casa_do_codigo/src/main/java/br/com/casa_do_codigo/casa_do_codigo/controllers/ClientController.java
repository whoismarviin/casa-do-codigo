package br.com.casa_do_codigo.casa_do_codigo.controllers;

import br.com.casa_do_codigo.casa_do_codigo.models.Client;
import br.com.casa_do_codigo.casa_do_codigo.requisicoes.ClienteRequest;
import br.com.casa_do_codigo.casa_do_codigo.validators.PaisPossuiEstadosValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("clientes")
@Transactional
public class ClientController {

    @PersistenceContext
    EntityManager manager;

    @Autowired
    private PaisPossuiEstadosValidator paisPossuiEstadosValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators((Validator) paisPossuiEstadosValidator);
    }


    @PostMapping
    public ResponseEntity<Client> criar(@RequestBody @Valid ClienteRequest request){
        Client client = request.toModel(manager);
        manager.persist(client);
        return ResponseEntity.ok(client);
    }
}
