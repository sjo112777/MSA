package kr.co.sjo112777.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics="my-topic-01", groupId = "group-my-topic01")
    public void topic01Consumer(ConsumerRecord<String, String> record) {
        log.info("topic01Consume...");
        log.info(record.key() + "-" + record.value());

    }

    @KafkaListener(topics="my-topic-02", groupId = "group-my-topic02")
    public void topic02Consumer(ConsumerRecord<String, String> record) {
        log.info("topic02Consume...");
        log.info(record.key() + "-" + record.value());

    }

    @KafkaListener(topics="my-topic-03", groupId = "group-my-topic03")
    public void topic03Consumer(ConsumerRecord<String, String> record) {
        log.info("topic03Consume...");
        log.info(record.key() + "-" + record.value());

    }

}
