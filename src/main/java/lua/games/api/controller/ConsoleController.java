package lua.games.api.controller;

import lua.games.api.console.Console;
import lua.games.api.console.ConsoleRepository;
import lua.games.api.console.DadosCadastroConsole;
import lua.games.api.console.DadosListagemConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("console")
public class ConsoleController {

    @Autowired
    private ConsoleRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroConsole dados){
        repository.save(new Console(dados));
    }

    @GetMapping
    public List<DadosListagemConsole> listar(){
        return repository.findAll().stream().map(DadosListagemConsole::new).toList();
    }

}
