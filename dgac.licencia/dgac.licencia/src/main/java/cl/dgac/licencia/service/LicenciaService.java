package cl.dgac.licencia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.dgac.licencia.repository.LicenciaRepository;
import cl.dgac.licencia.model.Licencia;

@Service
public class LicenciaService {
    private LicenciaRepository licenciaRepo;

    public List<Licencia> listarLicencias(){
        return licenciaRepo.findAll();
    }

    public Licencia guardarLicencias(Licencia licencia){
        return licenciaRepo.save(licencia);
    }

    public Licencia actualizarLicencias(Licencia licencia){
        return licenciaRepo.save(licencia);
    }

    public String eliminarLicencias(int id){
        licenciaRepo.deleteById(id);
        return "La licencia ha sido eliminada";
    }
}
