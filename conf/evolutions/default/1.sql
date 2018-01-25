# ---!Ups
CREATE TABLE post_table (
  title VARCHAR(255),
   comment VARCHAR(255),
   autor VARCHAR(255)
);
INSERT INTO post_table (title, comment, autor) VALUES ('el atico',' una historia del los secretos que guarda el atico','stephen spielberg');
INSERT INTO post_table (title, comment, autor) VALUES ('la mascara',' historia de la humano que se pone una mascara',' el ruso');
INSERT INTO post_table (title, comment, autor) VALUES ('los horns de hittler',' Horror en el alemania nazi',' un loco demende');
INSERT INTO post_table (title, comment, autor) VALUES ('la fortaleza',' Una historia de computadoras y ingenieros locos',' Dan Brown');
# --- !Downs
DROP TABLE post_table;