package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repositorios.UsuarioRepositorio;

@RestController
@RequestMapping("/user/feed")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

}
