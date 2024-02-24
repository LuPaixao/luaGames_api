package lua.games.api.jogo;

import lua.games.api.desenvolvedor.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository <Jogo, Long> {
}
