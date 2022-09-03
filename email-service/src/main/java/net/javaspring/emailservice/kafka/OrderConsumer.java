package net.javaspring.emailservice.kafka;

import net.javaspring.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);


    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumer(OrderEvent orderEvent) {
        LOGGER.info("Order event received in email service => {} ", orderEvent);

        // send on email to customer
    }
}
