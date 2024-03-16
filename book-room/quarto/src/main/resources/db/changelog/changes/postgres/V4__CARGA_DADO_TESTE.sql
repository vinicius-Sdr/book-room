-- Inserir informações sobre localidade
INSERT INTO book_room_quarto.localidade (nome, rua_av, numero, cep, cidade, estado)
VALUES ('Fazenda da Pós Tech', 'Rua da Pós Tech', '567', '01000-002', 'Cidade da Pós Tech', 'Estado da Pós Tech'),
       ('Hotel Fazenda do Vale', 'Avenida do Vale', '890', '02000-003', 'Cidade do Vale', 'Estado do Vale'),
       ('Pousada do Lago', 'Rua do Lago', '345', '03000-004', 'Cidade do Lago', 'Estado do Lago'),
       ('Resort do Mar', 'Avenida do Mar', '678', '04000-005', 'Cidade do Mar', 'Estado do Mar'),
       ('Hotel da Montanha', 'Rua da Montanha', '123', '05000-006', 'Cidade da Montanha', 'Estado da Montanha'),
       ('Pousada do Sol', 'Avenida do Sol', '456', '06000-007', 'Cidade do Sol', 'Estado do Sol'),
       ('Resort da Praia', 'Rua da Praia', '789', '07000-008', 'Cidade da Praia', 'Estado da Praia'),
       ('Hotel do Campo', 'Avenida do Campo', '101', '08000-009', 'Cidade do Campo', 'Estado do Campo'),
       ('Pousada do Sertão', 'Rua do Sertão', '222', '09000-010', 'Cidade do Sertão', 'Estado do Sertão'),
       ('Resort do Cerrado', 'Avenida do Cerrado', '333', '10000-011', 'Cidade do Cerrado', 'Estado do Cerrado'),
       ('Hotel do Deserto', 'Rua do Deserto', '444', '11000-012', 'Cidade do Deserto', 'Estado do Deserto'),
       ('Pousada do Oceano', 'Avenida do Oceano', '555', '12000-013', 'Cidade do Oceano', 'Estado do Oceano'),
       ('Resort do Pantanal', 'Rua do Pantanal', '666', '13000-014', 'Cidade do Pantanal', 'Estado do Pantanal'),
       ('Hotel do Sertão', 'Avenida do Sertão', '777', '14000-015', 'Cidade do Sertão', 'Estado do Sertão'),
       ('Resort Paradise', 'Avenida das Palmeiras', '123', '12345-678', 'Cidade do Paraíso', 'Estado das Maravilhas'),
       ('Hotel Metrópolis', 'Avenida Central', '456', '98765-432', 'Cidade Metrópole', 'Estado Central'),
       ('Pousada Serrana', 'Rua das Montanhas', '789', '54321-098', 'Cidade da Serra', 'Estado das Alturas'),
       ('Resort Golf Greens', 'Avenida dos Lagos', '101', '13579-246', 'Cidade dos Lagos', 'Estado do Golfe'),
       ('Hotel Executivo', 'Avenida das Empresas', '222', '87654-321', 'Cidade Executiva', 'Estado dos Negócios');

