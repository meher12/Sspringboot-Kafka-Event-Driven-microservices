package net.javaspring.orderservice.controller;

import net.javaspring.basedomains.dto.Order;
import net.javaspring.basedomains.dto.OrderEvent;
import net.javaspring.orderservice.kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/kafka/")
public class OrderController {



    @Autowired
    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public ResponseEntity<String> placeOrder(@RequestBody Order order){

        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMesssage("Order status is in pending state");
        orderEvent.setOrder(order);

       orderProducer.sendMessage(orderEvent);
        return ResponseEntity.ok("Order placed succesefully...");
    }
}
