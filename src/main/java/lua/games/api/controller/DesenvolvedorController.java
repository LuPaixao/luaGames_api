package lua.games.api.controller;

import jakarta.validation.Valid;
import lua.games.api.desenvolvedor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


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
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemDesenvolvedor::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarDesenvolvedor dados){
        var desenvolvedor = repository.getReferenceById(dados.id());
        desenvolvedor.atualizarInformacoes(dados);
        repository.save(desenvolvedor);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var desenvolvedor = repository.getReferenceById(id);
        desenvolvedor.excluir();

    }

}
