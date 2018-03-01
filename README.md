# Descrição do Projeto:

-Projeto web com spring-boot utilizando maven ou gradle

-template engine thymeleaf

-Model:

a. Client

  i. name (string, obrigatório)
  
  ii. email (string, obrigatório)
  
  iii. birthdate (date, opcional)
  
b. Product

  i. name (string, obrigatório)
  
  ii. description (string, opcional)
  
  iii. price (double, obrigatório)
  
c. Sale

  i. client (obrigatório)
  
  ii. products (obrigatório pelo menos 1 produto)
  
d. Sale_product

  i. sale
  
  ii. quantity
  
  iii. product

-Telas (CRUD) dos models acima

-Database migration flyway

-ORM hibernate

-layout do projeto com bootstrap

-AngularJs

-Banco de Dados: Postgres (CRIAR uma base com o nome api_enterprise_sale)

-nomes das classes, métodos, variáveis em Inglês

-A aplicação é auto explicativa, leia as dicas.

-Regras de negócio foram implementadas, como não é permitido remover um cliente ou produto que está sendo referenciado em uma venda.
