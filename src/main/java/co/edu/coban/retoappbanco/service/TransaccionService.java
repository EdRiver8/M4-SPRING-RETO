package co.edu.coban.retoappbanco.service;

import co.edu.coban.retoappbanco.entity.Cuenta;
import co.edu.coban.retoappbanco.entity.TipoTransaccion;
import org.springframework.stereotype.Service;

@Service
public interface TransaccionService {
    void registrarTransaccion(Cuenta cuentaId, Double monto, TipoTransaccion tipo, Long idUltimaTransaccion);
    Long obtenerUltimaTransaccion();
}
