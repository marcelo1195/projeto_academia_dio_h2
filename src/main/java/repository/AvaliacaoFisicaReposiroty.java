package repository;

import entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoFisicaReposiroty extends JpaRepository<AvaliacaoFisica, Long> {
}
