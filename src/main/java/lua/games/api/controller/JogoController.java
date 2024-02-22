package lua.games.api.controller;

import lua.games.api.jogo.DadosCadastroJogo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jogo")
public class JogoController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroJogo dados){
        System.out.println(dados);
    }

}
