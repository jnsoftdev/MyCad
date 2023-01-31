package br.com.jnsoft.mycad.model;

import androidx.annotation.NonNull;

public class Estados {

    String id;
    String nome;

    public Estados() {}

    public Estados(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome; // vai retorna o valor do nome do estado!
    }
}
