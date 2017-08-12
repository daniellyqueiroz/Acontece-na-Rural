package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repositorios.ReacaoRepositorio;

@RestController
@RequestMapping("/user/feed")
public class ReacaoController {
	
	@Autowired
	private ReacaoRepositorio reacaoRepositorio;
	
}
