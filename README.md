# 📚 Library API REST

API REST desenvolvida com **Spring Boot** para gerenciamento de livros, criada com foco em aprendizado prático de desenvolvimento backend, modelagem de domínio e integração com banco de dados relacional.

O projeto também foi desenvolvido com o objetivo de começar a aplicar conceitos de **Domain Driven Design (DDD)** na estruturação da aplicação, buscando uma melhor separação de responsabilidades e organização do domínio da aplicação.

---

# 🚀 Objetivo do Projeto

Este projeto foi criado com o objetivo de consolidar conceitos fundamentais do ecossistema Java/Spring através da construção de uma aplicação backend real.

Durante o desenvolvimento, foram praticados conceitos como:

- APIs REST
- CRUD completo
- DTOs
- Paginação
- Bean Validation
- JPA/Hibernate
- Flyway
- MySQL
- Estruturação de aplicações backend
- Modelagem de domínio
- Versionamento com Git e GitHub
- Autenticação e autorização com Spring Security
- Tokens JWT (JSON Web Token)
- Hash de senhas com BCrypt
- Controle de acesso baseado em roles (RBAC)

Além disso, o projeto busca reforçar conceitos iniciais de **DDD**, utilizando uma organização mais próxima do domínio da aplicação, separando entidades, responsabilidades e fluxos da API.

---

# 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Spring Security
- JWT (java-jwt / Auth0)
- BCrypt
- MySQL
- Flyway
- Maven
- Lombok
- Bean Validation
- Git
- GitHub
- Postman

---

# 📌 Funcionalidades

✅ Cadastro de livros  
✅ Listagem paginada de livros  
✅ Atualização de registros  
✅ Exclusão de livros  
✅ Persistência em banco de dados MySQL  
✅ Validação de dados  
✅ Migrations com Flyway  
✅ Organização baseada em domínio  
✅ API RESTful  
✅ Autenticação via login com geração de token JWT  
✅ Registro de usuários com senha criptografada (BCrypt)  
✅ Autorização baseada em roles (`USER` / `ADMIN`)  
✅ Proteção de rotas com Spring Security  

---

# 🧱 Estrutura da Aplicação

A aplicação foi estruturada utilizando:

- Entities
- DTOs (`Records`)
- Controllers REST
- Repository Pattern
- Embedded Objects (`@Embedded`)
- Enum para categorização de gêneros
- Paginação com Spring Data
- Organização baseada em domínio
- Filtro de autenticação JWT (`OncePerRequestFilter`)
- Configuração de segurança stateless (`SecurityFilterChain`)

A estrutura atual busca aplicar conceitos iniciais de **Domain Driven Design (DDD)**, organizando os pacotes de acordo com o contexto da aplicação:

```text
domain/
├── author/
├── book/
├── user/
└── publisher/
auth/
controller/
infra/
└── security/
```

---

# 🌐 Endpoints

## 🔐 Autenticação

### Login

```http
POST /auth/login
```

Rota pública. Recebe usuário e senha e retorna um token JWT, que deve ser enviado no header `Authorization: Bearer <token>` nas demais requisições.

```json
{
  "username": "admin",
  "password": "admin123"
}
```

### Registrar usuário

```http
POST /auth/register
```

Restrito a usuários com role `ADMIN`. Cria um novo usuário com senha criptografada em BCrypt.

```json
{
  "username": "leitor1",
  "password": "senha123",
  "role": "USER"
}
```

> Um usuário `admin` inicial (`admin` / `admin123`) é criado automaticamente via migration Flyway, para permitir o primeiro acesso e o cadastro dos demais usuários. **Troque essa senha em qualquer ambiente compartilhado.**

---

## 📖 Registrar Livro

```http
POST /books
```

🔒 Requer autenticação com role `ADMIN`.

---

## 📚 Listar Livros

```http
GET /books
```

🔒 Requer autenticação (`USER` ou `ADMIN`).

---

## ✏️ Atualizar Livro

```http
PUT /books
```

🔒 Requer autenticação com role `ADMIN`.

---

## ❌ Deletar Livro

```http
DELETE /books/{id}
```

🔒 Requer autenticação com role `ADMIN`.

---

# 🗄️ Banco de Dados e Persistência

O projeto utiliza:

- **MySQL** como banco de dados relacional
- **Flyway** para versionamento e controle de migrations
- **JPA/Hibernate** para mapeamento objeto-relacional
- **Spring Data JPA** para criação dos repositories
- **Migrations SQL** para criação e evolução das tabelas
- **Paginação** com `Pageable` e `Page`
- **Validações** com Bean Validation
- **DTOs** para entrada e saída de dados da API
- **Enums** para definição dos gêneros dos livros
- **Embedded Objects** para representar objetos de domínio como `Author` e `Publisher`
- **Tabela `users`** para autenticação, com senha armazenada em hash BCrypt
- **Seed de usuário admin** via migration para bootstrap inicial do sistema de autenticação

---

# 📘 Conceitos Praticados

Durante o desenvolvimento deste projeto foram reforçados conceitos como:

- Arquitetura REST
- Métodos HTTP
- DTOs
- Paginação
- Persistência de dados
- CRUD
- JPA/Hibernate
- Validation
- Migrations
- Modelagem de domínio
- Estruturação backend
- Git/GitHub
- Conceitos iniciais de DDD
- Autenticação stateless com JWT
- Autorização baseada em roles com Spring Security
- Criptografia de senhas com BCrypt

---

# 🎯 Próximos Passos

Algumas melhorias futuras planejadas:

- Swagger/OpenAPI
- Tratamento global de exceções
- Relacionamentos entre entidades
- Endpoint de troca de senha
- Refresh token
- Docker
- Deploy da aplicação
- Integração com frontend
- Evolução da arquitetura baseada em DDD

---

# 👨‍💻 Autor

Desenvolvido por **Leonardo Coelho**

🔗 GitHub:  
https://github.com/LeonardoCoelho-Dev
