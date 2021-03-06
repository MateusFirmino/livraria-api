package br.com.totemti.livraria.controllers.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class LivroFormDTO {

    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String nome;

    @NotNull
    private String descricao;

    private Long editora;

    private List<Long> autores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getEditora() {
        return editora;
    }

    public void setEditora(Long editora) {
        this.editora = editora;
    }

    public List<Long> getAutores() {
        return autores;
    }

    public void setAutores(List<Long> autores) {
        this.autores = autores;
    }
}
