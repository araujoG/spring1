package com.example.twgerenciadortarefas.modelos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * Usuario
 */
@Entity
@Table(name = "usr_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @Column(name = "usr_email", nullable = false, length = 100)
    @NotNull(message = "O e-mail é obrigatório.")
    @Length(min = 5, max = 100, message = "O e-mail deve conter entre 5 e 100 caracteres")
    private String email;

    @Column(name = "usr_password", nullable = false, length = 100)
    @NotNull(message = "A senha é obrigatória.")
    private String password;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY) //lazy so preenche a lista de tarefas quando explicitado
    private List<Tarefa> tarefas;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    
}