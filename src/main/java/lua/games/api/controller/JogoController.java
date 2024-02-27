package lua.games.api.controller;

import jakarta.validation.Valid;
import lua.games.api.console.DadosAtualizarConsole;
import lua.games.api.jogo.DadosAtualizarJogo;
import lua.games.api.jogo.DadosCadastroJogo;
import lua.games.api.jogo.DadosListagemJogo;
import lua.games.api.jogo.JogoRepository;
import lua.games.api.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<DadosListagemJogo> listar(@PageableDefault(size = 10) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemJogo::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarJogo dados){
        var jogo = repository.getReferenceById(dados.id());
        jogo.atualizarInformacoes(dados);
        repository.save(jogo);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var jogo = repository.getReferenceById(id);
        jogo.excluir();
    }

}
