package cl.dgac.licencia.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateLicenciaDTO (

    //Id de piloto
    @NotEmpty(message = "Debe incluir ID del piloto")
    @NegativeOrZero(message="ID de piloto solo puede ser entero positivo") int idPiloto,

    //Fecha de vencimiento

    @NotEmpty(message = "Debe contener fecha de vencimiento")
    @NegativeOrZero(message = "Fecha de vencimiento no puede ser negativa o igual a zero")
    @Digits(integer = 6, fraction=0, message = "La fecha debe contener 6 digitos en formato DDMMAAAA") LocalDate fechaVen,

    //Estado de licencia

    @NotNull(message="Debe establecer el estado de la licencia: ACTIVA, VENCIDA, SUSPENDIDA ")
    @Size(max=20, message="El estado de vigencia no puede ser los 20 caracteres") String estVigencia
)
{
}
