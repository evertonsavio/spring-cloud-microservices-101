package com.coffeeandcode.amqp.consumerapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MachineConsumer {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RabbitListener(queues = MachineAMQPConfig.QUEUE)
    public void consumer(Message message) throws JsonProcessingException {

        byte[] body = message.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        Machine machine = objectMapper.readValue(new String(body) , Machine.class);

        System.out.println(machine.getModel() + machine.getBrand() + machine.getFabricationYear());

        simpMessagingTemplate.convertAndSend(MachineWebSocketConfiguration.BROKER,
                new String(message.getBody()));
    }
}
