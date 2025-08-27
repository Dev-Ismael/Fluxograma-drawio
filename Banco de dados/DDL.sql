-- Comentario ou assim /*   */

-- DDL - Criar - Create (Schema, tabela)
CREATE SCHEMA clinica;

-- CREATE TABLE <SCHEMA>.<NOME_DA_TABELA>
CREATE TABLE clinica.medico(
	-- Informar Coluna
	-- NOME_DA_COLUNA TIPO_DE_DADO
	-- PRIMARY KEY - CHAVE PRIMARIA
	-- GENERATE ALWAYS AS IDENTITY - A CHAVE PRIMARIA
	-- e CRIADA AUTOMATICAMENTE

	id_medico INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	crm TEXT NOT NULL,
	especialidade TEXT NOT NULL
);

CREATE TABLE clinica.paciente(
	id_paciente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	idade INT NOT NULL,
	data_nascimento DATE NOT NULL
);

CREATE TABLE clinica.clinica(
	id_clinica INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	descricao TEXT NOT NULL,
	endereco TEXT
);

CREATE TABLE clinica.consulta(
	id_consulta INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	data TIMESTAMPTZ NOT NULL,
	valor NUMERIC (10,4),
	-- Chave secundaria - Maneira extensa
	id_medico INT NOT NULL,
	FOREIGN KEY(id_medico)
	REFERENCES clinica.medico(id_medico),
   	-- Maneira Abreviada
	id_clinica INT NOT NULL REFERENCES clinica.clinica(id_clinica),
	-- MANEIRA EXTENSA
	id_paciente INT NOT NULL,
	FOREIGN KEY(id_paciente)
	REFERENCES clinica.paciente(id_paciente)  
); 

-- APAGAR TABELA - DROP
DROP TABLE clinica.consulta;
DROP TABLE clinica.clinica;
DROP TABLE clinica.paciente;
DROP TABLE clinica.medico;























