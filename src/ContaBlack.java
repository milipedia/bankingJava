public class ContaBlack extends  Conta{
    private double limiteNegativo = 1000;
    private double cashback = 0.03;

    // Construtor
    public ContaBlack(int numeroConta, Cliente clienteTitular) {
        super(numeroConta, "Conta Black", 0.0, clienteTitular);
        this.limiteNegativo = 1000;
        this.cashback = 0.03;
    }


    //Sobrescrevendo o método de saque (tem limite maior)
    @Override
    public void subtrairSaldo(double valor) {
        if (valor <= saldo + limiteNegativo) {
            saldo -= valor;
            registrarOperacao("Saque de R$ " + String.format("%.2f", valor) + " realizado (Conta Black)");
            System.out.println("✅ Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("❌ Saldo insuficiente (limite de R$ " + limiteNegativo + ")");
        }
    }

    //Sobrescrevendo o método de depósito para aplicar cashback
    @Override
    public void adicionarSaldo(double valor) {
        double bonus = valor * cashback; // calcula o bônus
        saldo += valor + bonus; // adiciona depósito + cashback
        registrarOperacao("Depósito de R$ " + String.format("%.2f", valor) +
                " com cashback de R$ " + String.format("%.2f", bonus));
        System.out.println("💰 Depósito com cashback aplicado! (+R$ " + String.format("%.2f", bonus) + ")");
    }
}