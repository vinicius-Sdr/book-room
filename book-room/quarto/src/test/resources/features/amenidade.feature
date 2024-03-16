# language: pt
Funcionalidade: API - Amenidade

  @smoke
  Cenário: Listar todas as amenidades
    Quando faço uma requisição para listar todas as amenidades
    Então deve ser retornado o status code 200
    E deve ser retornado todas as amenidades cadastradas

