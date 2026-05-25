package cl.dgac.licencia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.dgac.licencia.model.Licencia;
import cl.dgac.licencia.repository.LicenciaRepository;

@Service
public class LicenciaService {
    private LicenciaRepository licenciaRepo;

    //Método para mostrar todas las licencias

    public List<Licencia> listarLicencias(){
        return licenciaRepo.findAll();
    }

    //Método para registrar nuevas licencias

    public Licencia guardarLicencias(Licencia licencia){
        return licenciaRepo.save(licencia);
    }

    //Método para actualizar datos de licencias

    public Licencia actualizarLicencias(Licencia licencia){
        return licenciaRepo.save(licencia);
    }

    //Método para eliminar licencias

    public String eliminarLicencias(int idLicencia){
        licenciaRepo.deleteById(idLicencia);
        return "La licencia ha sido eliminada";
    }
}
