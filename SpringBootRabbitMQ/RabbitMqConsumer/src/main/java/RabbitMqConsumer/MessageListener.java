package RabbitMqConsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listen(CustomMessage customMessage) {
        log.info("Message is {}", customMessage);
    }

}
