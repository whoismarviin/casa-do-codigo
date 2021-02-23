package br.com.casa_do_codigo.casa_do_codigo.controllers;


import br.com.casa_do_codigo.casa_do_codigo.models.State;
import br.com.casa_do_codigo.casa_do_codigo.requisicoes.EstadoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
@Transactional
public class StateController {

    @PersistenceContext
    private EntityManager manager;


    @PostMapping
    public ResponseEntity<State> criar(@RequestBody @Valid EstadoRequest request){
        State estado = request.toModel(manager);
        manager.persist(estado);
        return ResponseEntity.ok(estado);
    }


}
