-- Conceder permissões para criar esquemas
-- GRANT CREATE ON DATABASE postgres TO postgres;

-- Tabela para armazenar informações de usuários no esquema 'BOOK_ROOM'
CREATE TABLE CLIENT (
    id               SERIAL PRIMARY KEY,   -- Chave primária autoincrementada para identificação única do usuário
    client_name         VARCHAR(100) NOT NULL, -- Nome de usuário com no máximo 100 caracteres
    BIRTH_DATE            VARCHAR(200) NOT NULL, -- Senha do usuário com no máximo 200 caracteres
    COUNTRY     VARCHAR(255) NOT NULL,    -- Data e hora de criação do registro
    CPF VARCHAR(255),              -- Data e hora da última modificação do registro
    PASSPORT       VARCHAR(255),           -- Nome do usuário ou sistema que criou o registro
    ADDRESS   VARCHAR(255) NOT NULL,           -- Nome do usuário ou sistema que modificou o registro
    CELLPHONE   VARCHAR(255) NOT NULL,
    EMAIL       VARCHAR(255) NOT NULL

    -- Adicionar índices
    --CONSTRAINT idx_cliente_nome UNIQUE (NAME)
);


