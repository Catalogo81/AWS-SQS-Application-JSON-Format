package com.xgileit.sqsspringbootapplication.consumer;

import com.xgileit.sqsspringbootapplication.database.Student;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@Slf4j
@RestController
//@EnableSqs
@RequestMapping("/consume")
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;


    /*We are using @SqsListener annotation with our listener method receiveMessage().
     With @SqsListener annotation we use queue name or queue URL. As soon as the message
      will get uploaded using producer class, receiveMessage() will receive a message from AWS SQS.
    */
    //@SqsListener("my-sqs-queue")
    @GetMapping("/my-sqs-queue")
    public void receiveMessage() {

        //need to implement where I can also receive a list of messages/objects from the queue and also retrieve all or by id

        Student studentObject = queueMessagingTemplate.receiveAndConvert("my-sqs-queue", Student.class);
        assert studentObject != null;
        logger.info(studentObject.getId().toString());

//        try
//        {
//            if(studentObject != null)
//            {
//                logger.info("\nMessage From " + studentObject.getName() + "\nID: " + studentObject.getId() + "\nRoll Number: "
//                        + studentObject.getRollNumber() + " received");
//            }
//        }catch (Exception e)
//        {
//            //logger.info("Error: " + e.getMessage());
//            System.out.println("Error: " + e.getMessage());
//        }


    }

//    @SqsListener("my-sqs-queue")
//    //@GetMapping("/my-sqs-queue")
//    public void receiveMessageFromQueue(String stringJson) {
//
//        //Student studentObject = queueMessagingTemplate.receiveAndConvert("my-sqs-queue", Student.class);
//
//        logger.info("Message Received using SQS Listener: " + stringJson);
//
//    }
}
