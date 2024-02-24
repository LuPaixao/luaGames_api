package lua.games.api.jogo;

import jakarta.validation.constraints.NotBlank;
import lua.games.api.console.DadosCadastroConsole;
import lua.games.api.desenvolvedor.DadosCadastroDesenvolvedor;

import java.util.List;

public record DadosCadastroJogo(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotBlank
        String dataLancamento,
        String website,
        @NotBlank
        String genero,
        String urlCapa,
        @NotBlank
        Long idDesenvolvedor,
        @NotBlank
        List<Long> idConsoles) {
}
