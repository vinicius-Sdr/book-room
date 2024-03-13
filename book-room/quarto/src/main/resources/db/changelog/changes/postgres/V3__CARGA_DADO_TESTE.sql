
-- Inserir informações sobre prédio
INSERT INTO book_room_quarto.predio (id_localidade, nome)
VALUES (1, 'Casa Principal');

-- Inserir informações sobre quartos
INSERT INTO book_room_quarto.quarto (id_predio, id_localidade, total_pessoas, tipo, valor_diaria, quantidade_quartos)
VALUES
    (1, 1, 4, 1, 350.00, 20), -- Standard Simples
    (1, 1, 4, 2, 450.00, 15), -- Standard Duplo
    (1, 1, 2, 3, 550.00, 20), -- Luxo Simples
    (1, 1, 4, 4, 650.00, 15), -- Luxo Duplo
    (1, 1, 2, 5, 850.00, 10), -- Premium Simples
    (1, 1, 4, 6, 950.00, 10); -- Premium Duplo

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
