package com.autenticacao.gestao.security;

import java.util.Collection;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.autenticacao.gestao.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;



public class UsuarioImpl implements UserDetails {


 
	private static final long serialVersionUID = 1L;

	private Long id;

    private String nome;

    private String email;

    @JsonIgnore
    private String senha;

  

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //Daqui parea baixo foi uma implementação do Userdetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
        return null;
    }

    @Override
    public String getPassword() {
       
        return senha;
    }

    @Override
    public String getUsername() {
       
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
       
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      
        return true;
    }

    @Override
    public boolean isEnabled() {
       
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsuarioImpl other = (UsuarioImpl) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public static UserDetails build(Usuario usuario) {
        return null;
    }
    
    
    
}
