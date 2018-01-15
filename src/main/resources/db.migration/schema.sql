DROP TABLE IF EXISTS "AUTO_PART";
CREATE TABLE "AUTO_PART" (
  ID       BIGINT      NOT NULL PRIMARY KEY,
  ARTICULE VARCHAR(30) NOT NULL,
  NAME     VARCHAR(50) NOT NULL,
  TYPE     BIGINT      NOT NULL,
  PRICE    DECIMAL     NOT NULL
);
