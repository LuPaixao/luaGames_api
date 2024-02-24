package lua.games.api.console;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroConsole(
        @NotBlank
        String nome,
        @NotBlank
        String dataLancamento,
        @NotBlank
        String empresa) {
}
