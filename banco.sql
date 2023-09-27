-- Database: todo

 --DROP DATABASE IF EXISTS todo;

CREATE DATABASE todo
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	
	
		CREATE SCHEMA task;
		
CREATE TABLE task.tarefa
(
	id bigserial NOT NULL PRIMARY KEY,
	nome character varying(150) NOT NULL,
	status character varying(10) CHECK (status IN ('PENDENTE', 'CONCLUIDO')) NOT NULL,
	observ character varying(200),
	data_criacao date DEFAULT NOW(),
	data_atualiza date DEFAULT NOW()	
);
