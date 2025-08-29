-- DML (LINGUAGEM DE MANIPULACAO DE DADOS)
-- INSERT (Cadastrar)
-- UPDATE (Atualizar)
-- DELETE (Apaga)

-- OPCIONAL 
-- SET search_path TO <SCHEMA>;
-- clinica.paciente -> paciente

-- INSERT INTO <SCHEMA>, <TABELA>, (<COLUNAS>) VALUES
INSERT INTO clinica.medico(nome, especialidade, crm) VALUES 
('Ismael', 'Ortopedia', '123456'),
('Ariel', 'Cardiologista', '654321')

-- DQL (LINGUAGEM DE CONSULTA DE DADOS)
-- SELECT 
-- SELECT <QUAIS_COLUNAS> FROM <SCHEMA>.<TABELA>
SELECT * FROM clinica.medico;

INSERT INTO clinica.paciente(nome, idade, data_nascimento) VALUES
('Carla', 21, '2003-12-04')

SELECT * FROM clinica.paciente;

INSERT INTO clinica.clinica(nome, descricao, endereco) VALUES 
('Clinica de Sao Caetano', 'A clinica do ABC', 'Rua niteroi')

SELECT * FROM clinica.clinica; 

INSERT INTO clinica.consulta(data, valor, id_medico, id_clinica, id_paciente) VALUES
('2025-08-28 09:30:00-03', 350.75, 1, 1, 1)

SELECT * FROM clinica.consulta;


-- UPDATE 
UPDATE clinica.consulta SET valor = 250.500 WHERE id_consulta = 1; 

UPDATE clinica.consulta 
SET valor = 530
WHERE valor > 500 AND valor < 1000;

-- DELETE
DELETE FROM clinica.medico
WHERE nome = 'Ariel';





-- Todos SELECTs
SELECT * FROM clinica.clinica; 

SELECT * FROM clinica.paciente;
SELECT * FROM clinica.consulta;






