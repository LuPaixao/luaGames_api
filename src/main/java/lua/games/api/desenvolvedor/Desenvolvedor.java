package lua.games.api.desenvolvedor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lua.games.api.jogo.Jogo;

@Table(name = "desenvolvedor")
@Entity(name = "Desenvolvedor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Desenvolvedor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataFundacao;
    private String website;
    private String sede;

    private boolean ativo;

    @OneToOne(mappedBy = "desenvolvedor")
    private Jogo jogo;

    public Desenvolvedor(DadosCadastroDesenvolvedor dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.dataFundacao = dados.dataFundacao();
        this.website = dados.website();
        this.sede = dados.sede();
    }

    public void atualizarInformacoes(DadosAtualizarDesenvolvedor dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.dataFundacao() != null){
            this.dataFundacao = dados.dataFundacao();
        }
        if (dados.website() != null){
            this.website = dados.website();
        }
        if (dados.sede() != null){
            this.sede = dados.sede();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
