package net.devple.message.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

  @Bean
  public DirectExchange directExchange() {
    return new DirectExchange("delivery.exchange");
  }

  @Bean
  public Queue queue() {
    return new Queue("delivery.queue");
  }

  @Bean
  public Binding binding(Queue queue, DirectExchange directExchange) {
    return BindingBuilder.bind(queue).to(directExchange).with("delivery.key");
  }

  @Bean
  public MessageConverter messageConverter(ObjectMapper mapper) {
    return new Jackson2JsonMessageConverter(mapper);
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory factory, MessageConverter converter) {
    var template =  new RabbitTemplate(factory);
    template.setMessageConverter(converter);
    return template;
  }
}
