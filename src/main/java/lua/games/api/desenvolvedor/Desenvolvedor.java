package lua.games.api.desenvolvedor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name = "data_fundacao")
    private String dataFundacao;
    private String website;
    private String sede;

    public Desenvolvedor(DadosCadastroDesenvolvedor dados) {
        this.nome = dados.nome();
        this.dataFundacao = dados.dataFundacao();
        this.website = dados.website();
        this.sede = dados.sede();
    }
}
