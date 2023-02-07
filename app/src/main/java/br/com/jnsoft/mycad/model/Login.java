package br.com.jnsoft.mycad.model;

import br.com.jnsoft.mycad.helper.Utils;

public class Login {
    int id;
    int cliID;
    String nome;
    String cgc;
    String email;
    String fone;
    String user;
    String pass;
    Boolean acesso;
    Boolean ativo;

    public Login() {}

    public Login(int id, int cliID, String user, String pass, Boolean acesso, Boolean ativo) {
        this.id = id;
        this.cliID = cliID;
        this.user = user;
        this.pass = pass;
        this.acesso = acesso;
        this.ativo = ativo;
    }

    public Login(int id, int cliID, String nome, String cgc, String email, String fone, String user, String pass, Boolean acesso, Boolean ativo) {
        this.id = id;
        this.cliID = cliID;
        this.nome = nome;
        this.cgc = cgc;
        this.email = email;
        this.fone = fone;
        this.user = user;
        this.pass = pass;
        this.acesso = acesso;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliID() {
        return cliID;
    }

    public void setCliID(int cliID) {
        this.cliID = cliID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCgc() {
        return cgc;
    }

    public void setCgc(String cgc) {
        this.cgc = cgc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getAcesso() {
        return acesso;
    }

    public void setAcesso(Boolean acesso) {
        this.acesso = acesso;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
