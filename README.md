# Webhook Telegram Notifier

Webhook Telegram Notifier is a lightweight service that automatically forwards incoming HTTP POST requests to a
designated Telegram chat. This tool is ideal for developers who need to receive instant notifications in Telegram from
various webhooks or external services.

## Features

- Easy Integration: Set up and configure the service with minimal effort.
- Real-Time Notifications: Receive messages instantly in your Telegram chat.
- Flexible Configuration: Customize the service to fit your needs, including specifying the target Telegram chat and
  managing API keys.
- Secure: Ensures secure transmission of messages using Telegram's Bot API.

## Getting Started

1. Use Docker image:

```shell
docker run -p 8080:8080 -e TG_TOKEN='<your tg token>' -e TG_CHAT_ID='<your tg chat id>' aliartukov/webhook-telegram-notifier:1.0.0
```

2. Or add service to docker compose:

```yaml
services:

  webhook-telegram-notifier:
    image: aliartukov/webhook-telegram-notifier:1.0.0
    container_name: webhook-telegram-notifier
    ports:
      - "8080:8080"
    environment:
      - TG_TOKEN=<your tg token>
      - TG_CHAT_ID=<your tg chat id>
```

3. Or build your image:

```shell
git clone https://github.com/AliArtukov/webhook-telegram-notifier.git
cd webhook-telegram-notifier
mvn clean package
docker build -t webhook-telegram-notifier:1.0.0 .
docker run -p 8080:8080 -e TG_TOKEN='<your tg token>' -e TG_CHAT_ID='<your tg chat id>' webhook-telegram-notifier:1.0.0
```

## Usage

- Send an HTTP POST request to the service with any content type, and it will be forwarded to the configured Telegram
  chat.

## Example

```curl
curl --location 'localhost:8080/webhook/telegram' \
--header 'Content-Type: application/json' \
--data '{
    "receiver": "site",
    "status": "firing",
    "alerts": [
        {
            "status": "firing"
        }
    ]
}'
```

## Contributing

Feel free to submit issues or pull requests. Contributions are always welcome!

## License

This project is licensed under the MIT License.