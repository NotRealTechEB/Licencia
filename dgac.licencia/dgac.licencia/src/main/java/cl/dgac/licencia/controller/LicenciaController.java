package cl.dgac.licencia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.dgac.licencia.dto.CreateLicenciaDTO;
import cl.dgac.licencia.dto.LicenciaValidacionDTO;
import cl.dgac.licencia.dto.UpdateLicenciaDTO;
import cl.dgac.licencia.mapper.LicenciaMapper;
import cl.dgac.licencia.model.Licencia;
import cl.dgac.licencia.service.LicenciaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/dgac/licencia")
public class LicenciaController {

    private final LicenciaService licenciaService;

    public LicenciaController(LicenciaService licenciaService){
        this.licenciaService = licenciaService;
    }

    //Obtener todas las licencias

    @GetMapping
    public ResponseEntity<List<Licencia>> listarLicencias(){
        List<Licencia> lic = licenciaService.listarLicencias();
        return ResponseEntity.ok(lic);
    }

    //Obtener estado de licencia

    @GetMapping("/validar")
    public ResponseEntity<LicenciaValidacionDTO> validarEstadoLicencia(@RequestParam("idPiloto") int idPiloto){
        LicenciaValidacionDTO validar = licenciaService.validarLicencia(idPiloto);
        return ResponseEntity.ok(validar);
    }

    //Guardar nueva licencia

    @PostMapping
    public ResponseEntity<Licencia> guardarLicencias(@Valid @RequestBody CreateLicenciaDTO request){
        Licencia lic = licenciaService.guardarLicencias(LicenciaMapper.toModel(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(lic);
    }

    //Actualizar datos de licencias

    @PutMapping
    public ResponseEntity<Licencia> actualizarLicencias(@Valid @RequestBody UpdateLicenciaDTO request){
        Licencia lic = licenciaService.actualizarLicencias(LicenciaMapper.toModel(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(lic);
    }

    //Eliminar licencias

    @DeleteMapping
    public ResponseEntity<String> eliminarLicencias(@PathVariable int idLicencia){
        licenciaService.eliminarLicencias(idLicencia);
        return ResponseEntity.noContent().build();
    }

    
}
