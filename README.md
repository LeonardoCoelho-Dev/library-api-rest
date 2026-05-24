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

Além disso, o projeto busca reforçar conceitos iniciais de **DDD**, utilizando uma organização mais próxima do domínio da aplicação, separando entidades, responsabilidades e fluxos da API.

---

# 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
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

A estrutura atual busca aplicar conceitos iniciais de **Domain Driven Design (DDD)**, organizando os pacotes de acordo com o contexto da aplicação:

```text
author/
book/
publisher/
controller/
```

---

# 🌐 Endpoints

## 📖 Registrar Livro

```http
POST /books
```

---

## 📚 Listar Livros

```http
GET /books
```

---

## ✏️ Atualizar Livro

```http
PUT /books
```

---

## ❌ Deletar Livro

```http
DELETE /books/{id}
```

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

---

# 🎯 Próximos Passos

Algumas melhorias futuras planejadas:

- Swagger/OpenAPI
- Tratamento global de exceções
- Relacionamentos entre entidades
- Sistema de autenticação
- Docker
- Deploy da aplicação
- Integração com frontend
- Evolução da arquitetura baseada em DDD

---

# 👨‍💻 Autor

Desenvolvido por **Leonardo Coelho**

🔗 GitHub:  
https://github.com/LeonardoCoelho-Dev
