package lua.games.api.console;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lua.games.api.jogo.Jogo;

@Table(name = "console")
@Entity(name = "Console")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Console {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataLancamento;
    private String empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jogo")
    private Jogo jogo;

    public Console(DadosCadastroConsole dados) {
        this.nome = dados.nome();
        this.dataLancamento = dados.dataLancamento();
        this.empresa = dados.empresa();
    }
}
