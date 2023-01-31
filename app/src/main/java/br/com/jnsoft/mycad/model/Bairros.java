package br.com.jnsoft.mycad.model;

import java.util.Date;

import br.com.jnsoft.mycad.helper.Utils;

public class Bairros {
    int id;
    String nome;
    Date create;

    public Bairros() {}

    public Bairros(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Bairros(int id, String nome, String create) {
        this.id = id;
        this.nome = nome;
        this.create = Utils.getStrDate(create);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = Utils.getStrDate(create);
    }
}
