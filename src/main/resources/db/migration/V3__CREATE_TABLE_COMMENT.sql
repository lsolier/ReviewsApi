CREATE TABLE comment(
id mediumint auto_increment not null,
description varchar(200) not null,
created_at timestamp default current_timestamp,
review_id mediumint not null,
CONSTRAINT comment_pk PRIMARY KEY (id),
CONSTRAINT comment_review_fk FOREIGN KEY (review_id) REFERENCES review(id)
);