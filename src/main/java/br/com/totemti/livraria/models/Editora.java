package br.com.totemti.livraria.models;

import javax.persistence.*;

@Entity //Classe representa uma entidade do banco de dados
@Table(name = "editoras")
public class Editora extends Entidade{

    @Column(name = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
