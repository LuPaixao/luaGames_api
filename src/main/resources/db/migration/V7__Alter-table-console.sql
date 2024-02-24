ALTER TABLE console
ADD id_jogo BIGINT;

ALTER TABLE console
ADD FOREIGN KEY (id_jogo) REFERENCES jogo (id);
