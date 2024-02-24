package lua.games.api.controller;

import lua.games.api.jogo.DadosCadastroJogo;
import lua.games.api.jogo.DadosListagemJogo;
import lua.games.api.jogo.JogoRepository;
import lua.games.api.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jogo")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @Autowired
    private JogoRepository repository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroJogo dados){
        System.out.println(dados);
        jogoService.salvarJogo(dados);
    }

    @GetMapping
    public List<DadosListagemJogo> listar(){
        return repository.findAll().stream().map(DadosListagemJogo::new).toList();
    }

}
