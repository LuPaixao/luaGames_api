package lua.games.api.controller;

import lua.games.api.desenvolvedor.DadosCadastroDesenvolvedor;
import lua.games.api.desenvolvedor.Desenvolvedor;
import lua.games.api.desenvolvedor.DesenvolvedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("desenvolvedor")
public class DesenvolvedorController {

    @Autowired
    private DesenvolvedorRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroDesenvolvedor dados){
        repository.save(new Desenvolvedor(dados));
    }

}
