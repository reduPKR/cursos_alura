fun testaSaldo(saldo: Double) {
    when {
        saldo > 0.0 -> println("Saldo positivo")
        saldo == 0.0 -> println("model.Conta neutra")
        else -> println("Saldo negativo")
    }
}