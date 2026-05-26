package cl.dgac.licencia.mapper;

import cl.dgac.licencia.dto.CreateLicenciaDTO;
import cl.dgac.licencia.dto.UpdateLicenciaDTO;
import cl.dgac.licencia.model.Licencia;

public class LicenciaMapper {
    public static Licencia toModel(CreateLicenciaDTO request){
        return new Licencia(0, request.idPiloto(), request.fechaVen(), request.estVigencia());
    }

    public static Licencia toModel(UpdateLicenciaDTO request){
        return new Licencia(0, request.idPiloto(), request.fechaVen(), request.estVigencia());
    }
}
