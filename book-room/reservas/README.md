

- [Módulo Book Room (Reserva)](#módulo-book-room-Reserva)
    - [Endpoints do Módulo](#endpoints-do-módulo)
    - [Endpoints](#endpoints)
        - [API de Reserva](#api-de-Reservas)
            - [Cadastrar Reserva](#cadastrar-amenidade)
            - [Listar Todas as Reservas](#listar-todas-as-Reservas)
            - [Consultar Reserva por ID](#consultar-Reserva-por-id)
            - [Excluir Reserva](#excluir-Reserva)
            - [Alterar Reserva](#alterar-Reserva)
              --

# Módulo Book Room (Reserva)

O módulo Book Room é responsável por gerenciar as Reservas. Ele fornece operações para criar, atualizar, excluir e listar Reservas.

## Endpoints do Módulo

Nesta seção, apresentamos a lista de endpoints disponíveis no módulo Book Room, todos devidamente documentados no Swagger. A documentação pode ser acessada por meio do link [Swagger](http://localhost:8082/swagger-ui/index.html).

Para realizar requisições HTTP, sugerimos a utilização do Swagger para uma exploração interativa ou do Postman.

Este modulo utiliza o liquibase para gerenciar as alterações no banco de dados. Os arquivos de alteração estão localizados no diretório `src/main/resources/db/changelog`.

* Acesse aqui o [changeLog](src/main/resources/db/changelog)


## Endpoints

Ao iniciar o módulo será disponibilizado os seguintes endpoints:

### API de Reservas

#### Cadastrar Reserva

```bash
{
  "guests": 4,
  "checkInDate": "2024-03-16T15:08:55.687Z",
  "checkOutDate": "2024-03-16T15:08:55.687Z",
  "clientId": 1,
  "roomId": 1,
  "locale": 1,
  "building": 1,
  "item": [
    2
  ],
  "servicing": [
    3
  ]
}
```

#### Listar Todos os Reservas

```bash
curl -X 'GET' \
  'http://localhost:8082/api/v1/reserva' \
  -H 'accept: */*'
```

#### Consultar Reserva por ID

```bash
*Substitua {id} pelo ID do Reserva que você deseja consultar.*
curl -X 'GET' \
  'http://localhost:8082/api/v1/reserva/{id}' \
  -H 'accept: */*'
```

#### Excluir Reserva

*Substitua {id} pelo ID da Reserva que você deseja excluir.*

```bash
curl -X 'DELETE' \
  'http://localhost:8082/api/v1/reserva/{id}' \
  -H 'accept: */*'
```

#### Alterar Reserva

*Substitua {id} pelo ID da Reserva que você deseja alterar.*

```bash
curl -X 'PUT' \
  'http://localhost:8082/api/v1/reserva/{id}' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "guests": 3,
  "checkInDate": "2024-03-16T15:11:08.347Z",
  "checkOutDate": "2024-03-16T15:11:08.347Z",
  "clientId": 3,
  "roomId": 3,
  "locale": 3,
  "building": 2,
  "item": [
    1
  ],
  "servicing": [
    1
  ]
}'
