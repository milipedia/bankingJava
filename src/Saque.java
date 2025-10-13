public class Saque {

    public void sacar(Conta conta, double valor) {
        if (valor > conta.getSaldo()) {
            System.out.println("Saque indisponível, saldo insuficiente.");
        } else if (valor <= 0) { //Evita saque de valor inválido
            System.out.println("Valor de saque inválido.");
        } else {
            conta.subtrairSaldo(valor);
            conta.registrarOperacao("Saque de R$ " + String.format("%.2f", valor) + " realizado.");
            System.out.println("✅ Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso!");
        }
    }
}
