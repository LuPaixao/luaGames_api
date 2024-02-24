package lua.games.api.service;

import lua.games.api.console.Console;
import lua.games.api.console.ConsoleRepository;
import lua.games.api.desenvolvedor.Desenvolvedor;
import lua.games.api.desenvolvedor.DesenvolvedorRepository;
import lua.games.api.jogo.DadosCadastroJogo;
import lua.games.api.jogo.Jogo;
import lua.games.api.jogo.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private DesenvolvedorRepository desenvolvedorRepository;

    @Autowired
    private ConsoleRepository consoleRepository;

    @Transactional
    public void salvarJogo( DadosCadastroJogo dados ){

        Optional<Desenvolvedor> desenvolvedorOptional = desenvolvedorRepository.findById(dados.idDesenvolvedor());
        if (desenvolvedorOptional.isEmpty()){
            throw new RuntimeException("Não existe desenvolvedor com este id");
        }

        List<Console> consoles = consoleRepository.findAllById(dados.idConsoles());
        if (consoles.isEmpty()){
            throw new RuntimeException("Não existe os consoles informados");
        }

        Desenvolvedor desenvolvedor = desenvolvedorOptional.get();
        Jogo jogo = new Jogo(dados);
        jogo.setDesenvolvedor(desenvolvedor);
        jogo.setConsole(consoles);

        jogoRepository.save(jogo);

    }

}