-- Inserir associações de amenidades para a localidade
INSERT INTO book_room_quarto.amenidades_localidade (id_localidade, id_amenidade, quantidade)
VALUES
    -- Fazenda da Pós Tech
    (1, 1, 2),  -- Piscina Adulto, aquecida e coberta
    (1, 2, 1),  -- Piscina Adulto, não aquecida em área aberta
    (1, 3, 1),  -- Piscina Infantil, aquecida e coberta
    (1, 4, 1),  -- Piscina Infantil, não aquecida em área aberta
    (1, 5, 2),  -- Restaurantes no estilo Self Service
    (1, 6, 1),  -- Restaurante a La Carte
    (1, 7, 1),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (1, 8, 2),  -- Equipe de Entretenimento Infantil e adulto

    -- Hotel Fazenda do Vale
    (2, 1, 1),  -- Piscina Adulto, aquecida e coberta
    (2, 2, 1),  -- Piscina Adulto, não aquecida em área aberta
    (2, 3, 2),  -- Piscina Infantil, aquecida e coberta
    (2, 4, 2),  -- Piscina Infantil, não aquecida em área aberta
    (2, 5, 2),  -- Restaurantes no estilo Self Service
    (2, 6, 1),  -- Restaurante a La Carte
    (2, 7, 1),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (2, 8, 1),  -- Equipe de Entretenimento Infantil e adulto

    -- Pousada do Lago
    (3, 1, 1),  -- Piscina Adulto, aquecida e coberta
    (3, 2, 1),  -- Piscina Adulto, não aquecida em área aberta
    (3, 3, 1),  -- Piscina Infantil, aquecida e coberta
    (3, 4, 1),  -- Piscina Infantil, não aquecida em área aberta
    (3, 5, 1),  -- Restaurantes no estilo Self Service
    (3, 6, 2),  -- Restaurante a La Carte
    (3, 7, 1),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (3, 8, 1),  -- Equipe de Entretenimento Infantil e adulto

    -- Resort do Mar
    (4, 1, 2),  -- Piscina Adulto, aquecida e coberta
    (4, 2, 1),  -- Piscina Adulto, não aquecida em área aberta
    (4, 3, 1),  -- Piscina Infantil, aquecida e coberta
    (4, 4, 1),  -- Piscina Infantil, não aquecida em área aberta
    (4, 5, 2),  -- Restaurantes no estilo Self Service
    (4, 6, 1),  -- Restaurante a La Carte
    (4, 7, 1),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (4, 8, 2),  -- Equipe de Entretenimento Infantil e adulto

    -- Hotel da Montanha
    (5, 1, 2),  -- Piscina Adulto, aquecida e coberta
    (5, 2, 1),  -- Piscina Adulto, não aquecida em área aberta
    (5, 3, 2),  -- Piscina Infantil, aquecida e coberta
    (5, 4, 1),  -- Piscina Infantil, não aquecida em área aberta
    (5, 5, 2),  -- Restaurantes no estilo Self Service
    (5, 6, 1),  -- Restaurante a La Carte
    (5, 7, 2),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (5, 8, 1),  -- Equipe de Entretenimento Infantil e adulto

    -- Pousada do Sol
    (6, 1, 1),  -- Piscina Adulto, aquecida e coberta
    (6, 2, 1),  -- Piscina Adulto, não aquecida em área aberta
    (6, 3, 1),  -- Piscina Infantil, aquecida e coberta
    (6, 4, 1),  -- Piscina Infantil, não aquecida em área aberta
    (6, 5, 1),  -- Restaurantes no estilo Self Service
    (6, 6, 2),  -- Restaurante a La Carte
    (6, 7, 1),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (6, 8, 2),  -- Equipe de Entretenimento Infantil e adulto

    -- Resort da Praia
    (7, 1, 2),  -- Piscina Adulto, aquecida e coberta
    (7, 2, 1),  -- Piscina Adulto, não aquecida em área aberta
    (7, 3, 1),  -- Piscina Infantil, aquecida e coberta
    (7, 4, 1),  -- Piscina Infantil, não aquecida em área aberta
    (7, 5, 3),  -- Restaurantes no estilo Self Service
    (7, 6, 1),  -- Restaurante a La Carte
    (7, 7, 1),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (7, 8, 1),  -- Equipe de Entretenimento Infantil e adulto

    -- Hotel do Campo
    (8, 1, 2),  -- Piscina Adulto, aquecida e coberta
    (8, 2, 1),  -- Piscina Adulto, não aquecida em área aberta
    (8, 3, 2),  -- Piscina Infantil, aquecida e coberta
    (8, 4, 1),  -- Piscina Infantil, não aquecida em área aberta
    (8, 5, 1),  -- Restaurantes no estilo Self Service
    (8, 6, 2),  -- Restaurante a La Carte
    (8, 7, 1),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (8, 8, 1),  -- Equipe de Entretenimento Infantil e adulto

    -- Pousada do Sertão
    (9, 1, 1),  -- Piscina Adulto, aquecida e coberta
    (9, 2, 1),  -- Piscina Adulto, não aquecida em área aberta
    (9, 3, 1),  -- Piscina Infantil, aquecida e coberta
    (9, 4, 1),  -- Piscina Infantil, não aquecida em área aberta
    (9, 5, 2),  -- Restaurantes no estilo Self Service
    (9, 6, 1),  -- Restaurante a La Carte
    (9, 7, 2),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (9, 8, 2),  -- Equipe de Entretenimento Infantil e adulto

    -- Resort do Cerrado
    (10, 1, 2),  -- Piscina Adulto, aquecida e coberta
    (10, 2, 2),  -- Piscina Adulto, não aquecida em área aberta
    (10, 3, 1),  -- Piscina Infantil, aquecida e coberta
    (10, 4, 1),  -- Piscina Infantil, não aquecida em área aberta
    (10, 5, 3),  -- Restaurantes no estilo Self Service
    (10, 6, 1),  -- Restaurante a La Carte
    (10, 7, 2),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (10, 8, 2),  -- Equipe de Entretenimento Infantil e adulto

    -- Hotel do Deserto
    (11, 1, 2),  -- Piscina Adulto, aquecida e coberta
    (11, 2, 1),  -- Piscina Adulto, não aquecida em área aberta
    (11, 3, 1),  -- Piscina Infantil, aquecida e coberta
    (11, 4, 1),  -- Piscina Infantil, não aquecida em área aberta
    (11, 5, 2),  -- Restaurantes no estilo Self Service
    (11, 6, 1),  -- Restaurante a La Carte
    (11, 7, 1),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (11, 8, 2),  -- Equipe de Entretenimento Infantil e adulto

    -- Pousada do Oceano
    (12, 1, 1),  -- Piscina Adulto, aquecida e coberta
    (12, 2, 1),  -- Piscina Adulto, não aquecida em área aberta
    (12, 3, 2),  -- Piscina Infantil, aquecida e coberta
    (12, 4, 2),  -- Piscina Infantil, não aquecida em área aberta
    (12, 5, 2),  -- Restaurantes no estilo Self Service
    (12, 6, 2),  -- Restaurante a La Carte
    (12, 7, 1),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (12, 8, 1),  -- Equipe de Entretenimento Infantil e adulto

    -- Resort do Pantanal
    (13, 1, 3),  -- Piscina Adulto, aquecida e coberta
    (13, 2, 2),  -- Piscina Adulto, não aquecida em área aberta
    (13, 3, 1),  -- Piscina Infantil, aquecida e coberta
    (13, 4, 2),  -- Piscina Infantil, não aquecida em área aberta
    (13, 5, 1),  -- Restaurantes no estilo Self Service
    (13, 6, 2),  -- Restaurante a La Carte
    (13, 7, 2),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (13, 8, 1),  -- Equipe de Entretenimento Infantil e adulto

    -- Hotel do Sertão
    (14, 1, 1),  -- Piscina Adulto, aquecida e coberta
    (14, 2, 1),  -- Piscina Adulto, não aquecida em área aberta
    (14, 3, 2),  -- Piscina Infantil, aquecida e coberta
    (14, 4, 2),  -- Piscina Infantil, não aquecida em área aberta
    (14, 5, 3),  -- Restaurantes no estilo Self Service
    (14, 6, 1),  -- Restaurante a La Carte
    (14, 7, 2),  -- Área Kids, com brinquedoteca, vídeo games e biblioteca
    (14, 8, 2);  -- Equipe de Entretenimento Infantil e adulto

