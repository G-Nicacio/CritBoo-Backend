package br.edu.insper.CritBoo.Usuario.Usuarios;

import br.edu.insper.CritBoo.Usuario.Historico.Historico;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Usuario {
    @Column(nullable = false)
    private String nome;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "historico_id", referencedColumnName = "id")
    private Historico historico = new Historico();

    @Column(nullable = false, unique = true)
    private String senha;

    @Column(nullable = false)
    private LocalDate dataNascimento;
//    private Historico historico = new Historico();

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}

    public int getId() {return id;}

    public void setId() {this.id = id;}

    public void setEmail(String email) {this.email = email;}

    public String getSenha() {return senha;}

    public void setSenha(String senha) {this.senha = senha;}

    public LocalDate getDataNascimento() {return dataNascimento;}

    public void setDataNascimento(LocalDate dataNascimento) {this.dataNascimento = dataNascimento;}


//    public Historico getHistorico() {return historico;}
//
//    public void setHistorico(Historico historico) {this.historico = historico;}

}
