package aop.configuration;

import aop.controller.PaymentController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        register(PaymentController.class);
    }

}
