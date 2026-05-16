# 🌱 Sistema Reciclaplan (EcoCash)

Um sistema de gerenciamento para depósitos de reciclagem, desenvolvido em Java com interface gráfica (JavaFX) e banco de dados relacional (PostgreSQL).

O objetivo deste sistema é facilitar o dia a dia dos atendentes de depósitos de sucata, permitindo o cálculo automático do valor de materiais pesados (com desconto de tara) e o registro rápido das compras no banco de dados.

## 🚀 Funcionalidades Atuais

* [x] **Módulo Atendente:** Interface gráfica interativa para o registro de compras.
* [x] **Cálculo Automático:** Calcula o valor final com base no preço do material cadastrado no banco e no peso líquido (Peso Bruto - Tara).
* [x] **Conexão com Banco de Dados:** Salva todas as transações de forma persistente e segura usando JDBC.
* [x] **Busca Dinâmica:** O sistema identifica o material pelo ID e puxa o valor do quilo atualizado diretamente do banco de dados.

* ## 🔮 Implementações Futuras (Roadmap)

O sistema foi pensado para ser escalável. As seguintes melhorias e novas funcionalidades estão mapeadas para as próximas versões:

* [ ] **Tela do Gerente (Dashboard):** Uma interface exclusiva com gráficos e tabelas para visualizar o histórico de compras, fechamento de caixa e total de quilos comprados no dia.
* [ ] **Busca Dinâmica por Nome:** Substituir o campo de "ID" na tela da atendente por um menu suspenso (ComboBox) com pesquisa inteligente pelo nome do material.
* [ ] **Sistema de Login e Autenticação:** Diferenciar permissões de acesso entre perfis de "Atendente" (apenas caixa) e "Gerente" (acesso a relatórios e cadastro de preços).
* [ ] **Geração de Recibos:** Criar a funcionalidade de exportar um comprovante em PDF ou imprimir um pequeno recibo da transação no momento da pesagem.
* [ ] **Controle de Estoque e Caixa:** Registrar a quantidade total de material acumulado no galpão e gerenciar o saldo financeiro disponível para novas compras.

## 🛠️ Tecnologias Utilizadas

* **Java (JDK 17+)** - Linguagem principal do projeto.
* **JavaFX** - Biblioteca para a construção da Interface Gráfica (GUI).
* **PostgreSQL** - Sistema de Gerenciamento de Banco de Dados.
* **JDBC** - Driver nativo de comunicação entre o Java e o banco de dados.
* **Maven** - Gerenciador de dependências e build do projeto.
* **Git & GitHub** - Controle de versão.

## 📂 Estrutura do Projeto

O sistema foi construído utilizando os conceitos de **Padrão MVC / DAO**, separando a lógica de negócios da interface visual:

* `models/` (Material, Compra): Classes que representam as entidades do sistema.
* `dao/` (MaterialDAO, CompraDAO): Classes responsáveis exclusivamente por executar os comandos SQL (INSERT, SELECT) no banco.
* `controllers/` (AtendenteController): O "cérebro" da tela, que reage aos cliques dos botões e faz os cálculos.
* `resources/` (Atendente.fxml): O arquivo visual que desenha a tela.

## ⚙️ Como executar o projeto na sua máquina

### Pré-requisitos
Para rodar este projeto, você precisará ter instalado na sua máquina:
* Java (JDK 11 ou superior)
* Maven
* PostgreSQL e pgAdmin
* Uma IDE (como IntelliJ IDEA ou Eclipse)

### Passo a passo

1. **Clone o repositório**
```bash
git clone [https://github.com/SEU_USUARIO/Sistema-Reciclaplan.git](https://github.com/SEU_USUARIO/Sistema-Reciclaplan.git)
```

### 2. Configure o Banco de Dados
* Abra o seu **pgAdmin** e crie um banco de dados chamado `n_ecocash` (ou o nome da sua preferência).
* Abra a **Query Tool** e cole/execute os comandos que estão no arquivo `database.sql` na raiz do projeto para criar as tabelas e inserir os materiais base.

### 3. Configure as Credenciais no Java
* Vá até a classe `Conexao.java` no caminho: `src/main/java/Conexao.java`.
* Altere as variáveis `URL`, `USUARIO` e `SENHA` para as configurações reais do seu banco de dados local:

```java
private static final String URL = "jdbc:postgresql://localhost:5432/n_ecocash";
private static final String USUARIO = "postgres";
private static final String SENHA = "SUA_SENHA_AQUI";
```
### 4. Baixe as Dependências e Execute
* No IntelliJ IDEA, clique no botão de recarregar o Maven (ícone do "M" com a seta azul no canto superior direito) para que ele baixe os drivers do PostgreSQL e do JavaFX automaticamente.
* Execute a classe Main.java para abrir a tela do sistema.

Desenvolvido por Beatriz da Cunha Santos para fins de estudo e prática de desenvolvimento Backend.
