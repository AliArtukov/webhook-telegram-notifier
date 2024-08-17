package ali.artukov.webhook.controller;

import ali.artukov.webhook.service.WebhookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
@RequiredArgsConstructor
public class WebhookController {

    private final WebhookService webhookService;

    @PostMapping("/telegram")
    public ResponseEntity<Object> sendNotifyToTelegram(@RequestBody Object message) {
        return webhookService.sendMessageToTelegram(message);
    }
}
