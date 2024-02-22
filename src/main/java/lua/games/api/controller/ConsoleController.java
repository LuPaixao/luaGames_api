package lua.games.api.controller;

import lua.games.api.console.Console;
import lua.games.api.console.ConsoleRepository;
import lua.games.api.console.DadosCadastroConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("console")
public class ConsoleController {

    @Autowired
    private ConsoleRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroConsole dados){
        repository.save(new Console(dados));
    }

}
