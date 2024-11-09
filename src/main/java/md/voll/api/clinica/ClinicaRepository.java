package md.voll.api.clinica;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicaRepository extends JpaRepository<Clinica, Long> {

    Page<Clinica> findAllByAtivoTrue(Pageable paginacao);

}
