package co.edu.coban.retoappbanco.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    private String usuario;
    private String nombre;
    private String email;
    @Column(name = "clave")
    private String password;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Cuenta> cuentas;
}
