package br.com.alura.model

class CalculadoraBonificacao {
    var total: Double = 0.0
        private set

    //Por gerente e diretor herdarem de funcionario ele já considera o polimorfismo
    //Desvantagem só executa metodos de funcionario
    fun registra(funcionario: Funcionario){
        this.total += funcionario.bonificacao
    }

    //Casting
    fun registraCasting(funcionario: Any){
        //Maneira 1: val novo:Funcionario = funcionario as Funcionario
        //Maneira 2: val novo = funcionario as Funcionario
        //Maneira 3: funcionario as Funcionario

        //Maneira 4 -> verifica se realmente o tipo que chegou poe fazer o cast (tipos compativeis)
        //Conhecido como smarth test
        if(funcionario is Funcionario){
            this.total += funcionario.bonificacao
        }
    }
}