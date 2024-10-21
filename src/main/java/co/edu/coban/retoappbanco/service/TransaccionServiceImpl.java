package co.edu.coban.retoappbanco.service;

import co.edu.coban.retoappbanco.entity.Cuenta;
import co.edu.coban.retoappbanco.entity.TipoTransaccion;
import co.edu.coban.retoappbanco.entity.Transaccion;
import co.edu.coban.retoappbanco.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransaccionServiceImpl implements TransaccionService {
    private final TransaccionRepository transaccionRepository;

    public TransaccionServiceImpl(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    public void registrarTransaccion(Cuenta cuenta, Double monto, TipoTransaccion tipo, Long idUltimaTransaccion) {
        Transaccion transaccion = new Transaccion();
        transaccion.setIdTransaccion(idUltimaTransaccion + 1);
        transaccion.setCuenta(cuenta);
        transaccion.setMonto(monto);
        transaccion.setTipo(tipo);
        transaccion.setFecha(LocalDateTime.now());

        transaccionRepository.save(transaccion);
    }

    public Long obtenerUltimaTransaccion() {
        return transaccionRepository.findTopByOrderByIdTransaccionDesc().getIdTransaccion();
    }
}
