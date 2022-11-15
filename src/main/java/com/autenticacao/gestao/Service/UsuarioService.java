package com.autenticacao.gestao.Service;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.autenticacao.gestao.Model.Usuario;
import com.autenticacao.gestao.Repository.UsuarioRepository;
import com.autenticacao.gestao.Security.JWTService;
import com.autenticacao.gestao.View.Model.usuario.LoginResponse;

@Service
public class UsuarioService {

    private static final String hederPrefix = "Bearer ";

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public List<Usuario> obterTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obterPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> obterPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario adicionar(Usuario usuario) {
        usuario.setId(null);

        if (obterPorEmail(usuario.getEmail()).isPresent()) {
            // verificando se ja tem um cadaastro de email registrado e vou lançar uma
            // exceção
            throw new InputMismatchException(
                    "Já existe um usuário cadastrado com o email: " + usuario.getEmail() + " Operação inválida.");
        }

        // cadastrando uma senha para usuario codificado gerando um hash da senha
        String senha = passwordEncoder.encode(usuario.getSenha());

        usuario.setSenha(senha);

        return usuarioRepository.save(usuario);
    }

    public LoginResponse logar(String email, String senha) {

        // essa parte faz authetenticação do login caso não consiga vai estourar uma
        // exceção
        Authentication autenticacao = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, senha, Collections.emptyList()));

        // aqui eu asso a nova authenticação para spring security cuidadar para mim
        SecurityContextHolder.getContext().setAuthentication(autenticacao);

        // aqui gero o token do usuario para devolver a ele
        // ex: Bearer aasdjasdhadnsa9a9as8asn98ad.sad09uas90
        String token = hederPrefix + jwtService.gerarToken(autenticacao);

        // aqui eu estou buscando o email do repositorio
        Usuario usuario = usuarioRepository.findByEmail(email).get();

        return new LoginResponse(token, usuario);

    }

}
