package lua.games.api.console;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarConsole(
        @NotNull
        Long id,
        String nome,
        String dataLancamento,
        String empresa) {
}
