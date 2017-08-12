package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import modelos.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

}
