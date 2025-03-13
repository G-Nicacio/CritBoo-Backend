package br.edu.insper.CritBoo.Jogo;
import br.edu.insper.CritBoo.Categoria.Categoria;
import br.edu.insper.CritBoo.Jogo.estudio.Estudio;
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
