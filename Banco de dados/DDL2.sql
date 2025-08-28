-- Criar esquema Ecommerce
CREATE SCHEMA ecommerce;

-- Criar tabela
CREATE TABLE ecommerce.cliente(
	id_cliente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome_completo TEXT NOT NULL, 
	email TEXT NOT NULL,
	senha TEXT NOT NULL,
	telefone TEXT NOT NULL,
	data_cadastro TIMESTAMPTZ NOT NULL
);

CREATE TABLE ecommerce.pedido(
	id_pedido INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	id_cliente INT NOT NULL,
	data_pedido TIMESTAMPTZ NOT NULL,
	valor_total NUMERIC(10,4) NOT NULL,
	status TEXT NOT NULL,

	FOREIGN KEY(id_cliente)
	REFERENCES ecommerce.cliente(id_cliente)	
);

CREATE TABLE ecommerce.pagamento(
	id_pagamento INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	id_pedido INT NOT NULL,
	forma_pagamento TEXT NOT NULL,
	status TEXT NOT NULL,
	data_pagamento TIMESTAMPTZ NOT NULL,

	FOREIGN KEY(id_pedido) 
	REFERENCES ecommerce.pedido(id_pedido)
);

CREATE TABLE ecommerce.produto(
	id_produto INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome_produto TEXT NOT NULL,
	descricao TEXT NOT NULL,
	preco NUMERIC(10,2) NOT NULL,
	estoque_disponivel INT NOT NULL,
	imagem_url TEXT NOT NULL
);

CREATE TABLE ecommerce.item_do_pedido(
	id_item INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	id_pedido INT NOT NULL,
	id_produto INT NOT NULL,
	quantidade INT NOT NULL,

	FOREIGN KEY(id_pedido)
	REFERENCES ecommerce.pedido(id_pedido),
	FOREIGN KEY(id_produto)
	REFERENCES ecommerce.produto(id_produto)
);





