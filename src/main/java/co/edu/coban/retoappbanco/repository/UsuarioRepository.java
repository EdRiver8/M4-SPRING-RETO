package co.edu.coban.retoappbanco.repository;

import co.edu.coban.retoappbanco.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombre(String nombre);
}
