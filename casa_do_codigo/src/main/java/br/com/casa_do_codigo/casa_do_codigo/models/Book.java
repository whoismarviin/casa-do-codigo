package br.com.casa_do_codigo.casa_do_codigo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Entity
public class Book {
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
    private Double price;
    private Integer pages;
    private Double isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy",shape = JsonFormat.Shape.STRING)
    private LocalDate date;

    @NotNull
    @ManyToOne
    private Category categoria;

    @NotNull
    @ManyToOne
    private Autor autor;


    public Book(Long id,
                @NotBlank String title,
                @NotBlank @Length(max = 500) String resumo,
                String sumario,
                @Min(100) Double price,
                Integer pages,
                Double isbn,
                @NotNull @Future LocalDate date,
                @NotNull Category categoria,
                @NotNull Autor autor) {
        this.id = id;
        this.title = title;
        this.resumo = resumo;
        this.sumario = sumario;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.date = date;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Book(String title, String resumo, String sumario, Double price, Integer pages, Double isbn, LocalDate date, Category category, Autor autor) {
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", isbn=" + isbn +
                ", date=" + date +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}


