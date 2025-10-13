import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Transferencia {
    public void transferir(Conta contaOrigem, Conta contaDestino, double valor) {
        if (valor <= 0) {
            System.out.println("Por favor, insira um valor válido");
            return;
        }
        double valorFinal = valor;
        double taxa = 0.0;

        if(contaOrigem instanceof ContaCorrente){
            taxa = valor * 0.003;
            valorFinal += taxa;
            System.out.println("💸 Taxa de transferência (Conta Corrente): R$ " + String.format("%.2f", taxa));
        } else if (contaOrigem instanceof ContaBlack) {
            double cashback = 0.01;
            contaOrigem.adicionarSaldo(cashback);
            contaOrigem.registrarOperacao("💰 Cashback recebido: R$ " + String.format("%.2f", cashback));
            System.out.println("🎁 Cashback de R$ " + String.format("%.2f", cashback) + " aplicado (Conta Black).");
        }

        if(contaOrigem.getSaldo() < valorFinal){
            System.out.println("Valor insuficiente para esta operação. Verifique o saldo e tente novamente.");
            return;
        }
        contaOrigem.subtrairSaldo(valorFinal);
        contaDestino.adicionarSaldo(valor);

        // --- Registra as operações ---
        contaOrigem.registrarOperacao("Transferência enviada: R$ " + String.format("%.2f", valor) +
                " para conta " + contaDestino.getNumeroConta());
        contaDestino.registrarOperacao("Transferência recebida: R$ " + String.format("%.2f", valor) +
                " da conta " + contaOrigem.getNumeroConta());


        System.out.println("✅ Transferência de R$ " + String.format("%.2f", valor) +
                " realizada com sucesso!");
    }
}

