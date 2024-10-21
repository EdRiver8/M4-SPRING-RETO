package co.edu.coban.retoappbanco.controller;

import co.edu.coban.retoappbanco.dto.CuentaDtoRequest;
import co.edu.coban.retoappbanco.dto.CuentaDtoResponse;
import co.edu.coban.retoappbanco.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransaccionesController {
    private final CuentaService cuentaService;

    public TransaccionesController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Saludando desde la app de banco");
    }

    @GetMapping("/all")
    public ResponseEntity<List<CuentaDtoResponse>> consultarCuentas() {
        List<CuentaDtoResponse> cuentas = cuentaService.obtenerTodasCuentas();
        return ResponseEntity.ok(cuentas);
    }

    @GetMapping("/saldo/{cuentaId}")
    public ResponseEntity<Double> consultarSaldo(@PathVariable Long cuentaId) {
        Double saldo = cuentaService.consultarSaldo(cuentaId);
        return ResponseEntity.ok(saldo);
    }
//    @GetMapping("/saldo/{cuentaId}/{tipoCuenta}")
//    public ResponseEntity<Double> consultarSaldoDto(
//            @PathVariable Long cuentaId,
//            @PathVariable String tipoCuenta,
//            @Valid @RequestBody CuentaDtoRequest cuentaDtoRequest) {
//        CuentaDtoResponse cuentaDtoResponse = cuentaService.consultarSaldo(tipoCuenta, cuentaDtoRequest);
//        return ResponseEntity.ok(cuentaDtoResponse.saldo());
//    }

    @GetMapping("/saldo/{cuentaId}/{tipoCuenta}")
    public ResponseEntity<CuentaDtoResponse> consultarSaldoDto(
            @PathVariable Long cuentaId,
            @PathVariable String tipoCuenta,
            @Valid @RequestBody CuentaDtoRequest cuentaDtoRequest) {
        CuentaDtoResponse cuentaDtoResponse = cuentaService.consultarSaldo(tipoCuenta, cuentaDtoRequest);
        return ResponseEntity.ok(cuentaDtoResponse);
    }

    @PostMapping("/deposito/{numeroCuenta}")
    public ResponseEntity<Void> realizarDepositoMonto(
            @PathVariable String numeroCuenta,
            @RequestParam(value = "valor") Double monto) {
        cuentaService.realizarDeposito(numeroCuenta, monto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deposito/{numeroCuenta}/{tipoCuenta}")
    public ResponseEntity<Void> realizarDepositoBody(
            @PathVariable String numeroCuenta,
            @Valid @RequestBody CuentaDtoRequest cuentaDtoRequest) {
        cuentaService.realizarDeposito(numeroCuenta, cuentaDtoRequest.monto());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/retiro/{cuentaId}")
    public ResponseEntity<Void> realizarRetiroMonto(
            @PathVariable Long cuentaId,
            @RequestParam Double monto) {
        cuentaService.realizarRetiro(cuentaId, monto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/retiro/{numeroCuenta}/{tipoCuenta}")
    public ResponseEntity<Void> realizarRetiroDto(
            @PathVariable String numeroCuenta,
            @Valid @RequestBody CuentaDtoRequest cuentaDtoRequest) {
        cuentaService.realizarRetiro(numeroCuenta, cuentaDtoRequest.monto());
        return ResponseEntity.ok().build();
    }


}
