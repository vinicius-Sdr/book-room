

- [Módulo Book Room (Cliente)](#módulo-book-room-cliente)
    - [Endpoints do Módulo](#endpoints-do-módulo)
    - [Endpoints](#endpoints)
        - [API de Cliente](#api-de-clientes)
            - [Cadastrar Cliente](#cadastrar-amenidade)
            - [Listar Todos os Cliente](#listar-todos-os-clientes)
            - [Consultar Cliente por ID](#consultar-cliente-por-id)
            - [Excluir Cliente](#excluir-cliente)
            - [Alterar Cliente](#alterar-cliente)
--

# Módulo Book Room (Cliente)

O módulo Book Room é responsável por gerenciar os clientes. Ele fornece operações para criar, atualizar, excluir e listar clientes.

## Endpoints do Módulo

Nesta seção, apresentamos a lista de endpoints disponíveis no módulo Book Room, todos devidamente documentados no Swagger. A documentação pode ser acessada por meio do link [Swagger](http://localhost:8080/swagger-ui/index.html).

Para realizar requisições HTTP, sugerimos a utilização do Swagger para uma exploração interativa ou do Postman.

Este modulo utiliza o liquibase para gerenciar as alterações no banco de dados. Os arquivos de alteração estão localizados no diretório `src/main/resources/db/changelog`.

* Acesse aqui o [changeLog](src/main/resources/db/changelog)


## Endpoints

Ao iniciar o módulo será disponibilizado os seguintes endpoints:

### API de Clientes

#### Cadastrar Cliente

```bash
curl -X 'POST' \
  'http://localhost:8080/api/v1/client' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "vinicius",
  "birthDate": "06/12/2001",
  "country": "Brasil",
  "passport": "",
  "address": "Rua Brasil, 0979023-90",
  "cellphone": "(11) 92222-2222",
  "email": "email@email.com",
  "cpf": "123.123.123-87"
}'
```

#### Listar Todos os Clientes

```bash
curl -X 'GET' \
  'http://localhost:8080/api/v1/client' \
  -H 'accept: */*'
```

#### Consultar Cliente por ID

```bash
*Substitua {id} pelo ID do cliente que você deseja consultar.*
curl -X 'GET' \
  'http://localhost:8080/api/v1/client/{id}' \
  -H 'accept: */*'
```

#### Excluir Cliente

*Substitua {id} pelo ID do cliente que você deseja excluir.*

```bash
curl -X 'DELETE' \
  'http://localhost:8080/api/v1/client/{id}' \
  -H 'accept: */*'
```

#### Alterar Cliente

*Substitua {id} pelo ID do cliente que você deseja alterar.*

```bash
curl -X 'PUT' \
  'http://localhost:8080/api/v1/client/{id}' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Joao",
  "birthDate": "19/08/1996",
  "country": "Costa Rica",
  "passport": "gt26345g",
  "address": "Costa Rica avenue",
  "cellphone": "(+5511) 123123",
  "email": "email@email.com",
  "cpf": ""
}'
