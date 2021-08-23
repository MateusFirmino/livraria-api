package br.com.totemti.livraria.controllers.dto;

public class EditoraDTO {

    private Long id;

    private String nome;

    public Long getId() {
        return id;
    }

    public EditoraDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public EditoraDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }
}
