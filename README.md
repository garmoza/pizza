# Pizza

## pizza-rest

REST API для:
- создание заказа (POST)
- изменение заказа (PATCH)
- удаление
- подтверждение заказа (POST)

Используется DTO - OrderModel

После подтверждения заказ отправляется в Kafka (topic kitchen)

Слушатель Kafka для готовых заказов (topic ready)

## pizza-kitchen

Слушает заказы из Kafka (topic kitchen)

Отправляет "готовый" (нет доп. логики) заказ в Kafka (topic ready)

## Dev

```sh
docker compose up -d
```

<img src="docker-compose.png" alt="">

Сделал `pizza-kitchen` зависимым от `pizza-rest` так как в `pizza-rest` определены конфигурации для топиков.
`pizza-rest` может не зависеть от `broker`, но нужны Dependency and Health checks.

Локальный Kafka
```shell
docker compose -f .\docker-compose-kafka.yml up -d 
```