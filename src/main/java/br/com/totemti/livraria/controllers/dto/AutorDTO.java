package br.com.totemti.livraria.controllers.dto;

public class AutorDTO {

    private Long id;

    private String nome;

    public Long getId() {
        return id;
    }

    public AutorDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public AutorDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }
}
