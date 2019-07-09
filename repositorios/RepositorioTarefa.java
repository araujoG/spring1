package com.example.twgerenciadortarefas.repositorios;

import com.example.twgerenciadortarefas.modelos.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTarefa extends JpaRepository<Tarefa, Long>{

}