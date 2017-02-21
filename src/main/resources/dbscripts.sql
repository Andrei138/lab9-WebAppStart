CREATE TABLE article (
 +    id bigserial NOT NULL PRIMARY KEY,
 +    link character(300) NOT NULL,
 +    domain character(40),
 +    summary character(120),
 +    date DATE NOT NULL default CURRENT_DATE);
 );

INSERT INTO article( link, domain, summary, date) VALUES ('ardei', '7')