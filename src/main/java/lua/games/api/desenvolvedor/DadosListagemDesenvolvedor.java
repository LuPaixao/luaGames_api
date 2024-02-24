package lua.games.api.desenvolvedor;

public record DadosListagemDesenvolvedor(Long id, String nome, String dataFundacao, String website, String sede) {

    public DadosListagemDesenvolvedor(Desenvolvedor desenvolvedor){
        this(desenvolvedor.getId(), desenvolvedor.getNome(), desenvolvedor.getDataFundacao(), desenvolvedor.getWebsite(), desenvolvedor.getSede());
    }


}
