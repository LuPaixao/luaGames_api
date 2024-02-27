package lua.games.api.desenvolvedor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarDesenvolvedor(
        @NotNull
        Long id,
        String nome,
        String dataFundacao,
        String website,
        String sede) {
}
