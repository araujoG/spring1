package com.example.twgerenciadortarefas.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

//modelo que explicita oq é uma tarefa
//sera uma tabela no banco de dados

@Entity
@Table(name = "tar_tarefas")
public class Tarefa {

    @Id //identifica a chave principal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tar_id") //relaciona um atributo com a coluna name do mysql
    private long id;

    @Column(name = "tar_titulo", length = 50, nullable = false)
    @NotNull(message = "O título é obrigatório")
    @Length(max = 50, min = 3, message = "O título deve conter entre 3 e 50 caracteres")
    private String titulo;

    @Column(name = "tar_descricao", length = 100, nullable = true)    
    @Length(max = 100, message = "A descrição deve conter no máximo 100 caracteres")
    private String descricao;

    @Column(name = "tar_data_expiracao", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataExpiracao;

    @Column(name = "tar_concluida", nullable = false)
    private Boolean concluida = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }
    
    
}