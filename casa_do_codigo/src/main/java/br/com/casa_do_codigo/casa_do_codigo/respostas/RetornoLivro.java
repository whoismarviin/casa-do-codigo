package br.com.casa_do_codigo.casa_do_codigo.respostas;

import br.com.casa_do_codigo.casa_do_codigo.models.Book;

public class RetornoLivro {
    private Long id;
    private String titulo;

    public RetornoLivro(Book livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitle();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "RetornoLivro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
