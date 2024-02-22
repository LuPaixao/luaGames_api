package lua.games.api.jogo;

import lua.games.api.console.DadosCadastroConsole;
import lua.games.api.desenvolvedor.DadosCadastroDesenvolvedor;

public record DadosCadastroJogo(String nome, String descricao, String dataLancamento, String website, DadosCadastroDesenvolvedor desenvolvedor, String genero, String urlcapa, DadosCadastroConsole console) {
}
