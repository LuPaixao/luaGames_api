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

    private boolean ativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jogo")
    private Jogo jogo;

    public Console(DadosCadastroConsole dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.dataLancamento = dados.dataLancamento();
        this.empresa = dados.empresa();
    }

    public void atualizarInformacoes(DadosAtualizarConsole dados) {

        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.dataLancamento() != null){
            this.dataLancamento = dados.dataLancamento();
        }
        if (dados.empresa() != null){
            this.empresa = dados.empresa();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
