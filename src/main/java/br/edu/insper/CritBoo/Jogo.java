package br.edu.insper.CritBoo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Jogo {
    private String nomeJogo;
    private String descricaoJogo;
    private LocalDate lancamentoJogo;
    private ArrayList<Categoria> categorias = new ArrayList<>();
    private float avaliacaoMedia;
    private Estudio estudio = new Estudio();
}
