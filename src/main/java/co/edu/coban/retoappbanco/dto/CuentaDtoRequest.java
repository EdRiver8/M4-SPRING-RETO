package co.edu.coban.retoappbanco.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CuentaDtoRequest(
        @NotBlank(message = "El número de cuenta no puede ser vacío")
        String numeroCuenta,
        @Min(value = 0, message = "El monto debe ser mayor o igual a cero")
        Double monto,
        @NotBlank(message = "El tipo de cuenta no puede ser vacío")
        String tipoCuenta,
        @NotBlank(message = "El username no puede ser vacío")
        String username,
        String email
) {
}
