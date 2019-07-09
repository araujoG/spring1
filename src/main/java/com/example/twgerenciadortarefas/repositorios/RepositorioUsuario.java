package com.example.twgerenciadortarefas.repositorios;

import com.example.twgerenciadortarefas.modelos.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RepositorioUsuario
 */
public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{

    Usuario findByEmail(String Email); 
    //Classe finfByAtributo(TipoDoAtributo Atributo)
    //Basta seguir esse formato para buscar por qlq atributo
    //Spring ja gera o método automaticamente
    
}