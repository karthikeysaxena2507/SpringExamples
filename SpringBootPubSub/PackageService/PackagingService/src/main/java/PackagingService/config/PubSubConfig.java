package PackagingService.config;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage;
import com.google.cloud.spring.pubsub.support.GcpPubSubHeaders;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
public class PubSubConfig {

    private static final String ORDER_PACKAGING_SUBSCRIPTION = "package_sub";

    @Bean
    public PubSubInboundChannelAdapter messageChannelAdapter(
            @Qualifier("pubSubInputChannel")MessageChannel inputChannel,
            PubSubTemplate pubSubTemplate) {

        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(
                pubSubTemplate,
                ORDER_PACKAGING_SUBSCRIPTION
        );
        adapter.setOutputChannel(inputChannel);
        adapter.setAckMode(AckMode.MANUAL);
        return adapter;
    }

    @Bean
    public MessageChannel pubSubInputChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "pubSubInputChannel")
    public MessageHandler messageReceiver() {
        return message -> {
            System.out.println("Message Arrived! message is " + new String((byte[]) message.getPayload()));
            BasicAcknowledgeablePubsubMessage originalMessage = message.getHeaders()
                    .get(GcpPubSubHeaders.ORIGINAL_MESSAGE, BasicAcknowledgeablePubsubMessage.class);
            assert originalMessage != null;
            originalMessage.ack();
        };
    }

}
