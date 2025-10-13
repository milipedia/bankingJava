
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Conta {
    protected int numeroConta;
    protected String tipoConta;
    protected double saldo;
    protected Cliente clienteTitular;
    protected List<String> extrato = new ArrayList<>();


    //Construtor
    public Conta(int numeroConta, String tipoConta, double saldo, Cliente clienteTitular) {
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo; // mantém o valor informado
        this.clienteTitular = clienteTitular;
    }
    public Conta() {
    }

    //Getters e Setters
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getClienteTitular() {
        return clienteTitular;
    }

    public void setClienteTitular(Cliente clienteTitular) {
        this.clienteTitular = clienteTitular;
    }

    //Métodos de operação
    public void adicionarSaldo(double valor) {
        this.saldo += valor;
        registrarOperacao("Depósito de R$ " + String.format("%.2f", valor));
    }

    public void subtrairSaldo(double valor) {
        this.saldo -= valor;
        registrarOperacao("Saque de R$ " + String.format("%.2f", valor));
    }

    public void registrarOperacao(String descricao) {
        extrato.add(LocalDate.now() + " | " + descricao);
    }

    public void verExtrato() {
        System.out.println("\n--- Extrato da Conta " + numeroConta + " ---");
        if (extrato.isEmpty()) {
            System.out.println("Nenhuma operação registrada.");
        } else {
            for (String operacao : extrato) {
                System.out.println("  -> " + operacao);
            }
        }
        System.out.println("---------------------------------");
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual da conta " + numeroConta + ": R$ " + String.format("%.2f", saldo));
    }
}
