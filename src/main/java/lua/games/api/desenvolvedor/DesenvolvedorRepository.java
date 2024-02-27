package lua.games.api.desenvolvedor;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Long> {
    Page<Desenvolvedor> findAllByAtivoTrue(Pageable paginacao);
}
