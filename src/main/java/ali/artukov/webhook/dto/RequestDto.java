package ali.artukov.webhook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestDto {

    @JsonProperty("chat_id")
    private Long chatId;
    private Object text;
}
