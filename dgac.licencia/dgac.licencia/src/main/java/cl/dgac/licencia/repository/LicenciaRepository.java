package cl.dgac.licencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.dgac.licencia.model.Licencia;

@Repository
public interface LicenciaRepository extends JpaRepository<Licencia, Integer>{

}
