# Estoque de Veículos - Backend
===============================

## Sobre o projeto
Este é o backend do sistema Estoque de Veículos, desenvolvido em Spring Boot como parte de um trabalho acadêmico.  
O objetivo é fornecer uma API REST para gerenciamento de Marcas, Modelos e Veículos, com controle de acesso por perfis de usuário (ADMIN e VENDEDOR).

IMPORTANTE
----------
Este backend depende do frontend em React (EstoqueVeiculosFrontend) para funcionar corretamente.  
Os dois projetos estarão disponíveis nos meus repositórios GitHub:
- EstoqueVeiculosBackend
- EstoqueVeiculosFrontend

O backend roda na porta 8081 e deve estar ativo para que o frontend consiga consumir a API.

------------------------------------------------------------

## Tecnologias utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL (Docker)
- Maven
- Postman (para testes de integração)

------------------------------------------------------------

## Funcionalidades
- Cadastro e autenticação de usuários.
- Perfis de acesso:
  - ADMIN → acesso a Marcas, Modelos e Veículos.
  - VENDEDOR → acesso apenas a Veículos.
- Endpoints REST para CRUD de entidades.
- Integração com banco de dados MySQL.

------------------------------------------------------------

## Estrutura principal
- controller/ → Controladores REST.
- service/ → Regras de negócio.
- repository/ → Interfaces JPA.
- model/ → Entidades.
- dto/ → Objetos de transferência de dados.

------------------------------------------------------------

## Configuração e execução

1. Banco de dados (MySQL via Docker)
```
docker run --name mysql-estoque -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=estoque -p 3306:3306 -d mysql:8

3. Configuração do application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/estoque
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
4. Executar o backend
```
./mvnw spring-boot:run
```
O backend ficará disponível em:
```
http://localhost:8081
```
------------------------------------------------------------

## Endpoints principais

Usuários:
```
- POST /usuarios/cadastro → cadastrar novo usuário.
- POST /usuarios/login → autenticar usuário.
```
Exemplo de cadastro via Postman (ADMIN):
```
{
  "nome": "Administrador",
  "email": "admin@test.com",
  "senha": "123456",
  "perfil": "ADMIN"
}
```
Exemplo de cadastro via Postman (VENDEDOR):
```
{
  "nome": "João",
  "email": "joao@test.com",
  "senha": "123456",
  "perfil": "VENDEDOR"
}
```
------------------------------------------------------------

## Perfis de acesso
- ADMIN → pode acessar /marcas, /modelos, /veiculos.
- VENDEDOR → pode acessar apenas /veiculos.

------------------------------------------------------------

## Observação
Os usuários poderiam ser cadastrados pelo frontend, mas optamos por usar o Postman na apresentação para demonstrar o uso de diferentes ferramentas.

------------------------------------------------------------

## Licença
Projeto acadêmico desenvolvido para fins de estudo.
