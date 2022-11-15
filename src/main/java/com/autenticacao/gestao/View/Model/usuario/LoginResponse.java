package com.autenticacao.gestao.View.Model.usuario;

import com.autenticacao.gestao.Model.Usuario;

public class LoginResponse {
    
    private String token;
    private Usuario usuario;

    public LoginResponse() {
    }
    
    /**
     * @param token
     * @param usuario
     */
    public LoginResponse(String token, Usuario usuario) {
        this.token = token;
        this.usuario = usuario;
    }




    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
