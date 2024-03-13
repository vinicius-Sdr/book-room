-- Tabela para armazenar informações sobre as localidades
CREATE TABLE book_room_quarto.localidade (
                                             id SERIAL PRIMARY KEY,  -- Identificador único da localidade
                                             nome VARCHAR(255) UNIQUE NOT NULL,  -- Nome da localidade
                                             rua_av VARCHAR(255) NOT NULL,  -- Nome da rua ou avenida
                                             numero INTEGER, -- Número do endereço (opcional)
                                             cep CHAR(9) NOT NULL CHECK (cep ~ '^\d{5}-\d{3}$'), -- CEP no formato '00000-000'
                                             cidade VARCHAR(100) NOT NULL,  -- Nome da cidade
                                             estado VARCHAR(100) NOT NULL,  -- Nome do estado
                                             data_inclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data e hora de inclusão do registro
                                             data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- Data e hora da última alteração do registro
);

COMMENT ON TABLE book_room_quarto.localidade IS 'Tabela para armazenar informações sobre as localidades';

COMMENT ON COLUMN book_room_quarto.localidade.id IS 'Identificador único da localidade';
COMMENT ON COLUMN book_room_quarto.localidade.nome IS 'Nome da localidade';
COMMENT ON COLUMN book_room_quarto.localidade.rua_av IS 'Nome da rua ou avenida';
COMMENT ON COLUMN book_room_quarto.localidade.numero IS 'Número do endereço (opcional)';
COMMENT ON COLUMN book_room_quarto.localidade.cep IS 'CEP no formato 00000-000';
COMMENT ON COLUMN book_room_quarto.localidade.cidade IS 'Nome da cidade';
COMMENT ON COLUMN book_room_quarto.localidade.estado IS 'Nome do estado';
COMMENT ON COLUMN book_room_quarto.localidade.data_inclusao IS 'Data e hora de inclusão do registro';
COMMENT ON COLUMN book_room_quarto.localidade.data_alteracao IS 'Data e hora da última alteração do registro';

-- Tabela para armazenar informações sobre os prédios
CREATE TABLE book_room_quarto.predio (
                                         id SERIAL PRIMARY KEY,  -- Identificador único do prédio
                                         id_localidade INTEGER REFERENCES book_room_quarto.localidade(id) NOT NULL,  -- Localidade a qual o prédio pertence
                                         nome VARCHAR(255) NOT NULL,  -- Nome do prédio
                                         data_inclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data e hora de inclusão do registro
                                         data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data e hora da última alteração do registro
                                         CONSTRAINT fk_predio_localidade FOREIGN KEY (id_localidade) REFERENCES book_room_quarto.localidade(id),
                                         UNIQUE (id_localidade, nome)  -- Garante que cada prédio tenha um nome único dentro de uma localidade
);

COMMENT ON TABLE book_room_quarto.predio IS 'Tabela para armazenar informações sobre os prédios';

COMMENT ON COLUMN book_room_quarto.predio.id IS 'Identificador único do prédio';
COMMENT ON COLUMN book_room_quarto.predio.id_localidade IS 'Localidade a qual o prédio pertence';
COMMENT ON COLUMN book_room_quarto.predio.nome IS 'Nome do prédio';
COMMENT ON COLUMN book_room_quarto.predio.data_inclusao IS 'Data e hora de inclusão do registro';
COMMENT ON COLUMN book_room_quarto.predio.data_alteracao IS 'Data e hora da última alteração do registro';

-- Tabela para armazenar informações sobre os componentes do banheiro
CREATE TABLE book_room_quarto.componente_banheiro (
                                                      id SERIAL PRIMARY KEY,  -- Identificador único do componente de banheiro
                                                      nome VARCHAR(255) UNIQUE NOT NULL,  -- Nome do componente de banheiro
                                                      tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('Luxo', 'Simples')),  -- Tipo do componente de banheiro (Luxo ou Simples)
                                                      data_inclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data e hora de inclusão do registro
                                                      data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- Data e hora da última alteração do registro
);

