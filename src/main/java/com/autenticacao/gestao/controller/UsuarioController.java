package com.autenticacao.gestao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autenticacao.gestao.dto.LoginRequest;
import com.autenticacao.gestao.dto.LoginResponse;
import com.autenticacao.gestao.model.Usuario;
import com.autenticacao.gestao.service.UsuarioService;


//@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<Usuario> obterTodos() {
        return usuarioService.obterTodos();
    }

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> obterPorId(@PathVariable("id") Long id) {
        return usuarioService.obterPorId(id);

    }

    @CrossOrigin(origins =  "localhost:8080")
    @PostMapping("/usuario")
    public Usuario adicionar(Usuario usuario) {
        return usuarioService.adicionar(usuario);
    }

    @PostMapping("/signin")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return usuarioService.logar(request.getEmail(), request.getSenha());
    }

}
