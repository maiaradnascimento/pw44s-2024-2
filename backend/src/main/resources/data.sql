-- Criação da tabela TB_CATEGORIA
CREATE TABLE IF NOT EXISTS TB_CATEGORIA (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            nome VARCHAR(50) NOT NULL
    );

-- Criação da tabela TB_USER
CREATE TABLE IF NOT EXISTS TB_USER (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       display_name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE
    );

-- Criação da tabela TB_ENDERECO
CREATE TABLE IF NOT EXISTS TB_ENDERECO (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           cep VARCHAR(10) NOT NULL,
    complemento VARCHAR(100),
    logradouro VARCHAR(200) NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES TB_USER(id)
    );

-- Criação da tabela TB_PRODUTO
CREATE TABLE IF NOT EXISTS TB_PRODUTO (
                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          descricao VARCHAR(255) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    url_imagem VARCHAR(255),
    categoria_id BIGINT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES TB_CATEGORIA(id)
    );

-- Criação da tabela TB_PEDIDO
CREATE TABLE IF NOT EXISTS TB_PEDIDO (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                         usuario_id BIGINT NOT NULL,
                                         FOREIGN KEY (usuario_id) REFERENCES TB_USER(id)
    );

-- Criação da tabela TB_ITEM_PEDIDO
CREATE TABLE IF NOT EXISTS TB_ITEM_PEDIDO (
                                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                              quantidade INT NOT NULL,
                                              produto_id BIGINT NOT NULL,
                                              pedido_id BIGINT NOT NULL,
                                              FOREIGN KEY (produto_id) REFERENCES TB_PRODUTO(id),
    FOREIGN KEY (pedido_id) REFERENCES TB_PEDIDO(id)
    );


-- Índices para TB_USER
CREATE INDEX IF NOT EXISTS idx_tb_user_username ON TB_USER(username);
CREATE INDEX IF NOT EXISTS idx_tb_user_display_name ON TB_USER(display_name);

-- Índices para TB_ENDERECO
CREATE INDEX IF NOT EXISTS idx_tb_endereco_usuario_id ON TB_ENDERECO(usuario_id);

-- Índices para TB_PRODUTO
CREATE INDEX IF NOT EXISTS idx_tb_produto_categoria_id ON TB_PRODUTO(categoria_id);
CREATE INDEX IF NOT EXISTS idx_tb_produto_nome ON TB_PRODUTO(nome);

-- Índices para TB_PEDIDO
CREATE INDEX IF NOT EXISTS idx_tb_pedido_usuario_id ON TB_PEDIDO(usuario_id);

-- Índices para TB_ITEM_PEDIDO
CREATE INDEX IF NOT EXISTS idx_tb_item_pedido_produto_id ON TB_ITEM_PEDIDO(produto_id);
CREATE INDEX IF NOT EXISTS idx_tb_item_pedido_pedido_id ON TB_ITEM_PEDIDO(pedido_id);


-- Inserção de dados em TB_CATEGORIA
INSERT INTO TB_CATEGORIA (nome) VALUES ('Eletrônicos');
INSERT INTO TB_CATEGORIA (nome) VALUES ('Roupas');
INSERT INTO TB_CATEGORIA (nome) VALUES ('Alimentos');
INSERT INTO TB_CATEGORIA (nome) VALUES ('Beleza');

-- Inserção de dados em TB_USER
INSERT INTO TB_USER (display_name, password, username)
VALUES ('Admin', '$2b$12$IJc.FhJEyEW6nDJD2d2apuhh/Nfo.s3Xbc162/Qi6JTG/LGduLZw6', 'admin');
INSERT INTO TB_USER (display_name, password, username)
VALUES ('Admin2', '$2b$12$IJc.FhJEyEW6nDJD2d2apuhh/Nfo.s3Xbc162/Qi6JTG/LGduLZw6', 'admin2');

-- Inserção de dados em TB_ENDERECO
INSERT INTO TB_ENDERECO (cep, complemento, logradouro, usuario_id)
VALUES ('12345-678', 'Apto 101', 'Rua A, 123', 1);
INSERT INTO TB_ENDERECO (cep, complemento, logradouro, usuario_id)
VALUES ('87654-321', 'Casa 5', 'Rua B, 456', 2);

-- Inserção de dados em TB_PRODUTO
INSERT INTO TB_PRODUTO (descricao, nome, preco, url_imagem, categoria_id)
VALUES ('Smartphone com 128GB de armazenamento', 'Smartphone X', 1500.00, 'https://example.com/smartphone.jpg', 1);
INSERT INTO TB_PRODUTO (descricao, nome, preco, url_imagem, categoria_id)
VALUES ('Camiseta de algodão', 'Camiseta Básica', 49.90, 'https://example.com/camiseta.jpg', 2);

-- Inserção de dados em TB_PEDIDO
INSERT INTO TB_PEDIDO (usuario_id) VALUES (1);
INSERT INTO TB_PEDIDO (usuario_id) VALUES (2);

-- Inserção de dados em TB_ITEM_PEDIDO
INSERT INTO TB_ITEM_PEDIDO (quantidade, produto_id, pedido_id)
VALUES (2, 1, 1);  -- 2 unidades de 'Smartphone X' no pedido 1
INSERT INTO TB_ITEM_PEDIDO (quantidade, produto_id, pedido_id)
VALUES (3, 2, 2);  -- 3 unidades de 'Camiseta Básica' no pedido 2
