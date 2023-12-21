package net.devple.message.component;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {
  private final RabbitTemplate template;

  public void send(String message) {

    template.convertAndSend("delivery.exchange", "delivery.key", message);
  }
}
