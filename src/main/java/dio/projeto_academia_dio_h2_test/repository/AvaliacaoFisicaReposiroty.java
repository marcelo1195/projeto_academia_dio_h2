package dio.projeto_academia_dio_h2_test.repository;

import dio.projeto_academia_dio_h2_test.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoFisicaReposiroty extends JpaRepository<AvaliacaoFisica, Long> {
}
