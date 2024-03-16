--liquibase formatted sql
--context !test
--preconditions onFail:MARK_RAN onError:MARK_RAN

-- Conceder permissões para criar tabelas no esquema
GRANT CREATE ON SCHEMA BOOK_ROOM_QUARTO TO POSTGRES;