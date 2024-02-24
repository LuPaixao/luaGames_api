CREATE TABLE jogo(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  data_lancamento VARCHAR(10) NOT NULL,
  websit VARCHAR(20) NOT NULL,
  genero VARCHAR(12) NOT NULL,
  url_capa VARCHAR(255) NOT NULL,
  id_desenvolvedor BIGINT,
  FOREIGN KEY (id_desenvolvedor) REFERENCES desenvolvedor (id)
);
