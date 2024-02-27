package lua.games.api.jogo;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarJogo(
        @NotNull
        Long id,
        String nome,
        String descricao,
        String dataLancamento,
        String website,
        String genero,
        String urlCapa) {
}
