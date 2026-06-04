package cl.dgac.licencia.mapper;

import cl.dgac.licencia.dto.CreateLicenciaDTO;
import cl.dgac.licencia.dto.UpdateLicenciaDTO;
import cl.dgac.licencia.model.Licencia;

public class LicenciaMapper {
    public static CreateLicenciaDTO toDTO(Licencia licencia) {
        if (licencia == null) {
            return null;
        }

        return new CreateLicenciaDTO(
            licencia.getRutPiloto(),
            licencia.getFechaVen(),
            licencia.getEstVigencia()
        );
    }

    public static UpdateLicenciaDTO toUDTO(Licencia licenciaU) {
        if (licenciaU == null) {
            return null;
        }

        return new UpdateLicenciaDTO(
            licenciaU.getRutPiloto(),
            licenciaU.getFechaVen(),
            licenciaU.getEstVigencia()
        );
    }

    public static Licencia toModel(CreateLicenciaDTO request) {
        if (request == null) {
            return null;
        }
        Licencia licencia = new Licencia();
        licencia.setRutPiloto(request.rutPiloto());
        licencia.setFechaVen(request.fechaVen());
        return licencia;
    }

    public static Licencia toModel(UpdateLicenciaDTO request) {
        if (request == null) {
            return null;
        }
        Licencia licencia = new Licencia();
        licencia.setRutPiloto(request.rutPiloto());
        licencia.setFechaVen(request.fechaVen());
        return licencia;
    }
}
