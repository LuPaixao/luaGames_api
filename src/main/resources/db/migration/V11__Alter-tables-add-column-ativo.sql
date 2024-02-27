ALTER TABLE console add ativo tinyint;
UPDATE console SET ativo = 1;

ALTER TABLE jogo add ativo tinyint;
UPDATE jogo SET ativo = 1;