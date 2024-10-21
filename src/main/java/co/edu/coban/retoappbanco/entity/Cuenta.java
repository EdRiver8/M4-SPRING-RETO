package co.edu.coban.retoappbanco.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cuentas")
// define como se almacenarán las subclases en la db, usando solo 1 tabla y diferenciando los registros con 1 columna discriminatoria
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_cuenta", discriminatorType = DiscriminatorType.STRING)
public abstract class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Long idCuenta;
    private String numeroCuenta;
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Transaccion> transacciones;

    public abstract boolean validarOperacion(Double monto);
}
