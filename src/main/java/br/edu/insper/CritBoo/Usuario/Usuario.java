package br.edu.insper.CritBoo.Usuario;

import java.time.LocalDate;
import java.util.Random;

public class Usuario {

    private Random geraId = new Random();
    private Integer id = geraId.nextInt(1000000);
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
//    private Historico historico = new Historico();

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public void setEmail(String email) {this.email = email;}

    public String getSenha() {return senha;}

    public void setSenha(String senha) {this.senha = senha;}

    public LocalDate getDataNascimento() {return dataNascimento;}

    public void setDataNascimento(LocalDate dataNascimento) {this.dataNascimento = dataNascimento;}


//    public Historico getHistorico() {return historico;}
//
//    public void setHistorico(Historico historico) {this.historico = historico;}

}
