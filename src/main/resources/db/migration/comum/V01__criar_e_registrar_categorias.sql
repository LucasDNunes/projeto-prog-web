# CREATE DATABASE pweb;

CREATE TABLE categoria (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria (nome) values ('Informaíca');
INSERT INTO categoria (nome) values ('Escritório');
INSERT INTO categoria (nome) values ('Cama mesa e banho');
INSERT INTO categoria (nome) values ('Eletrônicos');
INSERT INTO categoria (nome) values ('Jardinagem');
INSERT INTO categoria (nome) values ('Decoração');
INSERT INTO categoria (nome) values ('Perfumaria');
INSERT INTO categoria (nome) values ('Lazer');
INSERT INTO categoria (nome) values ('Alimentação');
INSERT INTO categoria (nome) values ('Supermercado');
INSERT INTO categoria (nome) values ('Farmácia');
INSERT INTO categoria (nome) values ('Outros');