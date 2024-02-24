package lua.games.api.desenvolvedor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroDesenvolvedor(
        @NotBlank
        String nome,
        @NotBlank
        String dataFundacao,
        @NotBlank
        String website,
        @NotBlank
        String sede) {
}
