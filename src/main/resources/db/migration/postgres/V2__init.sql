CREATE SEQUENCE hibernate_sequence START 1;

insert into client values (nextval('hibernate_sequence'), '2000-01-15', null, CURRENT_DATE, '9uilhermealencar@gmail.com', 'Guilherme');
insert into client values (nextval('hibernate_sequence'), '2001-05-20', null, CURRENT_DATE, 'leonardocilia@gmail.com', 'Leonardo');

insert into product values (nextval('hibernate_sequence'), null , CURRENT_DATE, 'Pureza em forma de grãos', 'Arroz Cristal', '10.00');
insert into product values (nextval('hibernate_sequence'), null , CURRENT_DATE, 'O melhor feijão', 'Feijão Barão', '12.90');

insert into sale values (nextval('hibernate_sequence'), null, CURRENT_DATE, (select id from client order by id desc limit 1));
insert into sale_product values (nextval('hibernate_sequence'), null, CURRENT_DATE, 5, (select id from product order by id desc limit 1), (select id from sale order by id desc limit 1));