COMMENT ON TABLE book_room_quarto.componente_banheiro IS 'Tabela para armazenar informações sobre os componentes do banheiro';

COMMENT ON COLUMN book_room_quarto.componente_banheiro.id IS 'Identificador único do componente de banheiro';
COMMENT ON COLUMN book_room_quarto.componente_banheiro.nome IS 'Nome do componente de banheiro';
COMMENT ON COLUMN book_room_quarto.componente_banheiro.tipo IS 'Tipo do componente de banheiro (Luxo ou Simples)';
COMMENT ON COLUMN book_room_quarto.componente_banheiro.data_inclusao IS 'Data e hora de inclusão do registro';
COMMENT ON COLUMN book_room_quarto.componente_banheiro.data_alteracao IS 'Data e hora da última alteração do registro';

-- Tabela para armazenar informações sobre os quartos
CREATE TABLE book_room_quarto.quarto (
                                         id SERIAL PRIMARY KEY,  -- Identificador único do quarto
                                         id_predio INTEGER REFERENCES book_room_quarto.predio(id) NOT NULL,  -- Prédio ao qual o quarto pertence
                                         id_localidade INTEGER REFERENCES book_room_quarto.localidade(id) NOT NULL,  -- Localidade na qual o quarto está situado
                                         tipo VARCHAR(50) NOT NULL,  -- Tipo do quarto
                                         total_pessoas INTEGER NOT NULL,  -- Capacidade total de pessoas no quarto
                                         banheiro INTEGER REFERENCES book_room_quarto.componente_banheiro(id) NOT NULL,  -- Componente de banheiro do quarto
                                         valor_diaria DECIMAL(10, 2) NOT NULL,  -- Valor da diária do quarto
                                         quantidade_quartos INTEGER NOT NULL,  -- Quantidade de quartos do mesmo tipo
                                         data_inclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data e hora de inclusão do registro
                                         data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data e hora da última alteração do registro
                                         CONSTRAINT fk_quarto_predio FOREIGN KEY (id_predio) REFERENCES book_room_quarto.predio(id),
                                         CONSTRAINT fk_quarto_localidade FOREIGN KEY (id_localidade) REFERENCES book_room_quarto.localidade(id),
                                         CONSTRAINT fk_quarto_banheiro FOREIGN KEY (banheiro) REFERENCES book_room_quarto.componente_banheiro(id),
                                         UNIQUE (id_predio, tipo)  -- Garante que cada tipo de quarto seja único dentro de um prédio
);

COMMENT ON TABLE book_room_quarto.quarto IS 'Tabela para armazenar informações sobre os quartos';

COMMENT ON COLUMN book_room_quarto.quarto.id IS 'Identificador único do quarto';
COMMENT ON COLUMN book_room_quarto.quarto.id_predio IS 'Prédio ao qual o quarto pertence';
COMMENT ON COLUMN book_room_quarto.quarto.id_localidade IS 'Localidade na qual o quarto está situado';
COMMENT ON COLUMN book_room_quarto.quarto.tipo IS 'Tipo do quarto';
COMMENT ON COLUMN book_room_quarto.quarto.total_pessoas IS 'Capacidade total de pessoas no quarto';
COMMENT ON COLUMN book_room_quarto.quarto.banheiro IS 'Componente de banheiro do quarto';
COMMENT ON COLUMN book_room_quarto.quarto.valor_diaria IS 'Valor da diária do quarto';
COMMENT ON COLUMN book_room_quarto.quarto.quantidade_quartos IS 'Quantidade de quartos do mesmo tipo';
COMMENT ON COLUMN book_room_quarto.quarto.data_inclusao IS 'Data e hora de inclusão do registro';
COMMENT ON COLUMN book_room_quarto.quarto.data_alteracao IS 'Data e hora da última alteração do registro';

