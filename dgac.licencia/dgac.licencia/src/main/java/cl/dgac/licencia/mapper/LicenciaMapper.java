package cl.dgac.licencia.mapper;

import cl.dgac.licencia.dto.CreateLicencia;
import cl.dgac.licencia.dto.UpdateLicencia;
import cl.dgac.licencia.model.Licencia;

public class LicenciaMapper {
    public static Licencia toModel(CreateLicencia request){
        return new Licencia(0, request.fechaReg(), request.fechaVen());
    }

    public static Licencia toModel(UpdateLicencia request){
        return new Licencia(0, request.fechaReg(), request.fechaVen());
    }
}
