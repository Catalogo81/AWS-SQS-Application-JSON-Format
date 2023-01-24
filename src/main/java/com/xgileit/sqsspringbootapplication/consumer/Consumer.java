package com.xgileit.sqsspringbootapplication.consumer;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);


    /*We are using @SqsListener annotation with our listener method receiveMessage().
     With @SqsListener annotation we use queue name or queue URL. As soon as the message
      will get uploaded using producer class, receiveMessage() will receive a message from AWS SQS.
    */
    @SqsListener("my-sqs-queue")
    public void receiveMessage(String stringJson) {

        logger.info("Message Received using SQS Listener " + stringJson);

    }

}
