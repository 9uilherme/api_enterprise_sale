
CREATE TABLE client
(
  id bigint NOT NULL,
  birth_date timestamp,
  data_alteracao timestamp,
  data_criacao timestamp,
  email character varying(255) NOT NULL,
  name character varying(255) NOT NULL,
  CONSTRAINT client_pkey PRIMARY KEY (id)
);


CREATE TABLE product
(
  id bigint NOT NULL,
  data_alteracao timestamp ,
  data_criacao timestamp ,
  description character varying(255),
  name character varying(255) NOT NULL,
  price numeric(19,2) NOT NULL,
  CONSTRAINT product_pkey PRIMARY KEY (id)
);


CREATE TABLE sale
(
  id bigint NOT NULL,
  data_alteracao timestamp ,
  data_criacao timestamp ,
  client_id bigint NOT NULL,
  CONSTRAINT sale_pkey PRIMARY KEY (id),
  CONSTRAINT fkon0o9ba5ajsnwivekhl1tfjiy FOREIGN KEY (client_id)
      REFERENCES client (id) 
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE sale_product
(
  id bigint NOT NULL,
  data_alteracao timestamp ,
  data_criacao timestamp ,
  quantity numeric(19,2),
  product_id bigint,
  sale_id bigint,
  CONSTRAINT sale_product_pkey PRIMARY KEY (id),
  CONSTRAINT fk4dtibi1vwxkx8gjs59nhp0cnq FOREIGN KEY (sale_id)
      REFERENCES sale (id) 
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkrtwiisrmdqeslt86pacdwwn1o FOREIGN KEY (product_id)
      REFERENCES product (id) 
      ON UPDATE NO ACTION ON DELETE NO ACTION
);