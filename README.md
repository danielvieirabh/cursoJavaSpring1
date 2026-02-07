# Curso Spring Boot Project

Este é um projeto de demonstração desenvolvido com Spring Boot.

## Tecnologias Utilizadas

*   **Java 25**
*   **Spring Boot 4.0.2**
*   **Spring Data JPA**
*   **Spring Web MVC**
*   **Banco de Dados:**
    *   H2 Database (para testes/desenvolvimento)
    *   PostgreSQL
    *   MySQL

## Modelo de Domínio

O sistema implementa um modelo de e-commerce com as seguintes entidades e relacionamentos:

*   **User (Usuário):** Cliente do sistema. Possui muitos pedidos (`OneToMany`).
*   **Order (Pedido):** Compra realizada pelo usuário. Possui itens, pagamento e status.
*   **Category (Categoria):** Categoria dos produtos (ex: Eletrônicos). Relacionamento muitos-para-muitos com produtos.
*   **Product (Produto):** Itens vendidos. Pertence a categorias e compõe itens de pedido.
*   **OrderItem (Item de Pedido):** Entidade associativa entre Pedido e Produto, armazenando quantidade e preço no momento da compra.
*   **Payment (Pagamento):** Registro de pagamento associado a um pedido (`OneToOne`).

## Estrutura do Projeto

O projeto segue a arquitetura em camadas padrão do Spring Boot:

*   `config`: Configurações do projeto.
*   `entities`: Entidades JPA (Modelo de Domínio).
*   `repositories`: Interfaces de acesso a dados (Spring Data JPA).
*   `services`: Camada de serviço (Lógica de Negócios).
*   `resources`: Controladores REST (Camada Web).

## Como Executar

1.  Certifique-se de ter o JDK 25 instalado.
2.  Clone o repositório.
3.  Navegue até a pasta raiz do projeto.
4.  Execute o comando Maven:

    ```bash
    ./mvnw spring-boot:run
    ```

## Configuração do Banco de Dados

O projeto possui dependências para H2, PostgreSQL e MySQL. Verifique o arquivo `application.properties` (ou `application.yml`) em `src/main/resources` para configurar a conexão com o banco de dados desejado.
