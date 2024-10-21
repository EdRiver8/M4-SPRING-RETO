package co.edu.coban.retoappbanco.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BASICA")
public class CuentaBasica extends Cuenta {
    private Double limiteRetiroDiario;

    @Override
    public boolean validarOperacion(Double monto) {
        return monto <= limiteRetiroDiario;
    }

    @Override
    public String toString() {
        return "CuentaBasica{" +
                "id=" + getIdCuenta() +
                ", numeroCuenta='" + getNumeroCuenta() + '\'' +
                ", saldo=" + getSaldo() +
                // Add other fields as necessary, but avoid circular references
                '}';
    }
}
