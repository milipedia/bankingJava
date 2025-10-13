public class ContaPoupanca extends Conta{
    private double taxaRendimento = 0.006; // 0,6% ao mês
    private double taxaSaque = 0.1; // taxa fixa opcional por saque

    //Construtor
    public ContaPoupanca(int numeroConta, Cliente clienteTitular) {
        super(numeroConta, "Conta Poupança", 0.0, clienteTitular);
    }

    //Sobrescrevendo o método de saque
    @Override
    public void subtrairSaldo(double valor) {
        double valorComTaxa = valor + taxaSaque;
        if (saldo >= valorComTaxa) {
            saldo -= valorComTaxa;
            registrarOperacao("Saque de R$ " + String.format("%.2f", valor) +
                    " + taxa de R$ " + String.format("%.2f", taxaSaque));
            System.out.println("💸 Saque realizado: R$ " + valor + " (taxa R$ " + taxaSaque + ")");
        } else {
            System.out.println("❌ Saldo insuficiente para saque e taxa.");
        }
    }

    //Método para aplicar o rendimento mensal
    public void aplicarRendimento() {
        double rendimento = saldo * taxaRendimento;
        saldo += rendimento;
        registrarOperacao("Rendimento mensal aplicado: +" + String.format("%.2f", rendimento));
        System.out.println("📈 Rendimento de R$ " + String.format("%.2f", rendimento) + " aplicado com sucesso!");
    }
}
