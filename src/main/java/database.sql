-- Criando a tabela para a classe Material
CREATE TABLE materiais (
                           id SERIAL PRIMARY KEY,
                           nome VARCHAR(100) NOT NULL,
                           preco_quilo DECIMAL(10, 2) NOT NULL
);

-- Inserindo os materiais iniciais
INSERT INTO materiais (nome, preco_quilo) VALUES ('Latinha', 6.50);
INSERT INTO materiais (nome, preco_quilo) VALUES ('Cobre', 35.00);

-- Criando a tabela para a classe Compra
CREATE TABLE compras (
                         id SERIAL PRIMARY KEY,
                         material_id INTEGER REFERENCES materiais(id),
                         peso DECIMAL(10, 3) NOT NULL,
                         valor_total DECIMAL(10, 2) NOT NULL,
                         status VARCHAR(20) NOT NULL
);