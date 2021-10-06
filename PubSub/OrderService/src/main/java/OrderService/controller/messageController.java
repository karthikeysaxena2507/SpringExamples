package OrderService.controller;

import OrderService.config.PubSubOutBoundGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class messageController {

    private final PubSubOutBoundGateway messagingGateway;

    @Autowired
    public messageController(PubSubOutBoundGateway messagingGateway) {
        this.messagingGateway = messagingGateway;
    }

    @PostMapping("/publishMessage")
    public String publishMessage() {
        messagingGateway.sendToPubSub("Hello! This is a publisher message");
        return "Message Published successfully";
    }

}
