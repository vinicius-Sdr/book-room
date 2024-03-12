## Docker Compose do Postgres

O arquivo `docker-compose-postgres.yaml` foi configurado de forma genérica para ser utilizado no desenvolvimento. No entanto, é importante observar que na definição do `docker compose`, não foram especificados volumes e rede. Para utilizá-lo, é necessário apenas definir as seguintes variáveis de ambiente:

- `POSTGRES_DB`
- `POSTGRES_USER`
- `POSTGRES_PASSWORD`
- `POSTGRES_CONTAINER_NAME`

Você pode encontrar o arquivo `docker-compose-postgres.yaml` [aqui](docker-compose-postgres.yaml).

- Exemplo de como criar o arquivo [`env/.env-book-room-quarto-db`](env/.env-wells-usuario-db) para iniciar  o `docker-compose-postgres.yaml` .

```text
POSTGRES_DB=book-room-quarto
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
POSTGRES_CONTAINER_NAME=book-room-quarto-db
```

- Exemplo de como iniciar o container do Postgres.

```bash
docker-compose -f docker-compose-postgres.yaml --env-file env/.env-book-room-quarto-db up -d --force-recreate --remove-orphans
```

- Exemplo de como parar o container do Postgres.

```bash
docker-compose -f docker-compose-postgres.yaml --env-file env/.env-book-room-quarto-db down
```