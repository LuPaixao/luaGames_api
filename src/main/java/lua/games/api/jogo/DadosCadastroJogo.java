package lua.games.api.jogo;

import jakarta.validation.constraints.NotBlank;

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
