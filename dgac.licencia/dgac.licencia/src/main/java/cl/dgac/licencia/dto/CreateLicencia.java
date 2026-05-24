package cl.dgac.licencia.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotEmpty;

public record CreateLicencia (

    @NotEmpty(message = "Debe contener fecha de registro")
    @NegativeOrZero(message = "Fecha de registro no puede ser negativa o igual a zero")
    @Digits(integer = 6, fraction=0, message = "La fecha debe contener 6 digitos en formato DDMMAAAA") int fechaReg,

    @NotEmpty(message = "Debe contener fecha de vencimiento")
    @NegativeOrZero(message = "Fecha de vencimiento no puede ser negativa o igual a zero")
    @Digits(integer = 6, fraction=0, message = "La fecha debe contener 6 digitos en formato DDMMAAAA") int fechaVen
)
{
}
