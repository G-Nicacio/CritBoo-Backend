package br.edu.insper.CritBoo.Usuario.JogosFavoritos;

import br.edu.insper.CritBoo.Jogo.Jogos.Jogo;
import br.edu.insper.CritBoo.Usuario.Usuarios.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class JogosFavoritosService {

    @Autowired
    private JogosFavoritosRepository jogosFavoritosRepository;

    public JogosFavoritos adicionarJogoFavorito(Usuario usuario, Jogo jogo) {
        JogosFavoritos jogosFavoritos = jogosFavoritosRepository.findByUsuario(usuario);
        if (jogosFavoritos == null) {
            jogosFavoritos = new JogosFavoritos();
            jogosFavoritos.setUsuario(usuario);
        }
        jogosFavoritos.getJogosFavoritos().add(jogo);
        return jogosFavoritosRepository.save(jogosFavoritos);
    }

    public Set<Jogo> obterUltimasAvaliacoes(Usuario usuario) {
        JogosFavoritos jogosFavoritos = jogosFavoritosRepository.findByUsuario(usuario);
        return jogosFavoritos.getJogosFavoritos();
    }

    public Set<Jogo> obterJogosFavoritos(Usuario usuario) {
        JogosFavoritos jogosFavoritos = jogosFavoritosRepository.findByUsuario(usuario);
        if (jogosFavoritos != null) {
            return jogosFavoritos.getJogosFavoritos();
        }
        return null;
    }
}
