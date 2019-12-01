CREATE TABLE review(
id mediumint auto_increment not null,
description varchar(200) not null,
created_at timestamp default current_timestamp,
CONSTRAINT review_pk PRIMARY KEY (id)
);