package Contas;

public class ContaCorrente  extends Conta {
        private double limiteNegativo = 500;
        private double taxaTransferencia = 0.03;
    // Construtor
    public ContaCorrente(int numeroConta, Cliente clienteTitular) {
        super(numeroConta, "Contas.Conta Corrente", 0.0, clienteTitular);
    }

    // Sobrescrevendo o método de saque
    @Override
    public void subtrairSaldo(double valor) {
        if (valor <= saldo + limiteNegativo) {
            saldo -= valor;
            registrarOperacao("Operacoes.Saque de R$ " + String.format("%.2f", valor) + " realizado (Contas.Conta Corrente)");
            System.out.println("✅ Operacoes.Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("❌ Saldo insuficiente (limite de R$ " + limiteNegativo + ")");
        }
    }

    // Método de transferência com taxa
    public void transferir(Conta destino, double valor) {
        double valorComTaxa = valor + taxaTransferencia;

        if (valorComTaxa <= saldo + limiteNegativo) {
            saldo -= valorComTaxa;
            destino.adicionarSaldo(valor);
            registrarOperacao("Transferência de R$ " + String.format("%.2f", valor) +
                    " para conta " + destino.getNumeroConta() +
                    " (Taxa de R$ " + taxaTransferencia + ")");
            System.out.println("💸 Transferência realizada com sucesso!");
        } else {
            System.out.println("❌ Saldo insuficiente para transferência (incluindo taxa).");
        }
    }
}
