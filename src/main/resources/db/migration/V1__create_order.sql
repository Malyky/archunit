CREATE TABLE IF NOT EXISTS "BOOK"
(
    "ID"
    INTEGER
    PRIMARY
    KEY
    AUTO_INCREMENT,
    "NAME"
    VARCHAR
(
    50
) NOT NULL
    );
insert into "BOOK" ("NAME")
values ('test');

insert into "BOOK" ("NAME")
values ('Herr Der Ringe');