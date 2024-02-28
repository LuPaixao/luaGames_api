package lua.games.api.jogo;

import lua.games.api.console.DadosListagemConsole;
import lua.games.api.desenvolvedor.DadosListagemDesenvolvedor;

import java.util.List;

public record DadosListagemJogo(Long id, String nome, String descricao, String dataLancamento, String website, DadosListagemDesenvolvedor desenvolvedor, String genero, String urlCapa, List<DadosListagemConsole> console) {

    public DadosListagemJogo(Jogo jogo){
        this(jogo.getId(), jogo.getNome(), jogo.getDescricao(), jogo.getDataLancamento(), jogo.getWebsite(), new DadosListagemDesenvolvedor(jogo.getDesenvolvedor()) , jogo.getGenero(), jogo.getUrlCapa(), jogo.getConsole().stream().map(DadosListagemConsole::new).toList());
    }


}
