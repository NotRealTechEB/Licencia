package cl.dgac.licencia.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.dgac.licencia.dto.CreateLicenciaDTO;
import cl.dgac.licencia.dto.LicenciaValidacionDTO;
import cl.dgac.licencia.dto.UpdateLicenciaDTO;
import cl.dgac.licencia.exception.ResourceNotFoundException;
import cl.dgac.licencia.mapper.LicenciaMapper;
import cl.dgac.licencia.model.Licencia;
import cl.dgac.licencia.repository.LicenciaRepository;

@Service
public class LicenciaService {

    @Autowired
    private LicenciaRepository licenciaRepo;

    //-------------------------------Metodos de administracion-------------------------------//

    //Método para mostrar todas las licencias

    public List<Licencia> listarLicencias(){
        return licenciaRepo.findAll();
    }

    //Método para registrar nuevas licencias

    public CreateLicenciaDTO guardarLicencia(CreateLicenciaDTO dto) {
    Licencia licencia = new Licencia();
    licencia.setRutPiloto(dto.rutPiloto());
    licencia.setFechaVen(dto.fechaVen());
    
    if (dto.fechaVen().isBefore(LocalDate.now())) {
        licencia.setEstVigencia("VENCIDA");
    } else {
        licencia.setEstVigencia("ACTIVA");
    }
    
    Licencia licCrear = licenciaRepo.save(licencia);
    return LicenciaMapper.toDTO(licCrear);
    }

    //Método para actualizar datos de licencias

    public UpdateLicenciaDTO actualizarLicencia(int idLicencia, UpdateLicenciaDTO dto) {
    Licencia licenciaExistente = licenciaRepo.findById(idLicencia)
        .orElseThrow(() -> new ResourceNotFoundException("No se encontró la licencia con ID: " + idLicencia));
    licenciaExistente.setRutPiloto(dto.rutPiloto());
    licenciaExistente.setFechaVen(dto.fechaVen());

    if (dto.fechaVen().isBefore(LocalDate.now())) {
        licenciaExistente.setEstVigencia("VENCIDA");
    } else {
        licenciaExistente.setEstVigencia("ACTIVA");
    }
    Licencia licenciaActualizada = licenciaRepo.save(licenciaExistente);

    return LicenciaMapper.toUDTO(licenciaActualizada);
    }
    
    //Método para eliminar licencias

    public String eliminarLicencias(int idLicencia){
        licenciaRepo.deleteById(idLicencia);
        return "La licencia ha sido eliminada";
    }
    

    //-------------------------------Metodos HU - Piloto-------------------------------//

    //Método para validar licencia

    public LicenciaValidacionDTO validarLicencia(String rutPiloto){
        Licencia licencia = licenciaRepo.findByRutPiloto(rutPiloto);
        if(licencia == null){
            return new LicenciaValidacionDTO(rutPiloto, false, "El rut no posee una licencia registrada");
        }

        boolean estVigente = licencia.getFechaVen().isAfter(LocalDate.now());
        long diasParaVencer = ChronoUnit.DAYS.between(LocalDate.now(), licencia.getFechaVen());
        boolean estPorVencer = diasParaVencer <= 30 && diasParaVencer >= 0;
        boolean estActiva = "ACTIVA".equalsIgnoreCase(licencia.getEstVigencia());
        

        if(estActiva && estVigente){
            return new LicenciaValidacionDTO(rutPiloto, estActiva, "El piloto está habilitado.");
        }
        else if(estActiva && estPorVencer){
            return new LicenciaValidacionDTO(rutPiloto, estActiva, "El piloto está habilitado. Tiene " + diasParaVencer + " días para renovar su licencia.");
            
        }else{
            return new LicenciaValidacionDTO(rutPiloto, false, "El piloto no está habilitado. ");
        }
    }
}

