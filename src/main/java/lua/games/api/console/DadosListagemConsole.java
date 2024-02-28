package lua.games.api.console;

import java.util.List;

public record DadosListagemConsole(Long id, String nome, String dataLancamento, String empresa) {

    public DadosListagemConsole(Console console){
        this(console.getId(), console.getNome(), console.getDataLancamento(), console.getEmpresa());
    }

}
