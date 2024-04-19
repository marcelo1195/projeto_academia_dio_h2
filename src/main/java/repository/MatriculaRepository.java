package repository;

import entity.AvaliacaoFisica;
import entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    // Método para buscar matriculas por bairro de aluno
    @Query("select m from Matricula m where m.aluno.bairro = :bairro")
    List<Matricula> findAllByAlunoBairro(@Param("bairro") String bairro);
}
