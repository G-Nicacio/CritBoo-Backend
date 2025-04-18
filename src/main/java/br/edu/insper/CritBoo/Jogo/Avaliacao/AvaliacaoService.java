package br.edu.insper.CritBoo.Jogo.Avaliacao;

import br.edu.insper.CritBoo.Jogo.Jogos.JogoService;
import br.edu.insper.CritBoo.Usuario.Usuarios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {
    @Autowired
    private JogoService jogoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> getAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao getUmaAvaliacao(Integer id) {
        return avaliacaoRepository.findById(id).get();
    }

    public void registrarAvaliacao(Avaliacao avaliacao) {
        avaliacaoRepository.save(avaliacao);
    }

    public void deletarAvaliacao(Integer id) {
        avaliacaoRepository.deleteById(id);
    }

    public Avaliacao editarAvaliacao(Avaliacao avaliacaoAnterior,Avaliacao avaliacao) {
        avaliacaoAnterior.setComentario(avaliacao.getComentario());
        avaliacaoAnterior.setJogo(avaliacao.getJogo());
        avaliacaoAnterior.setNota(avaliacao.getNota());
        avaliacaoAnterior.setUsuario(avaliacao.getUsuario());

        return avaliacaoRepository.save(avaliacaoAnterior);
        }
    }
