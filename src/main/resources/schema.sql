---DELETE TABLE---
DROP TABLE IF EXISTS "book_author";
DROP TABLE IF EXISTS "book";
DROP TABLE IF EXISTS "publisher";
DROP TABLE IF EXISTS "author";

---CREATE TABLE---
CREATE TABLE "author"
(
    "id"      serial NOT NULL,
    "created" DATE   NOT NULL,
    "updated" DATE,
    "name"    TEXT   NOT NULL,
    CONSTRAINT "author_pk" PRIMARY KEY ("id")
) WITH (
      OIDS = FALSE
      );


CREATE TABLE "publisher"
(
    "id"      serial NOT NULL,
    "created" DATE   NOT NULL,
    "updated" DATE,
    "name"    TEXT   NOT NULL,
    CONSTRAINT "publisher_pk" PRIMARY KEY ("id")
) WITH (
      OIDS = FALSE
      );


CREATE TABLE "book"
(
    "id"              serial       NOT NULL,
    "created"         DATE         NOT NULL,
    "updated"         DATE,
    "name"            TEXT         NOT NULL,
    "description"     TEXT         NOT NULL,
    "publish_date"    DATE,
    "isbn"            varchar(255) NOT NULL,
    "language"        varchar(255),
    "image_url"       TEXT,
    "fk_publisher_id" bigint       NOT NULL,
    CONSTRAINT "book_pk" PRIMARY KEY ("id")
) WITH (
      OIDS = FALSE
      );
ALTER TABLE "book"
    ADD CONSTRAINT "book_fk0" FOREIGN KEY ("fk_publisher_id") REFERENCES "publisher" ("id");


CREATE TABLE "book_author"
(
    "fk_book_id"   bigint NOT NULL,
    "fk_author_id" bigint NOT NULL
) WITH (
      OIDS = FALSE
      );
ALTER TABLE "book_author"
    ADD CONSTRAINT "book_author_fk0" FOREIGN KEY ("fk_book_id") REFERENCES "book" ("id");
ALTER TABLE "book_author"
    ADD CONSTRAINT "book_author_fk1" FOREIGN KEY ("fk_author_id") REFERENCES "author" ("id");