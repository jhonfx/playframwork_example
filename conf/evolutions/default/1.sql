# ---!Ups
CREATE TABLE post_table (
  title VARCHAR(255),
   comment VARCHAR(255),
   autor VARCHAR(255)
);
INSERT INTO post_table
  (title, comment, autor)
VALUES
  ('el atico',' una historia del los secretos que guarda el atico','stephen spielberg'),
  ('la mascara',' historia de la humano que se pone una mascara',' el ruso');
# --- !Downs
DROP TABLE post_table;