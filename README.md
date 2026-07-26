# 👥 User Management API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

User management API built with Spring Boot, following clean architecture and backend best practices.

Esta é uma API RESTful desenvolvida para o gerenciamento centralizado de usuários. O projeto foi estruturado com foco em manutenibilidade e escalabilidade, aplicando princípios de Clean Architecture e garantindo uma separação clara de responsabilidades entre domínio, casos de uso e infraestrutura.

## 🚀 Funcionalidades

* **CRUD Completo de Usuários:** Endpoints para criação, leitura, atualização e exclusão de registros.
* **Arquitetura Limpa:** Regras de negócio isoladas de frameworks e detalhes de banco de dados.
* **Boas Práticas:** Utilização de DTOs para transferência segura de dados e tratamento global de exceções.

## 🛠️ Tecnologias Utilizadas

* **Java** 
* **Spring Boot** (Web, Data JPA)
* **PostgreSQL** (Banco de dados relacional principal)
* **Lombok** (Para otimização de código e redução de boilerplate, como Getters, Setters e Construtores)
* **Maven** (Gerenciamento de dependências)

## ⚙️ Pré-requisitos

Para executar o projeto localmente, você precisará de:
* Java 17 ou superior
* Maven
* PostgreSQL rodando localmente ou em container (Docker)

## 🔧 Configuração e Execução

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/H4ttiz/user-management-api.git
   cd user-management-api
   ```

2. **Configure o Banco de Dados:**
   No arquivo `src/main/resources/application.properties`, configure as credenciais de acesso ao PostgreSQL:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/user_management
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Inicie a aplicação:**
   Pelo terminal, na raiz do projeto, execute:
   ```bash
   mvn spring-boot:run
   ```

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para fazer um _fork_ do repositório, criar uma _branch_ com suas alterações (`git checkout -b feature/nova-funcionalidade`) e enviar um _Pull Request_.

## 📝 Licença

Este projeto é de código aberto.
