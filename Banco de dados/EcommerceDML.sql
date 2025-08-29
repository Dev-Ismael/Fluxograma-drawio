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

