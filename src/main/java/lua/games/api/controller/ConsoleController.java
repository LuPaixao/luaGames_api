package lua.games.api.controller;

import jakarta.validation.Valid;
import lua.games.api.console.*;
import lua.games.api.desenvolvedor.DadosAtualizarDesenvolvedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<DadosListagemConsole> listar(@PageableDefault(size = 10) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemConsole::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarConsole dados){
        var console = repository.getReferenceById(dados.id());
        console.atualizarInformacoes(dados);
        repository.save(console);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var console = repository.getReferenceById(id);
        console.excluir();
    }


}
