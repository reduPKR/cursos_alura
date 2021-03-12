public class EnviadorDeEmail implements AcaoAposGerarNota {

    public void executar(NotaFiscal nf) {
        System.out.println("envia email da nf " + nf.getId());
    }
}