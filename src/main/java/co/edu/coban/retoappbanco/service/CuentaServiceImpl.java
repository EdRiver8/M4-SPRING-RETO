package co.edu.coban.retoappbanco.service;

import co.edu.coban.retoappbanco.dto.CuentaDtoRequest;
import co.edu.coban.retoappbanco.dto.CuentaDtoResponse;
import co.edu.coban.retoappbanco.entity.Cuenta;
import co.edu.coban.retoappbanco.entity.CuentaBasica;
import co.edu.coban.retoappbanco.entity.TipoTransaccion;
import co.edu.coban.retoappbanco.entity.Transaccion;
import co.edu.coban.retoappbanco.repository.CuentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {
    private final CuentaRepository cuentaRepository;
    private final TransaccionServiceImpl transaccionService;

    public CuentaServiceImpl(CuentaRepository cuentaRepository, TransaccionServiceImpl transaccionService) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionService = transaccionService;
    }

    @Override
    public List<CuentaDtoResponse> obtenerTodasCuentas() {
//        List<Cuenta> cuentas = cuentaRepository.findAll();
//        cuentas.stream().forEach(cuenta -> {
//            String tipoCuenta;
//            if (cuenta instanceof CuentaBasica) {
//                tipoCuenta = "BASICA";
//            } else {
//                tipoCuenta = "PREMIUM";
//            }
//            CuentaDtoResponse cuentaDtoResponse = new CuentaDtoResponse(
//                    cuenta.getNumeroCuenta(),
//                    cuenta.getSaldo(),
//                    tipoCuenta,
//                    cuenta.getUsuario().getUsuario(),
//                    cuenta.getUsuario().getEmail()
//            );
//            System.out.println(cuentaDtoResponse);
//        });
//        List<CuentaDtoResponse> cuentasDto = new ArrayList<>();
//        return cuentasDto;

        return cuentaRepository.findAll().stream().map(cuenta -> {
            String tipoCuenta;
            if (cuenta instanceof CuentaBasica) {
                tipoCuenta = "BASICA";
            } else {
                tipoCuenta = "PREMIUM";
            }
            return new CuentaDtoResponse(
                    cuenta.getNumeroCuenta(),
                    cuenta.getSaldo(),
                    tipoCuenta,
                    cuenta.getUsuario().getUsuario(),
                    cuenta.getUsuario().getEmail()
            );
        }).toList();
    }

    @Transactional
    public void realizarDeposito(String numeroCuenta, Double monto) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        if (cuenta.validarOperacion(monto)) {
            cuenta.setSaldo(cuenta.getSaldo() + monto);
            cuentaRepository.save(cuenta);
            transaccionService.registrarTransaccion(cuenta, monto, TipoTransaccion.DEPOSITO, transaccionService.obtenerUltimaTransaccion());
        } else {
            throw new RuntimeException("Operación no válida");
        }
    }

    @Transactional
    public void realizarRetiro(Long cuentaId, Double monto) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        if (cuenta.validarOperacion(monto) && cuenta.getSaldo() >= monto) {
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            cuentaRepository.save(cuenta);
            transaccionService.registrarTransaccion(cuenta, monto, TipoTransaccion.RETIRO, transaccionService.obtenerUltimaTransaccion());
        } else {
            throw new RuntimeException("Operación no válida o saldo insuficiente");
        }
    }

    @Transactional
    public void realizarRetiro(String numeroCuenta, Double monto) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        if (cuenta.validarOperacion(monto) && cuenta.getSaldo() >= monto) {
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            cuentaRepository.save(cuenta);
            transaccionService.registrarTransaccion(cuenta, monto, TipoTransaccion.RETIRO, transaccionService.obtenerUltimaTransaccion());
        } else {
            throw new RuntimeException("Operación no válida o saldo insuficiente");
        }
    }

    @Override
    public Double consultarSaldo(Long cuentaId) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        return cuenta.getSaldo();
    }

    @Override
    public CuentaDtoResponse consultarSaldo(String tipoCuenta, CuentaDtoRequest cuentaDtoRequest) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(cuentaDtoRequest.numeroCuenta())
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        String tipoCuentaEncontrada;
        // verificar si es una cuenta basica o premium
        if (cuenta instanceof CuentaBasica) {
            tipoCuentaEncontrada = "BASICA";
        } else {
            tipoCuentaEncontrada = "PREMIUM";
        }
        if (!tipoCuentaEncontrada.equals(tipoCuenta)) {
            throw new RuntimeException("Tipo de cuenta no coincide");
        }
        CuentaDtoResponse cuentaDtoResponse = new CuentaDtoResponse(
                cuenta.getNumeroCuenta(),
                cuenta.getSaldo(),
                tipoCuentaEncontrada,
                cuenta.getUsuario().getUsuario(),
                cuenta.getUsuario().getEmail()
        );
        return cuentaDtoResponse;
    }
}
