CREATE TABLE IF NOT EXISTS "BOOK"
(
    "ID"
        INTEGER
        PRIMARY
            KEY
        AUTO_INCREMENT,
    "NAME"
        VARCHAR(50) NOT NULL,
    "PRICE"
        int
    );
insert into BOOK (NAME, PRICE)
values ('Harry Potter', 10);

insert into BOOK (NAME, PRICE)
values ('Herr Der Ringe', 20);