-- Inserir informações sobre prédio
INSERT INTO book_room_quarto.predio (id_localidade, nome)
VALUES (1, 'Casa Principal');

-- Inserir informações sobre quartos
INSERT INTO book_room_quarto.quarto (id_predio, id_localidade, total_pessoas, tipo, valor_diaria, quantidade_quartos, identicacao)
VALUES
    (1, 1, 4, 1, 350.00, 20,'205'), -- Standard Simples
    (1, 1, 4, 2, 450.00, 15,'206'), -- Standard Duplo
    (1, 1, 2, 3, 550.00, 20,'207'), -- Luxo Simples
    (1, 1, 4, 4, 650.00, 15,'208'), -- Luxo Duplo
    (1, 1, 2, 5, 850.00, 10,'209'), -- Premium Simples
    (1, 1, 4, 6, 950.00, 10,'210'); -- Premium Duplo

-- Inserir informações sobre itens presentes nos quartos
INSERT INTO book_room_quarto.quarto_itens (id_quarto, tipo_item, quantidade)
VALUES
    (1, 'Sofá', 1),
    (1, 'Poltronas', 2),
    (1, 'Frigobar', 1),
    (1, 'TV Led 54 pols.', 1),
    (1, 'Mesa de Escritório', 1),
    (1, 'Cadeira de Escritório', 1),
    (2, 'Sofá', 1),
    (2, 'Poltronas', 2),
    (2, 'Frigobar', 1),
    (2, 'TV Led 54 pols.', 1),
    (2, 'Mesa de Escritório', 1),
    (2, 'Cadeira de Escritório', 1),
    (3, 'Sofá', 1),
    (3, 'Poltronas', 2),
    (3, 'Frigobar', 1),
    (3, 'TV Led 62 pols.', 1),
    (3, 'Mesa de Escritório', 1),
    (3, 'Cadeira de Escritório', 1),
    (4, 'Sofá', 1),
    (4, 'Poltronas', 2),
    (4, 'Frigobar', 1),
    (4, 'TV Led 62 pols.', 1),
    (4, 'Mesa de Escritório', 1),
    (4, 'Cadeira de Escritório', 1),
    (5, 'Sofá', 1),
    (5, 'Poltronas', 2),
    (5, 'Frigobar', 1),
    (5, 'TV Led 62 pols.', 1),
    (5, 'Mesa de Escritório', 1),
    (5, 'Cadeira de Escritório', 1),
    (6, 'Sofá', 1),
    (6, 'Poltronas', 2),
    (6, 'Frigobar', 1),
    (6, 'TV Led 62 pols.', 1),
    (6, 'Mesa de Escritório', 1),
    (6, 'Cadeira de Escritório', 1);

-- Inserir informações sobre camas nos quartos
INSERT INTO book_room_quarto.quarto_camas (id_quarto, tipo_cama, quantidade, descricao)
VALUES
    (1, 10, 1, 'Queen Size'),
    (2, 10, 1, 'Queen Size'),
    (2, 11, 2, 'Solteiro'),
    (3, 12, 1, 'King Size'),
    (4, 12, 1, 'King Size'),
    (4, 11, 2, 'Solteiro'),
    (5, 12, 1, 'King Size'),
    (6, 12, 2, 'King Size');
