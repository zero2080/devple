package net.devple.message.controller;

import lombok.RequiredArgsConstructor;
import net.devple.message.component.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

  private final Producer producer;
  @GetMapping("/message/send")
  public void send() {
    producer.send("Hello World");
  }
}
