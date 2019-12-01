CREATE TABLE product(
id mediumint auto_increment not null,
product_name varchar(200) not null,
created_at timestamp default current_timestamp,
review_id mediumint not null,
CONSTRAINT product_pk PRIMARY KEY (id),
CONSTRAINT product_review_fk FOREIGN KEY (review_id) REFERENCES review(id)
);