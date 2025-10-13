import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lista que armazena todas as contas criadas no sistema
        List<Conta> contas = new ArrayList<>();

        // Objeto responsável pelas operações de transferência
        Transferencia transferencia = new Transferencia();

        System.out.println("Olá, seja vem vindo!!");

        //Looping para o menu bancário
        while (true) {
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1 - Criar nova conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Ver extrato");
            System.out.println("6 - Consultar saldo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    sc.nextLine(); // limpar buffer do scanner
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Data de nascimento (AAAA-MM-DD): ");
                    LocalDate data = LocalDate.parse(sc.nextLine());
                    Cliente cliente = new Cliente(nome, cpf, idade, data); // Criação do objeto Cliente

                    System.out.println("Tipo de conta:");
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Black");
                    System.out.print("Escolha: ");
                    int tipo = sc.nextInt();

                    int numeroConta = contas.size() + 1;
                    Conta conta;

                    // Criação da conta de acordo com o tipo escolhido
                    if (tipo == 1) {
                        conta = new ContaCorrente(numeroConta, cliente);
                    } else {
                        conta = new ContaBlack(numeroConta, cliente);
                    }

                    cliente.adicionarConta(conta); //Vincula conta aos cliente
                    contas.add(conta); //Adiciona a conta à lista geral

                    System.out.println("✅ Conta criada com sucesso! Número: " + numeroConta);
                }

                case 2 -> {
                    System.out.print("Número da conta: ");
                    int numero = sc.nextInt();
                    Conta conta = buscarConta(contas, numero);

                    if (conta != null) {
                        System.out.print("Valor do depósito: R$ ");
                        double valor = sc.nextDouble();
                        conta.adicionarSaldo(valor);
                        System.out.println("💰 Depósito realizado!");
                    } else {
                        System.out.println("❌ Conta não encontrada!");
                    }
                }

                case 3 -> {
                    System.out.print("Número da conta: ");
                    int numero = sc.nextInt();
                    Conta conta = buscarConta(contas, numero);

                    if (conta != null) {
                        System.out.print("Valor do saque: R$ ");
                        double valor = sc.nextDouble();
                        conta.subtrairSaldo(valor);
                    } else {
                        System.out.println("❌ Conta não encontrada!");
                    }
                }

                case 4 -> {
                    System.out.print("Conta origem: ");
                    int origemNum = sc.nextInt();
                    System.out.print("Conta destino: ");
                    int destinoNum = sc.nextInt();
                    System.out.print("Valor: R$ ");
                    double valor = sc.nextDouble();

                    Conta origem = buscarConta(contas, origemNum);
                    Conta destino = buscarConta(contas, destinoNum);

                    if (origem != null && destino != null) {
                        transferencia.transferir(origem, destino, valor);
                    } else {
                        System.out.println("❌ Conta inválida!");
                    }
                }

                case 5 -> {
                    System.out.print("Número da conta: ");
                    int numero = sc.nextInt();
                    Conta conta = buscarConta(contas, numero);
                    if (conta != null) {
                        conta.verExtrato();
                    } else {
                        System.out.println("❌ Conta não encontrada!");
                    }
                }

                case 6 -> {
                    System.out.print("Número da conta: ");
                    int numero = sc.nextInt();
                    Conta conta = buscarConta(contas, numero);
                    if (conta != null) {
                        conta.consultarSaldo();
                    } else {
                        System.out.println("❌ Conta não encontrada!");
                    }
                }

                case 0 -> {
                    System.out.println("👋 Encerrando o sistema. Até logo!");
                    sc.close();
                    return;
                }

                default -> System.out.println("❌ Opção inválida!");
            }
        }
    }

    private static Conta buscarConta(List<Conta> contas, int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}
