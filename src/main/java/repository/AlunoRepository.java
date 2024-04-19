package repository;

import entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    @Query("select d from Aluno d where d.aluno.dataDeNascimento = :dataDeNascimento")
    List<Aluno> findAllByAlunoDataDeNascimento(@Param("dataDeNascimento") LocalDate dataDeNascimento);

}
