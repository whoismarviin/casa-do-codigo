package br.com.casa_do_codigo.casa_do_codigo.controllers;

import br.com.casa_do_codigo.casa_do_codigo.models.Autor;
import br.com.casa_do_codigo.casa_do_codigo.repository.AuthorRepository;
import br.com.casa_do_codigo.casa_do_codigo.requisicoes.NovoAutorRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("authors")
public class AuthorController {


    public final AuthorRepository autorRepository;

    public AuthorController(AuthorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    @PostMapping
    public String cadastrarAutor(@RequestBody @Valid NovoAutorRequest request) {
        Autor autor = request.toModel();
        System.out.println("cria");
        autorRepository.save(autor);
        return autor.toString();


    }
}
