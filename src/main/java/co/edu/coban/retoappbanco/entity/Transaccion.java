package co.edu.coban.retoappbanco.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "transacciones")
public class Transaccion {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_transaccion")
    private Long idTransaccion;

    // sino se usa esto, se almacena el ordinal del enum, es decir la posición del valor en la lista 0, 1, 2, ...
    @Enumerated(EnumType.STRING)
    private TipoTransaccion tipo;

    private Double monto;
    @Column(name = "fecha_transaccion")
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private Cuenta cuenta;
}
