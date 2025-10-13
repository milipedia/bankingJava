public class Deposito {
    public void depositar(Conta conta, double valor) {
        if (valor <= 0) { //Evita saque de valor inválido
            System.out.println("Valor de depósito inválido.");
        } else {
            conta.adicionarSaldo(valor);
            conta.registrarOperacao("Depósito de R$ " + String.format("%.2f", valor) + " realizado.");
            System.out.println("✅ Depósito de R$ " + String.format("%.2f", valor) + " realizado com sucesso!");
        }
    }
}

