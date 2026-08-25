# Projeto Web - Maven + Tomcat + VS Code

Este é um projeto web Java criado com **Maven** e executado no **Tomcat 11**.

## Estrutura do projeto

```
teste/
├── pom.xml                          # Configuração do Maven
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/                  # Servlets (Controllers)
│   │   │   │   ├── AutenticacaoController.java
│   │   │   │   ├── ProdutoController.java
│   │   │   │   └── UsuarioController.java
│   │   │   ├── dao/                         # Acesso ao banco de dados
│   │   │   │   ├── Conexao.java
│   │   │   │   ├── ProdutoDAO.java
│   │   │   │   └── UsuarioDAO.java
│   │   │   ├── filter/                      # Filtros de requisição
│   │   │   │   └── AuthFilter.java
│   │   │   ├── model/                       # Classes modelo
│   │   │   │   ├── ProdutoModel.java
│   │   │   │   └── UsuarioModel.java
│   │   │   ├── servlet/                     # Outros servlets
│   │   │   │   └── SaudacaoServlet.java
│   │   │   └── util/                        # Utilitários
│   │   │       └── SenhaUtil.java
│   │   ├── resources/schema.sql             # Script do banco de dados
│   │   └── webapp/
│   │       ├── index.jsp                    # Página inicial
│   │       ├── login.jsp                    # Página de login
│   │       ├── registrar.jsp                # Página de cadastro
│   │       ├── produtos.jsp                 # Listagem de produtos
│   │       ├── produto-form.jsp             # Formulário de produto
│   │       ├── saudacao.jsp                 # Página de saudação
│   │       ├── admin/index.jsp              # Área protegida
│   │       └── WEB-INF/web.xml              # Configuração da aplicação
│   └── target/                              # Arquivos gerados pelo Maven
```

## Requisitos

- JDK 17 ou superior (o projeto usa Java 21)
- Maven 3.9+
- MySQL Server rodando localmente
- VS Code com extensões:
  - **Extension Pack for Java**
  - **Tomcat for Java** (opcional, para rodar Tomcat pelo VS Code)

## Banco de dados

1. Inicie o MySQL.
2. Execute o script em `src/main/resources/schema.sql` para criar o banco `java` e as tabelas `produtos` e `usuarios`.
3. Ajuste usuário/senha em `src/main/java/dao/Conexao.java`, se necessário (padrão: `root` / sem senha).

## Como executar

### Opção 1: Pelo terminal (Cargo + Tomcat embarcado)

```bash
cd teste
mvn clean package
mvn org.codehaus.cargo:cargo-maven3-plugin:run
```

Acesse no navegador: `http://localhost:8080/demo/`

### Opção 2: Pelo VS Code (Tomcat for Java)

1. Instale a extensão **Tomcat for Java**.
2. Clique com o botão direito no arquivo `target/demo.war` → **Run on Tomcat Server**.
3. Escolha o Tomcat 11 instalado na máquina.

## Funcionalidades

- **Saudação**: na página inicial, digite um nome e envie. O `SaudacaoServlet` recebe a mensagem e exibe a saudação em `saudacao.jsp`.
- **Autenticação**: cadastro em `registrar.jsp`, login em `login.jsp` e logout. A senha é criptografada com **jBCrypt**.
- **Área protegida**: a pasta `admin/` é protegida pelo `AuthFilter`. Usuários não autenticados são redirecionados para o login.
- **CRUD de produtos**: na área logada, acesse a lista de produtos para **criar**, **editar** e **excluir** produtos.

## O que é um Servlet?

Um **Servlet** é uma classe Java que recebe requisições HTTP, processa dados e devolve uma resposta (HTML, redirecionamento, JSON etc.). Os principais métodos são:

- `doGet(HttpServletRequest req, HttpServletResponse resp)`: processa requisições GET.
- `doPost(HttpServletRequest req, HttpServletResponse resp)`: processa requisições POST.
- `init()` e `destroy()`: ciclo de vida do servlet.
