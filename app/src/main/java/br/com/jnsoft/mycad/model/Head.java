package br.com.jnsoft.mycad.model;

public class Head {
    private boolean erro;
    private String message;
    private Integer code;

    public Head() {}

    public Head(boolean erro, String message, Integer code) {
        this.erro = erro;
        this.message = message;
        this.code = code;
    }

    public boolean getErro() {
        return erro;
    }

    public void setErro(boolean erro) {
        this.erro = erro;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
