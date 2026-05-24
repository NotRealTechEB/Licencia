package cl.dgac.licencia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.dgac.licencia.dto.CreateLicencia;
import cl.dgac.licencia.service.LicenciaService;
import cl.dgac.licencia.model.Licencia;

@RestController
@RequestMapping("api/v1/dgac/licencia")
public class LicenciaController {

    private final LicenciaService licenciaService;

    public LicenciaController(LicenciaService licenciaService){
        this.licenciaService = licenciaService;
    }

    @GetMapping
    public ResponseEntity<List<Licencia>> listarLicencias(){
        List<Licencia> lic = licenciaService.listarLicencias();
        return ResponseEntity.ok(lic);
    }

    @PostMapping
    public ResponseEntity<Licencia> guardarLicencias(){
        Licencia lic = licenciaService.guardarLicencias();
        return ResponseEntity.ok(lic);
    }
}
