package cl.dgac.licencia.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateLicenciaDTO (

    //Rut de piloto
    @NotNull(message = "Debe incluir RUT del piloto")
    @Size(min=8,max=12, message="RUT de piloto debe tener entre 8 y 12 caracteres") String rutPiloto,

    //Fecha de vencimiento
    @NotNull(message = "Debe contener fecha de vencimiento")
    @Future(message = "Fecha de vencimiento no puede ser una fecha pasada") 
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") LocalDate fechaVen,

    String estVigencia
)
{
}
