-- Inserção de informações sobre componentes do banheiro
-- INSERT INTO book_room_quarto.componente_banheiro (nome, tipo)
-- VALUES ('Simples', 'Simples'),
--        ('Luxo', 'Luxo'),
--        ('Premium', 'Premium');

INSERT INTO book_room_quarto.tipo (nome, categoria)
VALUES ('Standard Simples', 'Quarto'),
       ('Standard Duplo', 'Quarto'),
       ('Luxo Simples', 'Quarto'),
       ('Luxo Duplo', 'Quarto'),
       ('Premium Simples', 'Quarto'),
       ('Premium Duplo', 'Quarto'),
       ('Simples', 'Banheiro'),
       ('Luxo', 'Banheiro'),
       ('Premium', 'Banheiro'),
       ('Queen Size','Cama'),
       ('Solteiro','Cama'),
       ('King Size','Cama')
;

-- Inserção de informações sobre amenidades
INSERT INTO book_room_quarto.amenidades (id, descricao)
VALUES (1, 'Piscina Adulto, aquecida e coberta'),
       (2, 'Piscina Adulto, não aquecida em área aberta'),
       (3, 'Piscina Infantil, aquecida e coberta'),
       (4, 'Piscina Infantil, não aquecida em área aberta'),
       (5, 'Restaurantes no estilo Self Service'),
       (6, 'Restaurante a La Carte'),
       (7, 'Área Kids, com brinquedoteca, vídeo games e biblioteca'),
       (8, 'Equipe de Entretenimento Infantil e adulto');


-- Inserção de informações sobre localidade
INSERT INTO book_room_quarto.localidade (id, nome, rua_av, numero, cep, cidade, estado)
VALUES (1, 'Fazenda da Pós Tech', 'Rua da Pós Tech', '567', '01000-002', 'Cidade da Pós Tech', 'Estado da Pós Tech');

-- Inserção de informações sobre prédio
INSERT INTO book_room_quarto.predio (id, id_localidade, nome)
VALUES (1, 1, 'Casa Principal');


-- Inserção de informações sobre amenidades em localidade
INSERT INTO book_room_quarto.amenidades_localidade (id_localidade, id_amenidade, quantidade)
VALUES (1, 1, 1), -- Piscina Adulto, aquecida e coberta
       (1, 2, 1), -- Piscina Adulto, não aquecida em área aberta
       (1, 3, 1), -- Piscina Infantil, aquecida e coberta
       (1, 4, 1), -- Piscina Infantil, não aquecida em área aberta
       (1, 5, 2), -- Restaurantes no estilo Self Service
       (1, 6, 1), -- Restaurante a La Carte
       (1, 7, 1), -- Área Kids, com brinquedoteca, vídeo games e biblioteca
       (1, 8, 1);
-- Equipe de Entretenimento Infantil e adulto


-- Inserção de informações sobre quartos
INSERT INTO book_room_quarto.quarto (id_predio, id_localidade, total_pessoas, tipo, valor_diaria, quantidade_quartos)
VALUES (1, 1, 2, 1, 350.00, 20),
       (1, 1, 4, 2, 450.00, 15),
       (1, 1, 2, 3, 550.00, 20),
       (1, 1, 4, 4, 650.00, 15),
       (1, 1, 2, 5, 850.00, 10),
       (1, 1, 4, 6, 950.00, 10);

-- --Inserção de informações sobre camas nos quartos
INSERT INTO book_room_quarto.quarto_camas (id_quarto, tipo_cama, quantidade, descricao)
VALUES (1, 10, 1, 'Sofá, Poltronas, Frigobar, TV Led 54 pols., Mesa de Escritório, Cadeira de Escritório'),
       (2, 12, 1, 'Sofá, Poltronas, Frigobar, TV Led 54 pols., Mesa de Escritório, Cadeira de Escritório'),
       (2, 11, 2, 'Sofá, Poltronas, Frigobar, TV Led 54 pols., Mesa de Escritório, Cadeira de Escritório'),
       (3, 12, 1, 'Sofá, Poltronas, Frigobar, TV Led 62 pols., Mesa de Escritório, Cadeira de Escritório'),
       (4, 12, 1, 'Sofá, Poltronas, Frigobar, TV Led 62 pols., Mesa de Escritório, Cadeira de Escritório'),
       (4, 11, 2, 'Sofá, Poltronas, Frigobar, TV Led 62 pols., Mesa de Escritório, Cadeira de Escritório'),
       (5, 12, 1, 'Sofá, Poltronas, Frigobar, TV Led 62 pols., Mesa de Escritório, Cadeira de Escritório'),
       (6, 12, 2, 'Sofá, Poltronas, Frigobar, TV Led 62 pols., Mesa de Escritório, Cadeira de Escritório');

