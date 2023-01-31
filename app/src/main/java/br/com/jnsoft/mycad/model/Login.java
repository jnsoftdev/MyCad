package br.com.jnsoft.mycad.model;

import br.com.jnsoft.mycad.helper.Utils;

public class Login {
    int id;
    int cliID;
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

    public void setAcesso(String acesso) {
        this.acesso = Utils.isIntBool(acesso);
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = Utils.isIntBool(ativo);
    }
}
