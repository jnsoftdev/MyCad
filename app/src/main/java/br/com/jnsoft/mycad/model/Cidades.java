package br.com.jnsoft.mycad.model;

import java.util.Date;

import br.com.jnsoft.mycad.helper.Utils;

public class Cidades {
    int id;
    String Nome;
    Date create;

    public Cidades() {}

    public Cidades(int id, String nome, String create) {
        this.id = id;
        Nome = nome;
        this.create = Utils.getStrDate(create);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = Utils.getStrDate(create);;
    }
}
