package br.com.totemti.livraria.dto;

import br.com.totemti.livraria.models.Autor;

import java.util.List;

public class LivroDTO {

    private Long id;

    private String nome;

    private String descricao;

    private EditoraDTO editora;

    private List<AutorDTO> autores;

    public Long getId() {
        return id;
    }

    public LivroDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public LivroDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EditoraDTO getEditora() {
        return editora;
    }

    public void setEditora(EditoraDTO editora) {
        this.editora = editora;
    }

    public List<AutorDTO> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorDTO> autores) {
        this.autores = autores;
    }
}
