package com.example.twgerenciadortarefas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.twgerenciadortarefas.modelos.Usuario;
import com.example.twgerenciadortarefas.repositorios.RepositorioUsuario;


/**
 * ServicoUsuario
 */
@Service //Indica q é uma classe de serviço
public class ServicoUsuario {

    @Autowired //Spring se carrega de criar e injetar dentro da classe
    private RepositorioUsuario repositorioUsuario;

    @Autowired //Todo autowired é um objeto bean q o spring sabe criar(ou foi ensinado em configuration)
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario encontrarPorEmail(String email){
        return repositorioUsuario.findByEmail(email);
    }

    public void salvar(Usuario usuario) {
        //Criptografar a senha com um hash criptografia unidirecional
        //impossivel de ser desfeita assim a senha do usuario n é exposta
        usuario.setpassword(passwordEncoder.encode(usuario.getpassword()));
        repositorioUsuario.save(usuario);
    }

}