package com.example.twgerenciadortarefas.controllers;

import java.util.Date;

import javax.validation.Valid;

import com.example.twgerenciadortarefas.modelos.Tarefa;
import com.example.twgerenciadortarefas.repositorios.RepositorioTarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tarefas")
public class TarefasController {

    @Autowired //injeção de dependencias
    private RepositorioTarefa repositorioTarefa;

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tarefas/listar");
        mv.addObject("tarefas", repositorioTarefa.findAll());
        return mv;
    }

    @GetMapping("/inserir")
    public ModelAndView inserir() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tarefas/inserir");
        mv.addObject("tarefa", new Tarefa());
        return mv;
    }

    @PostMapping("/inserir")
    public ModelAndView inserir(@Valid Tarefa tarefa, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if(tarefa.getDataExpiracao() == null){
            result.rejectValue("dataExpiracao","tarefa.dataExpiracaoInvalida","A data de expiração é obrigatória");
        }else{
            if(tarefa.getDataExpiracao().before(new Date())){
                result.rejectValue("dataExpiracao","tarefa.dataExpiracaoInvalida","A data de expiração não pode ser anterior à data atual");
            }
        }
        if(result.hasErrors()){
            mv.setViewName("tarefas/inserir");
            mv.addObject(tarefa);
        }else{
            mv.setViewName("redirect:/tarefas/listar");
            repositorioTarefa.save(tarefa);
        }
        return mv;
    }
    
}