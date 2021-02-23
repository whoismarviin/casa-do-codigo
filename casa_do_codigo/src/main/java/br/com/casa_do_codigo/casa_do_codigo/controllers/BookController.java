package br.com.casa_do_codigo.casa_do_codigo.controllers;


import br.com.casa_do_codigo.casa_do_codigo.models.Book;
import br.com.casa_do_codigo.casa_do_codigo.requisicoes.NovoLivroRequest;
import br.com.casa_do_codigo.casa_do_codigo.respostas.RetornoLivro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/books")
    @Transactional
    public String criar(@RequestBody @Valid NovoLivroRequest request){
        Book book = request.toModel(manager);
        manager.persist(book);
        return book.toString();
    }

    @GetMapping
    public List<RetornoLivro> listar(){
        return manager.createQuery("select l from Book l",Book.class)
                .getResultStream()
                .map(RetornoLivro::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> buscar(@PathVariable("id") Long id){
        Book livro = manager.find(Book.class,id);
        if (livro == null){
            return ResponseEntity.notFound().build();
        }
        System.out.println(livro);
        return  ResponseEntity.ok(livro);
    }

}
