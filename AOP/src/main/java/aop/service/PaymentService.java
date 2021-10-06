package aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    public String getPayment() {
        log.info("fetching payment...");
        log.info("payment fetched !");
        return "OK";
    }

}
