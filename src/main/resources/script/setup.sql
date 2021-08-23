--CRIAÇÃO TABELA EDITORAS
CREATE TABLE editoras(
                         id SERIAL NOT NULL,
                         nome VARCHAR(250) NOT NULL,
                         PRIMARY KEY(id)
);

--CRIAÇÃO TABELA LIVROS
CREATE TABLE livros(
                       id SERIAL NOT NULL,
                       nome VARCHAR(100) NOT NULL,
                       descricao VARCHAR(250) NOT NULL,
                       id_editora INT NOT NULL,
                       PRIMARY KEY(id)
);

--ADICIONANDO CHAVE ESTRANGEIRA DE EDITORA NA TABELA LIVROS
ALTER TABLE livros ADD CONSTRAINT fk_livro_editora FOREIGN KEY (id_editora) REFERENCES editoras(id);

--CRIANDO TABELA AUTORES
CREATE TABLE autores(
                        id SERIAL NOT NULL,
                        nome VARCHAR(250) NOT NULL,
                        PRIMARY KEY(id)
);

--CRIANDO TABELA ASSOCIATIVA DE AUTORES E LIVROS
CREATE TABLE autor_livro(
                            id SERIAL NOT NULL,
                            autor_id INT NOT NULL,
                            livro_id INT NOT NULL,
                            PRIMARY KEY(autor_id, livro_id)
);


-- ADICIONA AS CHAVES ESTRANGEIRAS DE EDITORA E LIVRO NA TABELA AUTOR_LIVRO
ALTER TABLE autor_livro ADD CONSTRAINT fk_autor_livro_autor FOREIGN KEY (autor_id) REFERENCES autores(id);
ALTER TABLE autor_livro ADD CONSTRAINT fk_autor_livro_livro FOREIGN KEY (livro_id) REFERENCES livros(id);

--INSERINDO EDITORAS
INSERT INTO editoras(nome) VALUES ('HarperCollins');
INSERT INTO editoras(nome) VALUES ('Nova Fronteira');
INSERT INTO editoras(nome) VALUES ('Antofagica');
INSERT INTO editoras(nome) VALUES ('Alta Books');


--INSERINDO AUTORES
INSERT INTO autores(nome) VALUES ('Agatha Cristie');
INSERT INTO autores(nome) VALUES ('Monteiro Lobato');
INSERT INTO autores(nome) VALUES ('Vinicius de Moraes');
INSERT INTO autores(nome) VALUES ('Bert Bates');



