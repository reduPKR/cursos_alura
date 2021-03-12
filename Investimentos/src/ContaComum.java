public class ContaComum {
    private ManipuladorSaldo manipulador;

    public ContaComum(ManipuladorSaldo manipulador) {
        this.manipulador = manipulador;
    }

    public void saca(double valor) {
        manipulador.saca(valor);
    }

    public void deposita(double valor) {
        manipulador.deposita(valor);
    }

    public void rende() {
        manipulador.rende(0.3);
    }

}
