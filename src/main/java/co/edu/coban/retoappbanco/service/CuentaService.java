package co.edu.coban.retoappbanco.service;

import co.edu.coban.retoappbanco.dto.CuentaDtoRequest;
import co.edu.coban.retoappbanco.dto.CuentaDtoResponse;

import java.util.List;

public interface CuentaService {
    List<CuentaDtoResponse> obtenerTodasCuentas();
    void realizarDeposito(String numeroCuenta, Double monto);

    void realizarRetiro(Long cuentaId, Double monto);
    void realizarRetiro(String numeroCuenta, Double monto);
    Double consultarSaldo(Long cuentaId);
    CuentaDtoResponse consultarSaldo(String tipoCuenta, CuentaDtoRequest cuentaDtoRequest);
}
