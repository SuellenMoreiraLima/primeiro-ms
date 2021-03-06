;             
CREATE USER IF NOT EXISTS "SA" SALT '5d963b64d0ed2c07' HASH '4adde7f85afa6747fada254f8a469a5120bd2d502e5adff6680149c136111d71' ADMIN;         
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_69DCB73B_EC90_47DB_9E97_202CD813791D" START WITH 4 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_125C3BCD_E3B2_425A_8A50_962CB4998BB4" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_60F31613_36A4_4445_8874_9BA19FEEA9D2" START WITH 4 BELONGS_TO_TABLE;
CREATE CACHED TABLE "PUBLIC"."PROFESSORES"(
    "ID" INT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_60F31613_36A4_4445_8874_9BA19FEEA9D2" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_60F31613_36A4_4445_8874_9BA19FEEA9D2",
    "NOME" VARCHAR(255),
    "CPF" VARCHAR(255),
    "RUA" VARCHAR(255),
    "CEP" VARCHAR(255),
    "NUMERO" INT
);
ALTER TABLE "PUBLIC"."PROFESSORES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C" PRIMARY KEY("ID");  
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.PROFESSORES;             
INSERT INTO "PUBLIC"."PROFESSORES" VALUES
(1, 'Fabrizio', '123456789', 'RUA X', '0325555', 3),
(2, 'Nelson', '123456666', 'RUA Y', '0312355', 89);          
CREATE CACHED TABLE "PUBLIC"."USUARIOS"(
    "ID" INT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_69DCB73B_EC90_47DB_9E97_202CD813791D" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_69DCB73B_EC90_47DB_9E97_202CD813791D",
    "NOME" VARCHAR(255),
    "EMAIL" VARCHAR(255)
);      
ALTER TABLE "PUBLIC"."USUARIOS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3" PRIMARY KEY("ID");     
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.USUARIOS;
INSERT INTO "PUBLIC"."USUARIOS" VALUES
(1, 'Fabrizio', 'fabrizio@grandeporte.com.br'),
(2, 'Suellen', 'suellen@gmailcom'),
(3, 'Caio Cezar', 'caio@gmail.com');            
CREATE CACHED TABLE "PUBLIC"."VENDAS"(
    "ID" INT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_125C3BCD_E3B2_425A_8A50_962CB4998BB4" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_125C3BCD_E3B2_425A_8A50_962CB4998BB4",
    "VALOR_TOTAL" NUMERIC(5, 2),
    "USUARIO_ID" INT
);    
ALTER TABLE "PUBLIC"."VENDAS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9" PRIMARY KEY("ID");       
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.VENDAS;  
ALTER TABLE "PUBLIC"."VENDAS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_96" FOREIGN KEY("USUARIO_ID") REFERENCES "PUBLIC"."USUARIOS"("ID") NOCHECK; 
