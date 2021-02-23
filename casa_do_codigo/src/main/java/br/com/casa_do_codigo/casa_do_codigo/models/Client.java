package br.com.casa_do_codigo.casa_do_codigo.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String Nome;
    @NotNull
    private String sobrenome;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String documento;
    @NotNull
    private String Localizacao;
    @NotNull
    @OneToMany
    private City cidade;
    @ManyToOne
    @NotNull
    private Country pais;
    @ManyToOne
    @NotNull
    private State estado;
    @NotNull
    private String telefone;
    @NotNull
    private String cep;

    public Client(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento, @NotBlank String endereco, @NotNull City cidade, State estado, @NotNull Country pais, @NotNull String telefone, @NotNull String cep) {
    }

    public Client(Long id,
                  @NotNull String nome,
                  @NotNull String sobrenome,
                  @NotNull @Email String email,
                  @NotNull String documento,
                  @NotNull String localizacao,
                  @NotNull City cidade,
                  @NotNull Country pais,
                  @NotNull State estado,
                  @NotNull String telefone,
                  @NotNull String cep) {
        this.id = id;
        Nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        Localizacao = localizacao;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return Nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getLocalizacao() {
        return Localizacao;
    }

    public City getCidade() {
        return cidade;
    }

    public Country getPais() {
        return pais;
    }

    public State getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
