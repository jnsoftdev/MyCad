package br.com.jnsoft.mycad.model;

import java.util.Date;

import br.com.jnsoft.mycad.helper.Utils;

public class Clientes {
    int id;
    String nome;
    String cpf;
    String fone;
    String email;
    String cep;
    String Logradouro;
    String numero;
    int baiID;
    int cidID;
    String estado;
    Date create;
    Boolean ativo;

    public Clientes() {}

    public Clientes(int id, String nome, String cpf, String fone, String email, String create, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.fone = fone;
        this.email = email;
        this.create = Utils.getStrDate(create);
        this.ativo = ativo;
    }

    public Clientes(int id, String nome, String cpf, String fone, String email, String cep, String logradouro, String numero, int baiID, int cidID, String estado, String create, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.fone = fone;
        this.email = email;
        this.cep = cep;
        Logradouro = logradouro;
        this.numero = numero;
        this.baiID = baiID;
        this.cidID = cidID;
        this.estado = estado;
        this.create =  Utils.getStrDate(create);;
        this.ativo = ativo;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String logradouro) {
        Logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getBaiID() {
        return baiID;
    }

    public void setBaiID(int baiID) {
        this.baiID = baiID;
    }

    public int getCidID() {
        return cidID;
    }

    public void setCidID(int cidID) {
        this.cidID = cidID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create =  Utils.getStrDate(create);;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = Utils.isIntBool(ativo);
    }
}
