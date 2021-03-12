public class CalculadoraDePrecos {

    private final ServicoEntrega entrega;
    private final TabelaPreco tabela;

    public CalculadoraDePrecos(TabelaPreco tabela, ServicoEntrega entrega) {
        this.entrega = entrega;
        this.tabela = tabela;
    }

    public double calcula(Compra produto) {
        double desconto = tabela.descontoPara(produto.getValor());
        double frete = entrega.para(produto.getCidade());

        return produto.getValor() * (1-desconto) + frete;
    }
}