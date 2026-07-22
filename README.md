# Banco-em-java
Um sistema bancário feito totalmente em java.


## Descrição

O projeto consiste em um sistema bancário simples desenvolvido na linguagem **Java**. Seu objetivo é simular operações básicas realizadas por um banco, permitindo o cadastro de clientes, consulta de saldo, depósitos e saques.

As contas são armazenadas em memória utilizando a estrutura de dados **HashMap**, onde a chave corresponde ao **CPF** do cliente e o valor corresponde ao **saldo** da conta.

---

# Estrutura da Classe

## Classe `Functions`

A classe `Functions` é responsável por gerenciar todas as operações do sistema bancário.

### Atributos

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| `saldo` | `double` | Armazena o saldo do cliente. |
| `cpf` | `String` | Armazena o CPF do cliente. |
| `ClientesCadastrados` | `Map<String, Double>` | Armazena os clientes cadastrados utilizando o CPF como chave e o saldo como valor. |
| `scanner` | `Scanner` | Responsável pela leitura das informações digitadas pelo usuário. |

---

# Métodos

## `IniciarConta(double saldo, String cpf)`

Inicializa uma conta adicionando um cliente ao sistema.

### Parâmetros

- **saldo:** saldo inicial da conta.
- **cpf:** CPF do cliente.

### Funcionamento

Insere o CPF e o saldo dentro do `HashMap`.

---

## `CriarConta(String cpf, double saldo)`

Realiza o cadastro de um novo cliente.

### Funcionamento

O sistema solicita:

- CPF;
- Saldo inicial.

Caso o saldo informado seja negativo, é solicitado um novo valor.

Ao final, o cliente é inserido no `HashMap`.

---

## `ConsultarSaldo(String cpf)`

Consulta o saldo de um cliente.

### Funcionamento

Primeiramente verifica se o CPF existe no sistema.

Se existir:

- Exibe o saldo.

Caso contrário:

- Exibe uma mensagem informando que o CPF não foi encontrado.

---

## `Depositar(String cpf)`

Realiza um depósito.

### Funcionamento

1. Verifica se o CPF está cadastrado.
2. Solicita o valor do depósito.
3. Valida se o valor é maior que zero.
4. Atualiza o saldo da conta.

---

## `Sacar(String cpf)`

Realiza um saque.

### Funcionamento

1. Verifica se o CPF existe.
2. Solicita o valor do saque.
3. Confere se existe saldo suficiente.
4. Atualiza o saldo da conta.

Caso o saldo seja insuficiente, o saque é cancelado.

---

## `VerificarCpf(String cpf)`

Verifica se um CPF está cadastrado.

### Retorno

| Valor | Significado |
|--------|-------------|
| `1` | CPF encontrado |
| `0` | CPF inexistente |

---

## `VerificarSaldoInicial(double saldo)`

Valida o saldo inicial informado durante o cadastro.

### Retorno

| Valor | Significado |
|--------|-------------|
| `1` | Saldo válido |
| `0` | Saldo inválido |

---

## `VerificarDeposito(String cpf, double deposito)`

Valida um depósito.

### Retorno

| Valor | Significado |
|--------|-------------|
| `1` | Depósito permitido |
| `0` | Valor inválido |

---

## `VerificarSacagem(String cpf, double saque)`

Verifica se o cliente possui saldo suficiente para realizar um saque.

### Retorno

| Valor | Significado |
|--------|-------------|
| `1` | Saque permitido |
| `0` | Saldo insuficiente |

---

# Estrutura de Dados Utilizada

Foi utilizada a classe `HashMap` da biblioteca `java.util`.

Cada cliente é armazenado da seguinte forma:

```text
CPF ----------> Saldo
```

### Exemplo

```text
12345678900 → R$ 500,00
98765432100 → R$ 1.200,00
```

Essa estrutura proporciona busca rápida de clientes através do CPF.

---

# Bibliotecas Utilizadas

| Biblioteca | Finalidade |
|------------|------------|
| `java.util.Scanner` | Entrada de dados pelo teclado. |
| `java.util.HashMap` | Armazenamento dos clientes. |
| `java.util.Map` | Interface utilizada para manipulação do `HashMap`. |

---

# Fluxograma Simplificado

```text
Início
   │
   ▼
Menu Principal
   │
   ├── Criar Conta
   │        │
   │        ▼
   │   Armazena CPF e saldo
   │
   ├── Consultar Saldo
   │        │
   │        ▼
   │   Verifica CPF
   │
   ├── Depositar
   │        │
   │        ▼
   │   Atualiza saldo
   │
   ├── Sacar
   │        │
   │        ▼
   │   Verifica saldo
   │
   └── Sair
```

---

# Possíveis Melhorias

O sistema pode ser aprimorado com diversas funcionalidades, como:

- Criar uma classe `Cliente` para armazenar mais informações (nome, agência, número da conta, senha etc.).
- Substituir os métodos que retornam `int` (`0` ou `1`) por métodos que retornem `boolean`.
- Separar a lógica de negócio da interação com o usuário, deixando a classe `Functions` responsável apenas pelas operações bancárias.
- Implementar persistência de dados em arquivos ou banco de dados.
- Adicionar autenticação por senha.
- Criar um histórico de transações.
- Tratar exceções para evitar falhas causadas por entradas inválidas.

---

# Conclusão

O projeto demonstra a aplicação de conceitos fundamentais da linguagem **Java**, como orientação a objetos, encapsulamento, métodos, estruturas condicionais, coleções (`HashMap`) e manipulação de entrada de dados com `Scanner`.

Embora seja um sistema simples, ele fornece uma base sólida para a implementação de aplicações bancárias mais completas, permitindo evoluções futuras com novas funcionalidades e uma arquitetura mais organizada.
