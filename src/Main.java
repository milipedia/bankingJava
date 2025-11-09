import Cambio.ApiMoedasService;
import Cambio.RespostaAPI;
import Contas.Cliente;
import Contas.Conta;
import Contas.ContaBlack;
import Contas.ContaCorrente;
import Credito.cartaoCredito;
import Operacoes.Transferencia;

import java.io.IOException;
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

        Cliente clienteLogado = null;

        //Loop de login
        while (clienteLogado == null) {
            System.out.println("\n==== LOGIN ====");
            System.out.println("1 - Fazer login");
            System.out.println("2 - Criar nova conta");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int escolha = sc.nextInt();
            sc.nextLine(); // limpar buffer

            if (escolha == 1) {
                System.out.print("CPF: ");
                String cpfLogin = sc.nextLine();
                System.out.print("Senha: ");
                String senhaLogin = sc.nextLine();

                clienteLogado = autenticarCliente(contas, cpfLogin, senhaLogin);

                if (clienteLogado == null) {
                    System.out.println("❌ CPF ou senha incorretos!");
                } else {
                    System.out.println("✅ Login realizado com sucesso! Bem-vindo, " + clienteLogado.getNome() + "!");
                }

            } else if (escolha == 2) {
                //Criação de conta (mesmo que teu case 1)
                System.out.print("Nome do cliente: ");
                String nome = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Idade: ");
                int idade = sc.nextInt();
                sc.nextLine();
                System.out.print("Data de nascimento (AAAA-MM-DD): ");
                LocalDate data = LocalDate.parse(sc.nextLine());
                System.out.print("Crie uma senha: ");
                String senha = sc.nextLine();

                Cliente cliente = new Cliente(nome, cpf, idade, data, senha);

                System.out.println("Tipo de conta:");
                System.out.println("1 - Conta Corrente");
                System.out.println("2 - Conta Black");
                System.out.print("Escolha: ");
                int tipo = sc.nextInt();

                int numeroConta = contas.size() + 1;
                Conta conta;
                if (tipo == 1) {
                    conta = new ContaCorrente(numeroConta, cliente);
                } else {
                    conta = new ContaBlack(numeroConta, cliente);
                }

                cliente.adicionarConta(conta);
                contas.add(conta);
                System.out.println("✅ Conta criada com sucesso! Número: " + numeroConta);

            } else if (escolha == 0) {
                System.out.println("Encerrando o sistema...");
                sc.close();
                return;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        //Looping para o menu bancário
        while (true) {
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1 - Ver dados");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Ver extrato");
            System.out.println("6 - Consultar saldo");
            System.out.println("7 - Solicitar cartão de crédito");
            System.out.println("8 - Consultar taxas de câmbio");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.println("=== Dados da Conta ===");
                    System.out.println("Nome: " + clienteLogado.getNome());
                    System.out.println("CPF: " + clienteLogado.getCpf());

                    // Exibe todas as contas do cliente
                    for (Conta conta : clienteLogado.getContas()) {
                        System.out.println("Número da conta: " + conta.getNumeroConta());
                        System.out.println("Tipo: " + conta.getClass().getSimpleName());
                        System.out.println("Saldo: R$ " + conta.getSaldo());
                        System.out.println("-------------------------");
                    }
                    System.out.println();
                }

                case 2 -> {
                    Conta conta = clienteLogado.getContas().get(0);
                    if (conta != null) {
                        System.out.print("Valor do depósito: R$ ");
                        double valor = sc.nextDouble();
                        conta.adicionarSaldo(valor);
                        System.out.println("💰 Depósito realizado!");
                    } else {
                        System.out.println("❌ Contas.Conta não encontrada!");
                    }
                }

                case 3 -> {
                    Conta conta = clienteLogado.getContas().get(0);

                    if (conta != null) {
                        System.out.print("Valor do saque: R$ ");
                        double valor = sc.nextDouble();
                        conta.subtrairSaldo(valor);
                    } else {
                        System.out.println("❌ Contas.Conta não encontrada!");
                    }
                }

                case 4 -> {
                    System.out.print("Contas.Conta origem: ");
                    int origemNum = sc.nextInt();
                    System.out.print("Contas.Conta destino: ");
                    int destinoNum = sc.nextInt();
                    System.out.print("Valor: R$ ");
                    double valor = sc.nextDouble();

                    Conta origem = buscarConta(contas, origemNum);
                    Conta destino = buscarConta(contas, destinoNum);

                    if (origem != null && destino != null) {
                        transferencia.transferir(origem, destino, valor);
                    } else {
                        System.out.println("❌ Contas.Conta inválida!");
                    }
                }

                case 5 -> {
                    Conta conta = clienteLogado.getContas().get(0);
                    if (conta != null) {
                        conta.verExtrato();
                    } else {
                        System.out.println("❌ Contas.Conta não encontrada!");
                    }
                }

                case 6 -> {
                    Conta conta = clienteLogado.getContas().get(0);
                    if (conta != null) {
                        conta.consultarSaldo();
                    } else {
                        System.out.println("❌ Contas.Conta não encontrada!");
                    }
                }

                case 7 -> {
                    Conta conta = clienteLogado.getContas().get(0);

                    if (conta instanceof ContaBlack) {
                        System.out.println("Limite de crédito disponível para essa conta.");
                        System.out.print("Qual seu limite ideal? ");
                        double limite = sc.nextDouble();
                        cartaoCredito cartao = new cartaoCredito(limite);
                        System.out.println("💳 Cartão criado com limite de R$ " + limite);
                    } else {
                        System.out.println("❌ Limite de crédito não disponível para esta modalidade.");
                    }
                }
                case 8 -> {
                    Conta conta = clienteLogado.getContas().get(0);

                    if (conta == null) {
                        System.out.println("❌ Conta não encontrada!");
                        break;
                    }

                    String apiKey = "f3bd8550ff81186ce371b654";
                    ApiMoedasService apiService = new ApiMoedasService(apiKey);

                    System.out.println("Saldo atual: R$ " + conta.getSaldo());
                    double valor = conta.getSaldo();

                    System.out.println("Deseja consultar a taxa de câmbio para qual moeda?");
                    System.out.println("1) Real (BRL) → Dólar (USD)");
                    System.out.println("2) Real (BRL) → Euro (EUR)");
                    System.out.println("3) Real (BRL) → Libra (GBP)");
                    System.out.print("Escolha: ");
                    int moedaOpcao = sc.nextInt();

                    try {
                        realizarConversao(moedaOpcao, valor, apiService);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Erro ao buscar esta conversão: " + e.getMessage());
                    }
                }


                case 0 -> {
                    System.out.println("Encerrando o sistema. Até logo!");
                    sc.close();
                    return;
                }

                default -> System.out.println("Opção inválida!");
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
    private static Cliente autenticarCliente(List<Conta> contas, String cpf, String senha) {
        for (Conta conta : contas) {
            Cliente cliente = conta.getClienteTitular();
            if (cliente.getCpf().equals(cpf) && cliente.autenticar(senha)) {
                return cliente;
            }
        }
        return null;
    }

    private static void realizarConversao(int moedaOpcao, double valor, ApiMoedasService apiService)
            throws IOException, InterruptedException {
        String moedaOrigem = "BRL";
        String moedaDestino = "";

        // Define as moedas de origem e destino com base na opção
        switch (moedaOpcao) {
            case 1:
                moedaDestino = "USD";
                break;
            case 2:
                moedaDestino = "EUR";
                break;
            case 3:
                moedaDestino = "GBP";
                break;
            default:
                System.out.println("Opção inválida");
                return;
        }

        // Consulta as taxas da moeda de origem
        RespostaAPI resposta = apiService.buscarTaxas(moedaOrigem);

        // Verifica se a resposta da API foi bem-sucedida
        if ("success".equals(resposta.getResult())) {
            Double taxa = resposta.getTaxaDeMoeda(moedaDestino);
            if (taxa != null) {
                double valorConvertido = valor * taxa;
                System.out.printf("%.2f %s = %.2f %s%n",
                        valor, moedaOrigem, valorConvertido, moedaDestino);
            } else {
                System.out.println("Moeda destino não encontrada!");
            }
        } else {
            System.out.println("Erro na resposta da API!");
        }
    }
}
