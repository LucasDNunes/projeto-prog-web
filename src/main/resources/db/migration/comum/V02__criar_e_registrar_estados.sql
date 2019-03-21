
CREATE TABLE estado (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	uf VARCHAR(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO estado (nome, uf) values ('Acre', 'AC');
INSERT INTO estado (nome, uf) values ('Alagoas', 'AL');
INSERT INTO estado (nome, uf) values ('Amapá', 'AP');
INSERT INTO estado (nome, uf) values ('Amazonas', 'AM');
INSERT INTO estado (nome, uf) values ('Bahia', 'BA');
INSERT INTO estado (nome, uf) values ('Ceará', 'CE');
INSERT INTO estado (nome, uf) values ('Distrito Federal', 'DF');
INSERT INTO estado (nome, uf) values ('Espírito Santo', 'ES');
INSERT INTO estado (nome, uf) values ('Goiás', 'GO');
INSERT INTO estado (nome, uf) values ('Maranhão', 'MA');
INSERT INTO estado (nome, uf) values ('Mato Grosso', 'MT');
INSERT INTO estado (nome, uf) values ('Mato Grosso do Sul', 'MS');
INSERT INTO estado (nome, uf) values ('Minas Gerais', 'MG');
INSERT INTO estado (nome, uf) values ('Pará', 'PA');
INSERT INTO estado (nome, uf) values ('Paraíba', 'PB');
INSERT INTO estado (nome, uf) values ('Paraná', 'PR');
INSERT INTO estado (nome, uf) values ('Pernambuco', 'PE');
INSERT INTO estado (nome, uf) values ('Piauí', 'PI');
INSERT INTO estado (nome, uf) values ('Rio de Janeiro', 'RJ');
INSERT INTO estado (nome, uf) values ('Rio Grande do Norte', 'RN');
INSERT INTO estado (nome, uf) values ('Rio Grande do Sul', 'RS');
INSERT INTO estado (nome, uf) values ('Rondônia', 'RO');
INSERT INTO estado (nome, uf) values ('Roraima', 'RR');
INSERT INTO estado (nome, uf) values ('Santa Catarina', 'SC');
INSERT INTO estado (nome, uf) values ('São Paulo', 'SP');
INSERT INTO estado (nome, uf) values ('Sergipe', 'SE');
INSERT INTO estado (nome, uf) values ('Tocantins', 'TO');
