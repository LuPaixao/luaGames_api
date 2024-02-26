package lua.games.api.controller;

import lua.games.api.desenvolvedor.DadosCadastroDesenvolvedor;
import lua.games.api.desenvolvedor.DadosListagemDesenvolvedor;
import lua.games.api.desenvolvedor.Desenvolvedor;
import lua.games.api.desenvolvedor.DesenvolvedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("desenvolvedor")
public class DesenvolvedorController {

    @Autowired
    private DesenvolvedorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroDesenvolvedor dados){
        repository.save(new Desenvolvedor(dados));
    }

    @GetMapping
    public Page<DadosListagemDesenvolvedor> listar(@PageableDefault(size = 10) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemDesenvolvedor::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosCadastroDesenvolvedor dados){

    }

}
