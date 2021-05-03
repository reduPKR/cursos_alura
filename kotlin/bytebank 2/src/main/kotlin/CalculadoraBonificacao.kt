class CalculadoraBonificacao {
    var total: Double = 0.0
        private set

    //Por gerente e diretor herdarem de funcionario ele já considera o polimorfismo
    //Desvantagem só executa metodos de funcionario
    fun registra(funcionario: Funcionario){
        this.total += funcionario.bonificacao
    }
}