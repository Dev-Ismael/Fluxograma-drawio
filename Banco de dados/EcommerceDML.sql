
-- DML (LINGUAGEM DE MANIPULACAO DE DADOS)
-- INSERT (Cadastrar)
-- UPDATE (Atualizar)
-- DELETE (Apaga)

-- OPCIONAL 
-- SET search_path TO <SCHEMA>;
-- clinica.paciente -> paciente

-- INSERT INTO <SCHEMA>, <TABELA>, (<COLUNAS>) VALUES
INSERT INTO ecommerce.cliente(nome_completo, email, senha, telefone, data_cadastro) VALUES 
('Ismael', 'ismael@gmail.com', 'abc123', '11912345678', '2025-08-28'),
('Leo', 'leo@gmail.com', 'def456', '11987654321', '2025-08-28')

INSERT INTO ecommerce.pedido(id_cliente, data_pedido, valor_total, status) VALUES 
( 1, '01/09/2025', 100, 'Andamento')


-- SELECT
SELECT nome, idade, cpf
FROM clinica.paciente;

SELECT * FROM clinica.medico;

-- JOIN(Juntar)
-- Com o JOIN posso juntar tabelas
-- Utilizando a chave Estrangeira

-- Listar, Data, Valor, Nome do medico
SELECT 
	data,
	valor,
	nome
FROM clinica.consulta AS cs
JOIN 
	clinica.medico AS med
ON clinica.consulta.id_medico = 
med.id_medico



-- EXERCICIOS ECOMMERCE
SELECT  ec.nome_completo,
		ep.id_pedido
FROM ecommerce.cliente AS ec
JOIN ecommerce.pedido AS ep
ON ep.id_cliente = ec.id_cliente

		
