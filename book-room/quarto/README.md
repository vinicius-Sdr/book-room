

- [Módulo Book Room (Quarto)](#módulo-book-room-quarto)
  - [Endpoints do Módulo](#endpoints-do-módulo)
  - [Endpoints](#endpoints)
    - [API de Amenidade](#api-de-amenidade)
      - [Cadastrar Amenidade](#cadastrar-amenidade)
      - [Listar Todas as Amenidades](#listar-todas-as-amenidades)
      - [Consultar Amenidade por ID](#consultar-amenidade-por-id)
      - [Excluir Amenidade](#excluir-amenidade)
      - [Alterar Amenidade](#alterar-amenidade)
    - [API de Localidade](#api-de-localidade)
      - [Cadastrar Localidade](#cadastrar-localidade)
      - [Listar Todas as Localidades](#listar-todas-as-localidades)
      - [Consultar Localidade por ID](#consultar-localidade-por-id)
      - [Excluir Localidade](#excluir-localidade)
      - [Alterar Localidade](#alterar-localidade)
    - [API de Predio](#api-de-predio)
      - [Cadastrar Predio](#cadastrar-predio)
      - [Listar Todos os Predios](#listar-todos-os-predios)
      - [Consultar Predio por ID](#consultar-predio-por-id)
      - [Excluir Predio](#excluir-predio)
      - [Alterar Predio](#alterar-predio)
    - [Api de Quarto](#api-de-quarto)
      - [Cadastrar QuartoCama](#cadastrar-quartocama)
      - [Listar Todos os QuartosCama](#listar-todos-os-quartoscama)
      - [Consultar QuartoCama por ID](#consultar-quartocama-por-id)
      - [Excluir QuartoCama](#excluir-quartocama)
      - [Alterar QuartoCama](#alterar-quartocama)
    - [API de QuartoItem](#api-de-quartoitem)
      - [Cadastrar QuartoItem](#cadastrar-quartoitem)
      - [Listar Todos os QuartosItem](#listar-todos-os-quartositem)
      - [Consultar QuartoItem por ID](#consultar-quartoitem-por-id)
      - [Excluir QuartoItem](#excluir-quartoitem)
      - [Alterar QuartoItem](#alterar-quartoitem)
    - [API de Quarto](#api-de-quarto-1)
      - [Cadastrar Quarto](#cadastrar-quarto)
      - [Listar Todos os Quartos](#listar-todos-os-quartos)
      - [Consultar Quarto por ID](#consultar-quarto-por-id)
      - [Excluir Quarto](#excluir-quarto)
      - [Alterar Quarto](#alterar-quarto)
    - [API de Tipo](#api-de-tipo)
      - [Cadastrar Tipo](#cadastrar-tipo)
      - [Listar Todos os Tipos](#listar-todos-os-tipos)
      - [Consultar Tipo por ID](#consultar-tipo-por-id)
      - [Excluir Tipo](#excluir-tipo)
      - [Alterar Tipo](#alterar-tipo)

-- 

# Módulo Book Room (Quarto)

O módulo Book Room é responsável por gerenciar os quartos do hotel. Ele fornece operações para criar, atualizar, excluir e listar quartos. 

## Endpoints do Módulo

Nesta seção, apresentamos a lista de endpoints disponíveis no módulo Book Room, todos devidamente documentados no Swagger. A documentação pode ser acessada por meio do link [Swagger](http://localhost:8081/swagger-ui/index.html).

Para realizar requisições HTTP, sugerimos a utilização do Swagger para uma exploração interativa ou do Postman.

Este modulo utiliza o liquibase para gerenciar as alterações no banco de dados. Os arquivos de alteração estão localizados no diretório `src/main/resources/db/changelog`.

* Acesse aqui o [changeLog](src/main/resources/db/changelog)


## Endpoints

Ao iniciar o módulo será disponibilizado os seguintes endpoints:

### API de Amenidade

#### Cadastrar Amenidade

```bash
curl -X POST 'http://localhost:8081/api/amenidade' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Nome da Amenidade",
    "descricao": "Descrição da Amenidade"
}'
```

#### Listar Todas as Amenidades

```bash
curl -X GET 'http://localhost:8081/api/amenidade'
```

#### Consultar Amenidade por ID

```bash
*Substitua {id} pelo ID da amenidade que você deseja consultar.*
curl -X GET 'http://localhost:8081/api/amenidade/{id}'
```

#### Excluir Amenidade

*Substitua {id} pelo ID da amenidade que você deseja excluir.*

```bash
curl -X DELETE 'http://localhost:8081/api/amenidade/{id}'
```

#### Alterar Amenidade

*Substitua {id} pelo ID da amenidade que você deseja alterar.*

```bash
curl -X PATCH 'http://localhost:8081/api/amenidade/{id}' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Novo Nome da Amenidade",
    "descricao": "Nova Descrição da Amenidade"
}'
```

### API de Localidade

#### Cadastrar Localidade

```bash
curl -X POST 'http://localhost:8080/api/localidade' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Nome da Localidade",
    "descricao": "Descrição da Localidade"
}'
```

#### Listar Todas as Localidades

```bash
curl -X GET 'http://localhost:8080/api/localidade'
```

#### Consultar Localidade por ID

*Substitua {id} pelo ID da localidade que você deseja consultar.*

 ```bash 
curl -X GET 'http://localhost:8080/api/localidade/{id}'
```

#### Excluir Localidade

*Substitua {id} pelo ID da localidade que você deseja excluir.*
 
 ```bash
curl -X DELETE 'http://localhost:8080/api/localidade/{id}'
```

#### Alterar Localidade

*Substitua {id} pelo ID da localidade que você deseja alterar.*
 
 ```bash
curl -X PUT 'http://localhost:8080/api/localidade/{id}' \
-H 'Content-Type: application/json' \
-d '{
    "nome": "Novo Nome da Localidade",
    "descricao": "Nova Descrição da Localidade"
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