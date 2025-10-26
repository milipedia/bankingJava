package Contas;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private int idade;
    private LocalDate dataDeNascimento;
    private List<Conta> contas = new ArrayList<>();

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    //Construtor
    public Cliente(String nome, String cpf, int idade, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.dataDeNascimento = dataDeNascimento;
    }

    //Método para visualizar os dados do cliente
    public void verDados() {
        System.out.println("\n--- Dados do Contas.Cliente ---");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
        System.out.println("Data de nascimento: " + dataDeNascimento);

        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            System.out.println("Contas do cliente:");
            for (Conta conta : contas) {
                System.out.println("- Contas.Conta nº " + conta.getNumeroConta() + " (" + conta.getTipoConta() + ")");
            }
        }
    }

    //Adicionar conta à lista
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }
}