-- Tabela para armazenar informações sobre as camas nos quartos
CREATE TABLE book_room_quarto.quarto_camas (
                                               id_quarto INTEGER REFERENCES book_room_quarto.quarto(id) NOT NULL,  -- Identificador do quarto
                                               tipo_cama VARCHAR(50) NOT NULL,  -- Tipo de cama
                                               quantidade INTEGER NOT NULL,  -- Quantidade de camas do mesmo tipo no quarto
                                               descricao TEXT,  -- Descrição adicional das camas
                                               PRIMARY KEY (id_quarto, tipo_cama),  -- Chave primária composta
                                               CONSTRAINT fk_quarto_camas FOREIGN KEY (id_quarto) REFERENCES book_room_quarto.quarto(id),
                                               UNIQUE (id_quarto, tipo_cama)  -- Garante que cada tipo de cama seja único dentro de um quarto
);

COMMENT ON TABLE book_room_quarto.quarto_camas IS 'Tabela para armazenar informações sobre as camas nos quartos';

COMMENT ON COLUMN book_room_quarto.quarto_camas.id_quarto IS 'Identificador do quarto';
COMMENT ON COLUMN book_room_quarto.quarto_camas.tipo_cama IS 'Tipo de cama';
COMMENT ON COLUMN book_room_quarto.quarto_camas.quantidade IS 'Quantidade de camas do mesmo tipo no quarto';
COMMENT ON COLUMN book_room_quarto.quarto_camas.descricao IS 'Descrição adicional das camas';

-- Tabela para armazenar informações sobre as amenidades
CREATE TABLE book_room_quarto.amenidades (
                                             id SERIAL PRIMARY KEY,  -- Identificador único da amenidade
                                             descricao VARCHAR(255) NOT NULL,  -- Descrição da amenidade
                                             data_inclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data e hora de inclusão do registro
                                             data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- Data e hora da última alteração do registro
);

COMMENT ON TABLE book_room_quarto.amenidades IS 'Tabela para armazenar informações sobre as amenidades';

COMMENT ON COLUMN book_room_quarto.amenidades.id IS 'Identificador único da amenidade';
COMMENT ON COLUMN book_room_quarto.amenidades.descricao IS 'Descrição da amenidade';
COMMENT ON COLUMN book_room_quarto.amenidades.data_inclusao IS 'Data e hora de inclusão do registro';
COMMENT ON COLUMN book_room_quarto.amenidades.data_alteracao IS 'Data e hora da última alteração do registro';

-- Tabela de associação entre localidades e amenidades
CREATE TABLE book_room_quarto.amenidades_localidade (
                                                        id_localidade INTEGER REFERENCES book_room_quarto.localidade(id) NOT NULL,  -- Identificador da localidade
                                                        id_amenidade INTEGER REFERENCES book_room_quarto.amenidades(id) NOT NULL,  -- Identificador da amenidade
                                                        quantidade INTEGER NOT NULL,  -- Quantidade da amenidade na localidade
                                                        data_inclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data e hora de inclusão do registro
                                                        data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data e hora da última alteração do registro
                                                        PRIMARY KEY (id_localidade, id_amenidade),  -- Chave primária composta
                                                        CONSTRAINT fk_amenidades_localidade FOREIGN KEY (id_localidade) REFERENCES book_room_quarto.localidade(id),
                                                        CONSTRAINT fk_amenidades FOREIGN KEY (id_amenidade) REFERENCES book_room_quarto.amenidades(id)
);

COMMENT ON TABLE book_room_quarto.amenidades_localidade IS 'Tabela de associação entre localidades e amenidades';

COMMENT ON COLUMN book_room_quarto.amenidades_localidade.id_localidade IS 'Identificador da localidade';
COMMENT ON COLUMN book_room_quarto.amenidades_localidade.id_amenidade IS 'Identificador da amenidade';
COMMENT ON COLUMN book_room_quarto.amenidades_localidade.quantidade IS 'Quantidade da amenidade na localidade';
COMMENT ON COLUMN book_room_quarto.amenidades_localidade.data_inclusao IS 'Data e hora de inclusão do registro';
COMMENT ON COLUMN book_room_quarto.amenidades_localidade.data_alteracao IS 'Data e hora da última alteração do registro';
