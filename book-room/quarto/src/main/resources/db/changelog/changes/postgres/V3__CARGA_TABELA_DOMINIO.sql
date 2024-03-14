-- Inserir informações sobre tipos de quartos
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
       ('Queen Size', 'Cama'),
       ('Solteiro', 'Cama'),
       ('King Size', 'Cama');

-- Inserir informações sobre amenidades
INSERT INTO book_room_quarto.amenidades (descricao)
VALUES ('Piscina Adulto, aquecida e coberta'),
       ('Piscina Adulto, não aquecida em área aberta'),
       ('Piscina Infantil, aquecida e coberta'),
       ('Piscina Infantil, não aquecida em área aberta'),
       ('Restaurantes no estilo Self Service'),
       ('Restaurante a La Carte'),
       ('Área Kids, com brinquedoteca, vídeo games e biblioteca'),
       ('Equipe de Entretenimento Infantil e adulto');


