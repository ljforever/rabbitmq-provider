package com.gwhn.rabbitmqprovider;

import com.gwhn.rabbitmqprovider.controller.SendMessageController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SendMessageController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootApplication
class RabbitmqProviderApplicationTests {

    @Test
    void contextLoads() {
        SendMessageController sendMessageController = new SendMessageController();
        sendMessageController.sendDirectMessage();
    }

}
