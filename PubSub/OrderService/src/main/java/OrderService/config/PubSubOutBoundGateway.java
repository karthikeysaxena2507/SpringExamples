package OrderService.config;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "pubSubOutputChannel")
public interface PubSubOutBoundGateway {
    void sendToPubSub(String text);
}
