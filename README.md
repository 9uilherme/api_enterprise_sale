# Descrição do Projeto:

-Projeto web com spring-boot utilizando maven

-template engine thymeleaf

-Model:

a. Client (name (string, obrigatório), email (string, obrigatório), birthdate (date, opcional))
  
b. Product (name (string, obrigatório), description (string, opcional), price (double, obrigatório))
  
c. Sale (client (obrigatório), products (obrigatório pelo menos 1 produto))
  
d. Sale_product (sale, quantity, product)

-Telas (CRUD) dos models acima

-Database migration flyway

-ORM hibernate

-layout do projeto com bootstrap

-AngularJs

-Banco de Dados: Postgres (CRIAR uma base com o nome api_enterprise_sale)

-nomes das classes, métodos, variáveis em Inglês

-A aplicação é auto explicativa, leia as dicas.

-Regras de negócio foram implementadas, como não é permitido remover um cliente ou produto que está sendo referenciado em uma venda.
