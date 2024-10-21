package co.edu.coban.retoappbanco.dto;

import java.time.LocalDateTime;

public record CuentaDtoResponse(
        String numeroCuenta,
        Double saldo,
        String tipoCuenta,
        String username,
        String email
        ) {
}
