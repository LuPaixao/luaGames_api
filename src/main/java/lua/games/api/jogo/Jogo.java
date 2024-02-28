package lua.games.api.jogo;

import jakarta.persistence.*;
import lombok.*;
import lua.games.api.console.Console;
import lua.games.api.desenvolvedor.Desenvolvedor;

import java.util.List;

@Table(name = "jogo")
@Entity(name = "Jogo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Setter

public class Jogo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String dataLancamento;
    private String website;
    private String genero;
    private String urlCapa;

    private boolean ativo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_desenvolvedor", referencedColumnName = "id")
    private Desenvolvedor desenvolvedor;

    @OneToMany(mappedBy = "jogo")
    private List<Console> console;

    public Jogo(DadosCadastroJogo dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.dataLancamento = dados.dataLancamento();
        this.website = dados.website();
        this.genero = dados.genero();
        this.urlCapa = dados.urlCapa();
    }

    public void atualizarInformacoes(DadosAtualizarJogo dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (dados.dataLancamento() != null){
            this.dataLancamento = dados.dataLancamento();
        }
        if (dados.website() != null){
            this.website = dados.website();
        }
        if (dados.genero() != null){
            this.genero = dados.genero();
        }
        if (dados.urlCapa() != null){
            this.urlCapa = dados.urlCapa();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
