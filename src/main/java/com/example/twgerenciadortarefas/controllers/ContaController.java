package com.example.twgerenciadortarefas.controllers;

import javax.validation.Valid;

import com.example.twgerenciadortarefas.modelos.Usuario;
import com.example.twgerenciadortarefas.servicos.ServicoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ContaController
 */
@Controller
public class ContaController {

    @Autowired
    private ServicoUsuario ex;

    @GetMapping("/login")
    public String login() {
        return "conta/login";
    }

    @GetMapping("/registration")
    public ModelAndView registrar(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("conta/registrar");
        mv.addObject("usuario", new Usuario());
        return mv;
    }

    @PostMapping("/registration")
    public ModelAndView registrar(@Valid Usuario usuario, BindingResult result){
        ModelAndView mv = new ModelAndView();
        Usuario usr = ex.encontrarPorEmail(usuario.getEmail());
        if(usr!=null){
            result.rejectValue("email", "", "Email já cadastrado");
        }
        if(result.hasErrors()){
            mv.setViewName("conta/registrar");
            mv.addObject("usuarios", usuario);
        }
        else{
            ex.salvar(usuario);
            mv.setViewName("redirect:/login");
        }
        return mv;
    }
        

}