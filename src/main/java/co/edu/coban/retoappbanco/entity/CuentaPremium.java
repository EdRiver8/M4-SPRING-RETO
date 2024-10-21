package co.edu.coban.retoappbanco.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PREMIUM")
public class CuentaPremium extends Cuenta {
    @Override
    public boolean validarOperacion(Double monto) {
        return true; // no tiene límite de retiro
    }

    @Override
    public String toString() {
        return "CuentaPremium{" +
                "id=" + getIdCuenta() +
                ", numeroCuenta='" + getNumeroCuenta() + '\'' +
                ", saldo=" + getSaldo() +
                // Add other fields as necessary, but avoid circular references
                '}';
    }
}
