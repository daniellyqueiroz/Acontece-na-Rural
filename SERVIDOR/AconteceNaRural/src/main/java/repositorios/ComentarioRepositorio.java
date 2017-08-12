package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import modelos.Comentario;

public interface ComentarioRepositorio extends JpaRepository<Comentario, Long>{

}
