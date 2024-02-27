package lua.games.api.jogo;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository <Jogo, Long> {
    Page<Jogo> findAllByAtivoTrue(Pageable paginacao);
}
