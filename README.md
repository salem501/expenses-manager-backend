## Running PostgreSQL in Docker

To run a PostgreSQL container, use the following Docker command:
```sh
docker run --name postgres-0 -p 5432:5432 -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password -d postgres:alpine
