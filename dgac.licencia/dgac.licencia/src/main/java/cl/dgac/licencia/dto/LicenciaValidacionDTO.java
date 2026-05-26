package cl.dgac.licencia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenciaValidacionDTO {
    private int idPiloto;
    private boolean estValidacion;
    private String anotacion;
}
