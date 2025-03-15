package br.edu.insper.CritBoo.Jogo;

import br.edu.insper.CritBoo.Usuario.Usuario;
import br.edu.insper.CritBoo.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AvaliacaoService {
    @Autowired
    private JogoService jogoService;

    @Autowired
    private UsuarioService usuarioService;

    private HashMap<Integer, Avaliacao> avaliacoes = new HashMap<>();

    public HashMap<Integer, Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public Avaliacao getUmaAvaliacao(Integer id) {
        return avaliacoes.get(id);
    }

    public String registrarAvaliacao(Avaliacao avaliacao) {
        Usuario usuarioBusca = usuarioService.getUsuario(avaliacao.getUsuario().getId());
        Jogo jogoBusca = jogoService.getJogos(avaliacao.getJogo().getId());

        if (usuarioBusca != null && jogoBusca != null) {
            if (avaliacao.getId() == 0) {
                avaliacao.setId(avaliacoes.size() + 1);
            }
            avaliacoes.put(avaliacao.getId(), avaliacao);
            return "registrado";
        }
        return "Faltando algo";
    }

    public Avaliacao deletarAvaliacao(Integer id) {
        return avaliacoes.remove(id);
    }

    public String editarAvaliacao(Integer id, Avaliacao avaliacao) {
        Usuario usuarioBusca = usuarioService.getUsuario(avaliacao.getUsuario().getId());
        Jogo jogoBusca = jogoService.getJogos(avaliacao.getJogo().getId());
        Avaliacao avaliacaoBusca = avaliacoes.get(id);

        if (usuarioBusca != null && jogoBusca != null && avaliacaoBusca != null) {
            avaliacao.setId(avaliacaoBusca.getId());
            avaliacoes.remove(id);
            avaliacoes.put(avaliacao.getId(), avaliacao);
            return "Editado";
        }

        return "Não encontrado";
        }
    }
