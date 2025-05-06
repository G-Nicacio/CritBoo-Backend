package br.edu.insper.CritBoo.Jogo.Jogos;

import br.edu.insper.CritBoo.Jogo.Categoria.Categoria;
import br.edu.insper.CritBoo.Jogo.Categoria.CategoriaRepository;
import br.edu.insper.CritBoo.Jogo.Estudio.Estudio;
import br.edu.insper.CritBoo.Jogo.Estudio.EstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private EstudioRepository estudioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Page<Jogo> getTodosJogos(Pageable pageable) {
        return jogoRepository.findAll(pageable);
    }

    public Jogo getJogoPorId(Integer id) {
        return jogoRepository.findById(id).orElse(null);
    }

    public Page<Jogo> getJogos(String nome, LocalDate lancamentoJogo, Pageable pageable) {
        if (nome != null && lancamentoJogo != null) {
            return jogoRepository.findByNomeJogoContainingAndLancamentoJogo(nome, lancamentoJogo, pageable);
        } else if (nome != null) {
            return jogoRepository.findByNomeJogoContaining(nome, pageable);
        } else if (lancamentoJogo != null) {
            return jogoRepository.findByLancamentoJogo(lancamentoJogo, pageable);
        }
        return jogoRepository.findAll(pageable);
    }

    public Jogo getJogos(Integer id) {
        return jogoRepository.findById(id).orElse(null);
    }

    public void salvarJogo(Jogo jogo){
        if (jogo.getEstudio() != null && jogo.getEstudio().getId() != null) {
            Estudio estudio = estudioRepository.findById(jogo.getEstudio().getId())
                    .orElseThrow(() -> new RuntimeException("Estúdio não encontrado"));
            jogo.setEstudio(estudio);
        } else {
            throw new RuntimeException("Estúdio é obrigatório");
        }

        if (jogo.getCategorias() != null && !jogo.getCategorias().isEmpty()) {
            Set<Categoria> categoriasPersistidas = new HashSet<>();
            for (Categoria categoria : jogo.getCategorias()) {
                Categoria cat = categoriaRepository.findById(categoria.getId())
                        .orElseThrow(() -> new RuntimeException("Categoria com ID " + categoria.getId() + " não encontrada"));
                categoriasPersistidas.add(cat);
            }
            jogo.setCategorias(categoriasPersistidas);
        }

        jogoRepository.save(jogo);
    }

    public void deleteJogo(Integer id) {
        jogoRepository.deleteById(id);
    }

    public Jogo editarJogo(Integer id, Jogo jogo) {
        Jogo jogoEditar = getJogos(id);
        if (jogoEditar != null) {
            if (jogo.getNomeJogo() != null) {
                jogoEditar.setNomeJogo(jogo.getNomeJogo());
            }
            if (jogo.getDescricaoJogo() != null) {
                jogoEditar.setDescricaoJogo(jogo.getDescricaoJogo());
            }
            if (jogo.getLancamentoJogo() != null) {
                jogoEditar.setLancamentoJogo(jogo.getLancamentoJogo());
            }
            if (jogo.getImagem() != null) {
                jogoEditar.setImagem(jogo.getImagem());
            }
            if (jogo.getCategorias() != null) {
                jogoEditar.setCategorias(jogo.getCategorias());
            }
            if (jogo.getEstudio() != null) {
                jogoEditar.setEstudio(jogo.getEstudio());
            }


            return jogoRepository.save(jogoEditar);
        }
        return null;
    }


    public Page<Jogo> getTopJogos(int quantidade) {
        Pageable pageable = PageRequest.of(0, quantidade);
        return jogoRepository.findJogosRecentes(pageable);
    }
}
