package cl.dgac.licencia.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UpdateLicenciaDTO (

    //Rut de piloto
    @NotNull(message = "Debe incluir RUT del piloto")
    @Size(min=8,max=12, message="RUT de piloto debe tener entre 8 y 12 caracteres") Integer rutPiloto,

    //Fecha de vencimiento
    @NotNull(message = "Debe contener fecha de vencimiento")
    @Positive(message = "Fecha de vencimiento no puede ser negativa o igual a zero") LocalDate fechaVen,

    //Estado de licencia
    @NotNull(message="Debe establecer el estado de la licencia: ACTIVA, VENCIDA, SUSPENDIDA ")
    @Size(max=20, message="El estado de vigencia no puede ser los 20 caracteres") String estVigencia
)
{
}
