package br.edu.insper.CritBoo.Usuario.JogosFavoritos;

import br.edu.insper.CritBoo.Usuario.Usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogosFavoritosRepository extends JpaRepository<JogosFavoritos, Integer> {
    JogosFavoritos findByUsuario(Usuario usuario);
}
