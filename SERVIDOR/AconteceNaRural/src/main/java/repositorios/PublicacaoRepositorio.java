package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import modelos.Publicacao;

public interface PublicacaoRepositorio extends JpaRepository<Publicacao, Long>{

}
