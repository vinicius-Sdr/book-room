

- [Módulo Book Room (Servico-opcional)](#módulo-book-room-servico-opcional)
    - [Endpoints do Módulo](#endpoints-do-módulo)
    - [Endpoints](#endpoints)
        - [API de Item](#api-de-Item)
            - [Cadastrar Item](#cadastrar-Item)
            - [Listar Todas as Itens](#listar-todas-as-Itens)
            - [Consultar Item por ID](#consultar-Item-por-id)
            - [Excluir Item](#excluir-Item)
            - [Alterar Item](#alterar-Item)
        - [API de Servicos](#api-de-Servicos)
            - [Cadastrar Servicos](#cadastrar-Servicos)
            - [Listar Todas as Servicoss](#listar-todas-as-Servicos)
            - [Consultar Servicos por ID](#consultar-Servicos-por-id)
            - [Excluir Servicos](#excluir-Servicos)
            - [Alterar Servicos](#alterar-Servicos)
--

# Módulo Book Room (Servic-Opcional)

O módulo Book Room é responsável por gerenciar os serviços opcionais do hotel. Ele fornece operações para criar, atualizar, excluir e listar os itens e serviços opcionais.

## Endpoints do Módulo

Nesta seção, apresentamos a lista de endpoints disponíveis no módulo Book Room, todos devidamente documentados no Swagger. A documentação pode ser acessada por meio do link [Swagger](http://localhost:8083/swagger-ui/index.html).

Para realizar requisições HTTP, sugerimos a utilização do Swagger para uma exploração interativa ou do Postman.

Este modulo utiliza o liquibase para gerenciar as alterações no banco de dados. Os arquivos de alteração estão localizados no diretório `src/main/resources/db/changelog`.

* Acesse aqui o [changeLog](src/main/resources/db/changelog)


## Endpoints

Ao iniciar o módulo será disponibilizado os seguintes endpoints:

### API de Item

#### Cadastrar Item

```bash
curl -X 'POST' \
  'http://localhost:8083/api/v1/item' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "itemName": "Guarana",
  "description": "refrigerante lata guarana",
  "price": 10.0
}'
```

#### Listar Todos os Itens

```bash
curl -X 'GET' \
  'http://localhost:8083/api/v1/item' \
  -H 'accept: */*'
```

#### Consultar Item por ID

```bash
*Substitua {id} pelo ID da Item que você deseja consultar.*
curl -X 'GET' \
  'http://localhost:8083/api/v1/item/{id}' \
  -H 'accept: */*'
```

#### Excluir Item

*Substitua {id} pelo ID do Item que você deseja excluir.*

```bash
curl -X 'DELETE' \
  'http://localhost:8083/api/v1/item/{id}' \
  -H 'accept: */*'
```

#### Alterar Item

*Substitua {id} pelo ID do Item que você deseja alterar.*

```bash
curl -X 'PUT' \
  'http://localhost:8083/api/v1/item/{id}' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "itemName": "guarana",
  "description": "guarana de garra 600ml",
  "price": 12.0
}'
```

### API de Servicos

#### Cadastrar Servicos

```bash
curl -X 'POST' \
  'http://localhost:8083/api/v1/servicing' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "serviceName": "massagem",
  "description": "massagem por pessoa",
  "price": 50.0
}'
```

#### Listar Todas as Servicoss

```bash
curl -X 'GET' \
  'http://localhost:8083/api/v1/servicing' \
  -H 'accept: */*'
```

#### Consultar Servicos por ID

*Substitua {id} pelo ID da Servicos que você deseja consultar.*

 ```bash 
curl -X 'GET' \
  'http://localhost:8083/api/v1/servicing/{id}' \
  -H 'accept: */*'
```

#### Excluir Servicos

*Substitua {id} pelo ID da Servicos que você deseja excluir.*

 ```bash
curl -X 'DELETE' \
  'http://localhost:8083/api/v1/servicing/{id}' \
  -H 'accept: */*'
```

#### Alterar Servicos

*Substitua {id} pelo ID da Servicos que você deseja alterar.*

 ```bash
curl -X 'PUT' \
  'http://localhost:8083/api/v1/servicing/{id}' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "serviceName": "massagem",
  "description": "massagem por pessoa",
  "price": 75.0
}'
```

### API de Predio

#### Cadastrar Predio

 ```bash
curl -X POST 'http://localhost:8080/api/predio' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Nome do Predio",
    "descricao": "Descrição do Predio"
}'
```

#### Listar Todos os Predios

 ```bash
curl -X GET 'http://localhost:8080/api/predio'
```

#### Consultar Predio por ID
*Substitua {id} pelo ID do predio que você deseja consultar.*

 ```bash
curl -X GET 'http://localhost:8080/api/predio/{id}'
```

#### Excluir Predio
* Substitua {id} pelo ID do predio que você deseja excluir. *

 ```bash
curl -X DELETE 'http://localhost:8080/api/predio/{id}'
```

#### Alterar Predio
*Substitua {id} pelo ID do predio que você deseja alterar.*

 ```bash
curl -X PUT 'http://localhost:8080/api/predio/{id}' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Novo Nome do Predio",
    "descricao": "Nova Descrição do Predio"
}'
```

### Api de Quarto

#### Cadastrar QuartoCama

 ```bash
curl -X POST 'http://localhost:8080/api/quartocama' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Nome do QuartoCama",
    "descricao": "Descrição do QuartoCama"
}'
```

#### Listar Todos os QuartosCama

 ```bash
curl -X GET 'http://localhost:8080/api/quartocama'
```

#### Consultar QuartoCama por ID

*Substitua {idQuarto} e {idTipoCama} pelos IDs do quarto e do tipo de cama que você deseja consultar.*

 ```bash
curl -X GET 'http://localhost:8080/api/quartocama/{idQuarto}/{idTipoCama}'
```

#### Excluir QuartoCama

*Substitua {idQuarto} e {idTipoCama} pelos IDs do quarto e do tipo de cama que você deseja excluir.*

 ```bash
curl -X DELETE 'http://localhost:8080/api/quartocama/{idQuarto}/{idTipoCama}'
```

#### Alterar QuartoCama

*Substitua {idQuarto} e {idTipoCama} pelos IDs do quarto e do tipo de cama que você deseja alterar.*

 ```bash
curl -X PATCH 'http://localhost:8080/api/quartocama/{idQuarto}/{idTipoCama}' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Novo Nome do QuartoCama",
    "descricao": "Nova Descrição do QuartoCama"
}'
```

### API de QuartoItem

#### Cadastrar QuartoItem

 ```bash
curl -X POST 'http://localhost:8080/api/quartoitem' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Nome do QuartoItem",
    "descricao": "Descrição do QuartoItem"
}'
```

#### Listar Todos os QuartosItem

 ```bash
curl -X GET 'http://localhost:8080/api/quartoitem'
```

#### Consultar QuartoItem por ID

*Substitua {id} pelo ID do quarto item que você deseja consultar.*

 ```bash
curl -X GET 'http://localhost:8080/api/quartoitem/{id}'
```

#### Excluir QuartoItem

*Substitua {id} pelo ID do quarto item que você deseja excluir.*

 ```bash
curl -X DELETE 'http://localhost:8080/api/quartoitem/{id}'
```

#### Alterar QuartoItem

*Substitua {id} pelo ID do quarto item que você deseja alterar.*

 ```bash
curl -X PATCH 'http://localhost:8080/api/quartoitem/{id}' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Novo Nome do QuartoItem",
    "descricao": "Nova Descrição do QuartoItem"
}'
```

### API de Quarto

#### Cadastrar Quarto

```bash
curl -X POST 'http://localhost:8080/api/quarto' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Nome do Quarto",
    "descricao": "Descrição do Quarto"
}'
```

#### Listar Todos os Quartos

```bash
curl -X GET 'http://localhost:8080/api/quarto'

```

#### Consultar Quarto por ID

*Substitua {id} pelo ID do quarto que você deseja consultar.*

```bash
curl -X GET 'http://localhost:8080/api/quarto/{id}'
```

#### Excluir Quarto

*Substitua {id} pelo ID do quarto que você deseja excluir.*

```bash
curl -X DELETE 'http://localhost:8080/api/quarto/{id}'
```

#### Alterar Quarto

*Substitua {id} pelo ID do quarto que você deseja alterar.*

```bash
curl -X PATCH 'http://localhost:8080/api/quarto/{id}' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Novo Nome do Quarto",
    "descricao": "Nova Descrição do Quarto"
}'
```

### API de Tipo

#### Cadastrar Tipo

```bash
curl -X POST 'http://localhost:8080/api/tipo' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Nome do Tipo",
    "descricao": "Descrição do Tipo"
}'
```

#### Listar Todos os Tipos

```bash
curl -X GET 'http://localhost:8080/api/tipo'
```

#### Consultar Tipo por ID

*Substitua {id} pelo ID do tipo que você deseja consultar.*

```bash
curl -X GET 'http://localhost:8080/api/tipo/{id}'
```

#### Excluir Tipo

*Substitua {id} pelo ID do tipo que você deseja excluir.*

```bash
curl -X DELETE 'http://localhost:8080/api/tipo/{id}'
```

#### Alterar Tipo

*Substitua {id} pelo ID do tipo que você deseja alterar.*

```bash
curl -X PUT 'http://localhost:8080/api/tipo/{id}' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Novo Nome do Tipo",
    "descricao": "Nova Descrição do Tipo"
}'
```