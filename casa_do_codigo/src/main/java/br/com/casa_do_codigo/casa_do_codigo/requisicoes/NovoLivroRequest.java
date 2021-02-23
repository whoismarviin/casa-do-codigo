package br.com.casa_do_codigo.casa_do_codigo.requisicoes;

import br.com.casa_do_codigo.casa_do_codigo.models.Autor;
import br.com.casa_do_codigo.casa_do_codigo.models.Book;
import br.com.casa_do_codigo.casa_do_codigo.models.Category;
import br.com.casa_do_codigo.casa_do_codigo.validators.ExistsId;
import br.com.casa_do_codigo.casa_do_codigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class NovoLivroRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    @Length(max = 500)
    private String resumo;
    private String sumario;
    @Min(100)
    private Integer pages;
    @NotBlank
    private Double price;

    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "isbn")
    private Double isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;

    @ExistsId(domainClass = Category.class,fieldName = "id")
    private @NotNull Long idCategoria;

    @ExistsId(domainClass = Autor.class,fieldName = "id")
    private @NotNull Long idAutor;


    public NovoLivroRequest(Long id,
                            @NotBlank String title,
                            @NotBlank @Length(max = 500) String resumo,
                            String sumario,
                            @Min(100) Double price,
                            Integer pages,
                            @NotBlank Double isbn,
                            @NotNull @Future LocalDate date,
                            @NotNull Long idCategoria,
                            @NotNull Long idAutor) {
        this.id = id;
        this.title = title;
        this.resumo = resumo;
        this.sumario = sumario;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.date = date;
        this.idCategoria = idCategoria;
        this.idAutor =idAutor;

    }


    public Book toModel(EntityManager manager) {
        @NotNull Autor autor = manager.find(Autor.class,this.idAutor);
        @NotNull Category category = manager.find(Category.class,this.idCategoria);

        Assert.state(autor!=null, "Você está querendo cadastrar um livro para um autor que não existe: " + this.idAutor);
        Assert.state(category!=null, "Você está querendo cadastrar um livro para uma categoria que não existe: " + this.idCategoria);

        return new Book(this.title, this.resumo, this.sumario, this.price,
                this.pages, this.isbn, this.date, category, autor);
    }
}