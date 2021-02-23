package br.com.casa_do_codigo.casa_do_codigo.controllers;


import br.com.casa_do_codigo.casa_do_codigo.models.Category;
import br.com.casa_do_codigo.casa_do_codigo.requisicoes.NovaCategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("categories")
@Transactional
public class CategoryController {
    @Autowired
    private EntityManager manager;

    @PostMapping
    public String criarCategoria(@RequestBody @Valid NovaCategoriaRequest request){
        Category category = request.toModel();
        manager.persist(category);
        return category.toString();

    }

}
