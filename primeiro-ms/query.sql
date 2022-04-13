-- CRIAR TABELA
CREATE TABLE PROFESSORES (
 NOME VARCHAR(255),
 SOBRENOME VARCHAR (255)
);

INSERT INTO PROFESSORES 
    (NOME, SOBRENOME)
    VALUES
    ( 'Fabrizio', 'Borelli' );

SELECT NOME, SOBRENOME FROM PROFESSORES;
SELECT * FROM PROFESSORES;

SELECT NOME FROM PROFESSORES;

SELECT SOBRENOME , NOME FROM PROFESSORES;

-- INSERIR DADOS
INSERT INTO PROFESSORES 
(NOME, SOBRENOME)
VALUES 
('Nelson', 'Oliveira');

-- ALTERAR DADOS

-- UPDATE   PROFESSORES
-- SET NOME = 'João', SOBRENOME = 'Silva';

-- DELETAR DADOS
-- DELETE FROM PROFESSORES;

-- SELECIONAR DADOS ESPECÍFICOS (FILTROS) ***WHERE***

SELECT * FROM PROFESSORES 
WHERE  NOME = 'Fabrizio';


UPDATE   PROFESSORES
SET NOME = 'João', SOBRENOME = 'Silva'
WHERE  NOME = 'Fabrizio';

-- DROP TABLE PROFESSORES;

-- DROP TABLE USUARIOS;

CREATE TABLE USUARIOS (
   ID INT PRIMARY KEY AUTO_INCREMENT,
   NOME VARCHAR(255),
   EMAIL VARCHAR(255) UNIQUE
);

INSERT INTO USUARIOS 
( NOME, EMAIL)
VALUES
('Fabrizio', 'fabrizio@grandeporte.com.br');

INSERT INTO USUARIOS 
(NOME, EMAIL)
VALUES
('Nelson', 'nelson@grandeporte.com.br');

-- id , nome, cpf , rua, cep, numero
-- DROP TABLE PROFESSORES;
CREATE TABLE PROFESSORES (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  NOME VARCHAR(255),
  CPF varchar(255),
  RUA VARCHAR(255),
  CEP VARCHAR(255),
  NUMERO INT
);

INSERT INTO PROFESSORES
( NOME, CPF, RUA, CEP, NUMERO)
VALUES
( 'Fabrizio', '123456789', 'RUA X', '0325555', 3);

INSERT INTO PROFESSORES
(NOME, CPF, RUA, CEP, NUMERO)
VALUES
('Nelson', '123456666', 'RUA Y', '0312355', 89);

SELECT * FROM PROFESSORES 
WHERE RUA = 'RUA X'    AND      NUMERO = 3;

