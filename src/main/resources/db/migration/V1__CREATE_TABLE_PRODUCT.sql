CREATE TABLE product(
id mediumint auto_increment not null,
product_name varchar(200) not null,
created_at timestamp default current_timestamp,
CONSTRAINT product_pk PRIMARY KEY (id)
);