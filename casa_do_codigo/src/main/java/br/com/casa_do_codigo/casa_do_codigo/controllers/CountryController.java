package br.com.casa_do_codigo.casa_do_codigo.controllers;


import br.com.casa_do_codigo.casa_do_codigo.models.Country;
import br.com.casa_do_codigo.casa_do_codigo.requisicoes.PaisRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@Transactional
@RequestMapping("paises")
public class CountryController {
    @PersistenceContext
    EntityManager manager;


    @PostMapping
    public ResponseEntity<Country> criar(@RequestBody @Valid PaisRequest request) {
        Country estado = new Country(request.getNome());
        manager.persist(estado);

        return ResponseEntity.ok(estado);


    }
}