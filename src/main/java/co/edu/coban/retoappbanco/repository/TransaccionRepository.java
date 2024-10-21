package co.edu.coban.retoappbanco.repository;

import co.edu.coban.retoappbanco.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    Transaccion findByCuenta_IdCuenta(Long idCuenta); // cuenta_id sirve para buscar la transaccion por cuenta id
    // obtener la ultima transaccion realizada en la db
    Transaccion findTopByOrderByIdTransaccionDesc();
}
