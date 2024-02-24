package lua.games.api.jogo;

public record DadosListagemJogo(Long id, String nome, String descricao, String dataLancamento, String website, String genero, String urlCapa) {

    public DadosListagemJogo(Jogo jogo){
        this(jogo.getId(), jogo.getNome(), jogo.getDescricao(), jogo.getDataLancamento(), jogo.getWebsite(), jogo.getGenero(), jogo.getUrlCapa());
    }


}
