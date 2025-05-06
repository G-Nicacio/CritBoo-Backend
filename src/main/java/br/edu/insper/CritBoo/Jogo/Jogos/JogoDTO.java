package br.edu.insper.CritBoo.Jogo.Jogos;

import br.edu.insper.CritBoo.Jogo.Categoria.CategoriaDTO;
import br.edu.insper.CritBoo.Jogo.Estudio.EstudioDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class JogoDTO {
    private Integer id;
    private String nomeJogo;
    private String descricaoJogo;
    private LocalDate lancamentoJogo;
    private EstudioDTO estudio;
    private List<CategoriaDTO> categorias;

    public JogoDTO(Jogo jogo) {
        this.id = jogo.getId();
        this.nomeJogo = jogo.getNomeJogo();
        this.descricaoJogo = jogo.getDescricaoJogo();
        this.lancamentoJogo = jogo.getLancamentoJogo();
        this.estudio = new EstudioDTO(jogo.getEstudio());
        this.categorias = jogo.getCategorias().stream()
                .map(CategoriaDTO::new)
                .collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public String getDescricaoJogo() {
        return descricaoJogo;
    }

    public LocalDate getLancamentoJogo() {
        return lancamentoJogo;
    }

    public EstudioDTO getEstudio() {
        return estudio;
    }

    public List<CategoriaDTO> getCategorias() {
        return categorias;
    }
}
