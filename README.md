Estoque de Veículos - Backend
=============================

Aplicação Spring Boot para gerenciamento de veículos.
Permite cadastrar, listar, atualizar status e excluir veículos.
Este projeto faz parte do sistema de controle de estoque de veículos.

IMPORTANTE
----------
Este backend depende do frontend em React para funcionar corretamente.
Os dois projetos (backend e frontend) estarão disponíveis nos meus repositórios GitHub:
- EstoqueVeiculosBackend
- EstoqueVeiculosFrontend

O backend fornece a API REST e o frontend consome essa API para exibir e manipular os dados.

Tecnologias utilizadas
----------------------
- Java 17+ (compatível também com Java 21)
- Spring Boot
- Spring Data JPA
- Spring Security
- Maven
- Banco de dados (MySQL via Docker)

Como rodar o projeto
--------------------
1. Clone o repositório:
   git clone https://github.com/marcosamambaia/EstoqueVeiculosBackend.git
   cd EstoqueVeiculosBackend

2. Acesse a pasta raiz do backend (onde está o pom.xml).
   Exemplo no seu ambiente:
   cd "/home/marco/Área de trabalho/Java/TrabalhoFinal/Spring-Boot"

3. Compile e rode com Maven:
   mvn spring-boot:run

4. A API estará disponível em:
   http://localhost:8081

5. Para que o sistema funcione corretamente, é necessário também rodar o frontend React
   que estará disponível no repositório EstoqueVeiculosFrontend.
   O frontend se conecta ao backend na porta 8081.

---

Banco de Dados com Docker
-------------------------
Para rodar o MySQL via Docker:
```

docker run --name mysql-estoque \
  -e MYSQL_ROOT_PASSWORD=123456 \
  -e MYSQL_DATABASE=estoque_veiculos \
  -p 3306:3306 \
  -d mysql:8.0

- MYSQL_ROOT_PASSWORD=123456 → senha do usuário root  
- MYSQL_DATABASE=estoque_veiculos → banco criado automaticamente  
- -p 3306:3306 → expõe a porta 3306 para conexão local  
```
Verifique se o container está rodando:
```
docker ps
```

Acesse o banco:
```
docker exec -it mysql-estoque mysql -uroot -p
```
---

Configuração do application.properties
--------------------------------------
```
# Porta do servidor
server.port=8081

# Configuração do banco de dados MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/estoque_veiculos?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuração do JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```
---

Endpoints principais
--------------------
Usuários:
- POST /usuarios/cadastro -> cadastrar usuário
- POST /usuarios/login -> login de usuário

Veículos:
- GET /veiculos -> lista todos os veículos
- POST /veiculos -> cadastra um novo veículo
- GET /veiculos/{id} -> busca veículo por ID
- PUT /veiculos/{id}/vendido -> marca veículo como vendido
- PUT /veiculos/{id} -> atualizar veículo
- DELETE /veiculos/{id} -> remove veículo

Marcas:
- GET /marcas -> lista todas as marcas

Modelos:
- GET /modelos -> lista todos os modelos

---

Perfis de Usuário
-----------------
- ADMIN → pode criar marcas/modelos, cadastrar usuários e editar informações.  
- VENDEDOR → pode cadastrar veículos e marcar como vendidos.  

---

Estrutura do projeto
--------------------
```
src/main/java/com/unifecaf/estoqueveiculos/
 ├── controller/   -> Controllers REST
 ├── dto/          -> Data Transfer Objects (DTOs)
 ├── model/        -> Entidades JPA
 ├── service/      -> Regras de negócio
 └── repository/   -> Interfaces de acesso ao banco
```
---

Testes com Postman
------------------
Cadastro de Usuário:
```
POST http://localhost:8081/usuarios/cadastro
Body:
{
  "nome": "Administrador",
  "email": "admin@teste.com",
  "senha": "123456",
  "perfil": "ADMIN"
}

Login:
POST http://localhost:8081/usuarios/login
Body:
{
  "email": "admin@teste.com",
  "senha": "123456"
}

Cadastro de Veículo:
POST http://localhost:8081/veiculos
Body:
{
  "modelo": "Civic",
  "marca": "Honda",
  "ano": 2022,
  "cor": "Preto",
  "preco": 120000,
  "quilometragem": 15000,
  "status": "DISPONIVEL"
}
```
---

Autor
-----
Marco Samambaia  
Projeto acadêmico desenvolvido em Java com Spring Boot.
