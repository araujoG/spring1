package com.example.twgerenciadortarefas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class HomeController{

    // Verbos http 
    // get - ler algo que ta no servidor
    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/home");
        mv.addObject("mensagem", "Mensagem do controller");
        return mv;
    }   

}