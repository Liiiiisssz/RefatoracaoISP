# 🚨 Violação do ISP

## 📚 Contextualização
A **TechStore** (a mesma do cenário anterior) está expandindo suas operações de atendimento ao cliente e suporte.  
A equipe de desenvolvimento criou uma interface monolítica chamada **GerenciadorDeClientes**, que agrupa todas as possíveis operações que um cliente pode exigir:

- Operações básicas de **cadastro**
- Envio de **comunicação** (e-mail/SMS)
- Operações de **fidelidade** (aplicação de descontos VIP)

---

## ❌ O Problema: Violação do ISP
A interface **GerenciadorDeClientes** é muito grande e "obesa".  
Ela força as classes concretas que a implementam a definir métodos que elas **não precisam ou não deveriam utilizar**.

---

## 🔎 Explicação do Mau Design

A interface **GerenciadorDeClientes** é **monolítica**, pois reúne várias responsabilidades diferentes na mesma interface:

- Cadastro de clientes  
- Comunicação  
- Fidelidade / VIP  

Com isso, todas as classes que implementam essa interface são obrigadas a implementar **todos os métodos**, mesmo aqueles que **não fazem sentido para elas**.

### 📌 No código

- **ClienteVIPService** usa todos os métodos → **não há problema**

- **ClienteComumService** **não precisa** das funcionalidades:
  - `enviarNotificacao`
  - `aplicarDescontoVIP`

Mesmo assim, a classe é **forçada a implementar esses métodos**, tendo que:

- deixar o método vazio, ou  
- lançar exceção (`UnsupportedOperationException`)

Isso gera:

- ⚠️ **código menos coeso**
- ⚠️ **maior dificuldade de manutenção**
- ⚠️ **maior chance de erros**

---

## 🛠️ Solução

Para resolver o problema, a interface foi **dividida em interfaces menores e mais específicas**, seguindo o **Princípio da Segregação de Interfaces (ISP)**.

Foram criadas **três interfaces**:

### 📋 CadastroCliente
Responsável pelas operações de cadastro.

Métodos:
- `cadastrarCliente`
- `buscarClientePorEmail`

### ⭐ GerenciadorFidelidade
Responsável pela aplicação de descontos VIP.

Método:
- `aplicarDescontoVIP`

### 📩 NotificadorCliente
Responsável pelo envio de notificações.

Método:
- `enviarNotificacao`

---

## ✅ Resultado

Agora cada classe implementa **apenas as interfaces necessárias** para sua funcionalidade.

- **ClienteComumService**
  - Implementa apenas **CadastroCliente**

- **ClienteVIPService**
  - Implementa:
    - **CadastroCliente**
    - **GerenciadorFidelidade**
    - **NotificadorCliente**

### 🎯 Benefícios

- Evita **métodos desnecessários**
- Melhora a **manutenção do código**
- Aplica corretamente o **princípio ISP do SOLID**
