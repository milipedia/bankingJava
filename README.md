# 🏦 Banco Milipedia

![Java](https://img.shields.io/badge/Java-17+-orange)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)
![License](https://img.shields.io/badge/Licença-MIT-green)
![Plataforma](https://img.shields.io/badge/Plataforma-Terminal-blue)

Um sistema bancário completo desenvolvido em **Java**, com foco em **Programação Orientada a Objetos (POO)**.  
Permite criar contas, realizar saques, depósitos, transferências e consultar extratos — tudo diretamente pelo terminal.  

---

## 🌟 Demonstração

🏦 Bem-vindo ao Banco Milipedia!

==== MENU PRINCIPAL ====
1 - Criar nova conta
2 - Depositar
3 - Sacar
4 - Transferir
5 - Ver extrato
6 - Consultar saldo
7- Solicitar cartão de crédito
0 - Sair
Escolha uma opção: 1
Nome do cliente: Bianca
CPF: 123.456.789-00
Idade: 20
Data de nascimento (AAAA-MM-DD): 2005-06-12
Tipo de conta:
1 - Conta Corrente
2 - Conta Black
Escolha: 2
✅ Conta criada com sucesso! Número: 1

---

## 🧩 Estrutura do Projeto

📂 src/
┣ 📜 Main.java → Menu principal e lógica do programa
┣ 📜 Cliente.java → Representa o cliente do banco
┣ 📜 Conta.java → Classe pai (abstrata)
┣ 📜 ContaCorrente.java → Conta comum com limite básico
┣ 📜 ContaBlack.java → Conta premium com cashback e limite maior
┣ 📜 Transferencia.java → Responsável pelas operações de transferência

---

## ⚙️ Funcionalidades

| Função | Descrição |
|--------|------------|
| 🧍 Criar nova conta | Cadastra cliente e define o tipo de conta |
| 💰 Depositar | Adiciona saldo (com cashback se for conta Black) |
| 💸 Sacar | Retira saldo respeitando limite negativo |
| 🔄 Transferir | Transfere entre contas criadas |
| 📄 Ver extrato | Mostra todas as operações registradas |
| 🧮 Consultar saldo | Exibe o saldo atual da conta |
| 🚪 Sair | Encerra o sistema com segurança |

---

## 💳 Tipos de Conta

| Tipo | Limite Negativo | Taxas | Benefícios |
|------|------------------|--------|-------------|
| **Conta Corrente** | R$ 500 | Taxa de transferência 0.3 | Simples e prática |
| **Conta Black** | R$ 1000 | Nenhuma | Cashback de 3% em depósitos 💸 |

---

## 🧠 Conceitos de POO Aplicados

| Conceito | Aplicação |
|-----------|------------|
| **Classe e Objeto** | Cliente, Conta, ContaCorrente, ContaBlack, Transferencia |
| **Herança** | `ContaCorrente` e `ContaBlack` herdam de `Conta` |
| **Polimorfismo** | Sobrescrita de métodos (`subtrairSaldo`, `adicionarSaldo`) |
| **Encapsulamento** | Uso de atributos privados e getters/setters |
| **Composição** | Cliente possui uma lista de contas |
| **Coleções** | Manipulação de `List<Conta>` para armazenar todas as contas |

---

## 🚀 Como Executar

### 🔧 Pré-requisitos
- Java JDK 17 ou superior
- IntelliJ IDEA, Eclipse, VS Code ou terminal configurado com `javac`

### ▶️ Execução

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/banco-milipedia.git

# Acesse o diretório do projeto
cd banco-milipedia/src

# Compile os arquivos Java
javac *.java

# Execute o programa
java Main
🧾 Exemplo de Operações
✅ Depósito de R$ 500,00 realizado!
💰 Depósito com cashback aplicado! (+R$ 15,00)
💸 Saque de R$ 100,00 realizado com sucesso!
🔄 Transferência de R$ 50,00 concluída.
📄 Extrato da Conta:
2025-10-13 | Depósito de R$ 500,00
2025-10-13 | Saque de R$ 100,00
2025-10-13 | Transferência enviada de R$ 50,00
```
💡 Melhorias Futuras
 Persistência de dados (arquivo ou banco de dados)

 Interface gráfica com JavaFX

 Sistema de autenticação com login e senha

 Geração de relatórios em PDF

 Integração com API de câmbio 💱

👩‍💻 Autora
Bia Lima
Estudante de Análise e Desenvolvimento de Sistemas 💻
Participante dos programas ONE (Oracle Next Education) e Bootcamp Vivo
Apaixonada por tecnologia, aprendizado constante e por transformar ideias em código ✨

📎 LinkedIn (https://www.linkedin.com/in/silva-bianca)
📂 Portfólio (https://milipedia.github.io/portfolio-bia/#portfolio)

Feito para praticar e consolidar os fundamentos da Programação Orientada a Objetos em Java ☕
