public class ContaDeEstudante{
    private ManipuladorSaldo manipulador;
    private int milhas;

    public void deposita(double valor) {
        this.manipulador.deposita(valor);
        this.milhas += (int) valor;
    }

    public int getMilhas() {
        return milhas;
    }
}
