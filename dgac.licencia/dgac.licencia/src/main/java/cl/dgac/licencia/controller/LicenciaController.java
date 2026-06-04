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
import cl.dgac.licencia.model.Licencia;
import cl.dgac.licencia.service.LicenciaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/licencia")
public class LicenciaController {

    private final LicenciaService licenciaService;

    public LicenciaController(LicenciaService licenciaService){
        this.licenciaService = licenciaService;
    }

    //-------------------------------Metodos de administracion-------------------------------//

    //Obtener todas las licencias

    @GetMapping
    public ResponseEntity<List<Licencia>> listarLicencias(){
        List<Licencia> lic = licenciaService.listarLicencias();
        return ResponseEntity.ok(lic);
    }

    //Guardar nueva licencias

    @PostMapping
    public ResponseEntity<CreateLicenciaDTO> guardarLicencia(@Valid @RequestBody CreateLicenciaDTO request){
        CreateLicenciaDTO lic = licenciaService.guardarLicencia(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(lic);
    }

    //Actualizar datos de licencias

    @PutMapping("/{idLicencia}")
    public ResponseEntity<UpdateLicenciaDTO> actualizarLicencia(@PathVariable("idLicencia") int idLicencia, @Valid @RequestBody UpdateLicenciaDTO request){
        UpdateLicenciaDTO lic = licenciaService.actualizarLicencia(idLicencia, request);
        return ResponseEntity.status(HttpStatus.OK).body(lic);
    }

    //Eliminar licencias

    @DeleteMapping("/{idLicencia}")
    public ResponseEntity<String> eliminarLicencias(@PathVariable("idLicencia") int idLicencia){
        licenciaService.eliminarLicencias(idLicencia);
        return ResponseEntity.noContent().build();
    }


    //-------------------------------Metodos HU - Piloto-------------------------------//

    //Obtener estado de licencia

    @GetMapping("/validar")
    public ResponseEntity<LicenciaValidacionDTO> validarEstadoLicencia(@RequestParam("rut") String rutPiloto){
        LicenciaValidacionDTO validar = licenciaService.validarLicencia(rutPiloto);
        return ResponseEntity.ok(validar);
    }
}
