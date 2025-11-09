# 🏦 Sistema Bancário Java — com Autenticação, Transferências e API de Câmbio 💸

## 📘 Sobre o projeto
Este é um sistema bancário em **Java** desenvolvido para rodar no terminal, com foco em **orientação a objetos**, **boas práticas** e **uso de APIs externas**.

O projeto simula um banco digital onde o cliente pode:
- Criar contas correntes ou black;
- Fazer login com CPF e senha;
- Consultar saldo, extrato e dados da conta;
- Realizar depósitos, saques e transferências;
- Solicitar cartão de crédito (apenas Conta Black);
- Consultar taxas de câmbio em tempo real via API.

---

## 🚀 Funcionalidades principais

### 👤 Autenticação
- Sistema de login com CPF e senha.
- Permite criar novo cliente e associar uma conta.
- Armazena todos os clientes e contas em memória.

### 💰 Operações bancárias
- **Depósito e saque:** altera o saldo da conta.
- **Transferência:** permite enviar valores entre contas.
- **Extrato:** mostra as movimentações realizadas.
- **Consulta de saldo:** exibe o saldo atual.

### 💳 Cartão de crédito
- Disponível apenas para **Conta Black**.
- Permite definir o limite desejado na criação.

### 🌎 Câmbio (API)
Integração com a API de moedas para converter o saldo atual em:
- Dólar (USD)
- Euro (EUR)
- Libra (GBP)

API utilizada: [ExchangeRate API](https://www.exchangerate-api.com/)

---

## 🧠 Estrutura de pacotes
```
src/
├── Cambio/
│ ├── ApiMoedasService.java
│ └── RespostaAPI.java
├── Contas/
│ ├── Conta.java
│ ├── ContaCorrente.java
│ ├── ContaBlack.java
│ └── Cliente.java
├── Credito/
│ └── cartaoCredito.java
├── Operacoes/
│ └── Transferencia.java
└── Main.java
```
---

## 🏗️ Como executar

### 1. Clone o repositório:
```
git clone https://github.com/seu-usuario/sistema-bancario-java.git
```
2. Abra o projeto no IntelliJ IDEA ou VS Code com suporte Java.
3. Compile e rode o arquivo principal:
javac Main.java
java Main

🧾 Exemplo de uso
🔐 Login / Criação de conta
```
==== LOGIN ====
1 - Fazer login
2 - Criar nova conta
0 - Sair
Escolha: 2
Nome do cliente: Bia
CPF: 12345678900
Idade: 22
Data de nascimento (AAAA-MM-DD): 2003-10-12
Crie uma senha: 1234
Tipo de conta:
1 - Conta Corrente
2 - Conta Black
Escolha: 2
✅ Conta criada com sucesso! Número: 1
```
💵 Operações no menu principal
```
==== MENU PRINCIPAL ====
1 - Ver dados
2 - Depositar
3 - Sacar
4 - Transferir
5 - Ver extrato
6 - Consultar saldo
7 - Solicitar cartão de crédito
8 - Consultar taxas de câmbio
0 - Sair
```
⚙️ Tecnologias utilizadas
☕ Java 17+
📦 Orientação a Objetos
🌐 API HTTP nativa (java.net.http)
🧠 Estruturas de dados (List, ArrayList)
📅 java.time.LocalDate

🧑‍💻 Autora
Bia
Estudante de Engenharia de Software
Apaixonada por tecnologia, lógica e desenvolvimento de software.

📫 LinkedIn ([Bianca Silva!](https://www.linkedin.com/in/silva-bianca))

💡 Ideias futuras
Persistência de dados em arquivo .json ou .txt

Implementar login com múltiplas contas por cliente

Adicionar autenticação de dois fatores

Criar interface gráfica (JavaFX)

📜 Licença
Este projeto é livre para estudo e aprimoramento.
Sinta-se à vontade para modificar, testar e compartilhar!
