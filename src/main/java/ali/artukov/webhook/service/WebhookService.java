package ali.artukov.webhook.service;

import org.springframework.http.ResponseEntity;

public interface WebhookService {

    ResponseEntity<Object> sendMessageToTelegram(Object message);
}
