CREATE TABLE review(
id mediumint auto_increment not null,
description varchar(200) not null,
created_at timestamp default current_timestamp,
product_id mediumint not null,
CONSTRAINT review_pk PRIMARY KEY (id),
CONSTRAINT review_product_fk FOREIGN KEY (product_id) REFERENCES product(id)
);