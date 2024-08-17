package ali.artukov.webhook.service;

import ali.artukov.webhook.dto.RequestDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class WebhookServiceImpl implements WebhookService {

    @Value("${TG_TOKEN}")
    private String tgToken;

    @Value("${TG_CHAT_ID}")
    private Long tgChatId;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseEntity<Object> sendMessageToTelegram(Object message) {
        try {
            log.info("Calling sendMessageToTelegram method with next message: {}", message);

            String tgUri = "https://api.telegram.org/bot" + tgToken + "/sendMessage";
            RequestDto requestDto = new RequestDto();
            requestDto.setChatId(tgChatId);
            requestDto.setText(message);

            restTemplate.postForObject(tgUri, requestDto, String.class);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Error occurred while sending message to telegram: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
