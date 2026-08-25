-- Cria o banco de dados e a tabela de produtos

CREATE DATABASE IF NOT EXISTS java
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_general_ci;

USE java;

CREATE TABLE IF NOT EXISTS produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DOUBLE NOT NULL,
    quantidade INT NOT NULL
);

CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

-- Exemplo de dados para teste (opcional)
INSERT INTO produtos (nome, preco, quantidade) VALUES
    ('Arroz', 25.90, 50),
    ('Feijão', 18.50, 30),
    ('Notebook', 3500.00, 5);
