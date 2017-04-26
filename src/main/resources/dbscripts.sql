CREATE TABLE article (
    id bigserial NOT NULL PRIMARY KEY,
    Product character(20),
    Quantity int

)

INSERT INTO article(Product, Quantity) VALUES ('rosii', 2);
INSERT INTO article(Product, Quantity) VALUES ('mere', 2);
INSERT INTO article(Product, Quantity) VALUES ('pere', 2);
INSERT INTO article(Product, Quantity) VALUES ('caise', 2);