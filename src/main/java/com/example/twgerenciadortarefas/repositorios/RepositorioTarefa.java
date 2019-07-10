package com.example.twgerenciadortarefas.repositorios;

import java.util.List;

import com.example.twgerenciadortarefas.modelos.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositorioTarefa extends JpaRepository<Tarefa, Long>{

    @Query("SELECT t FROM Tarefa t WHERE t.usuario.email = :emailUsuario")
    List<Tarefa> carregarTarefasPorUsuario(@Param("emailUsuario") String email);
}