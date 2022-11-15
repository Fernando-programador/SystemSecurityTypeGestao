package com.autenticacao.gestao.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.autenticacao.gestao.Model.Usuario;


@Repository
@EnableJpaRepositories
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //Optional<Usuario> findbyId(Long id);
    Optional<Usuario> findByEmail(String email);
    
}
