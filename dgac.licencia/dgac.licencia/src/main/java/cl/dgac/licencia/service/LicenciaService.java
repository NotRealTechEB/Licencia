package cl.dgac.licencia.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.dgac.licencia.dto.LicenciaValidacionDTO;
import cl.dgac.licencia.model.Licencia;
import cl.dgac.licencia.repository.LicenciaRepository;

@Service
public class LicenciaService {

    @Autowired
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

    //Método para validar licencia

    public LicenciaValidacionDTO validarLicencia(int idPiloto){
        Licencia licencia = licenciaRepo.findByIdPiloto(idPiloto).orElse(null);
        if(licencia == null){
            return new LicenciaValidacionDTO(null, false, null);
        }

        boolean estVigente = licencia.getFechaVen().isAfter(LocalDate.now());
        boolean estActiva = "ACTIVA".equalsIgnoreCase(licencia.getEstVigencia());

        if(estActiva && estVigente){
            return new LicenciaValidacionDTO(null, estActiva, null);
        }else{
            return new LicenciaValidacionDTO(null, estActiva, null);
        }
    }
}
