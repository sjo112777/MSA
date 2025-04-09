package kr.co.sjo112777.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
public class MainController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/publish/topic01")
    public String publish1(){

        for (int i = 0; i < 100; i++) {
            kafkaTemplate.send("my-topic-01", "message-"+i);
        }

        return "done";
    }

    @GetMapping("/publish/topic02")
    public String publish2(){

        for (int i = 0; i < 1000; i++) {
            kafkaTemplate.send("my-topic-02", "message-"+i);
        }

        return "done";
    }

    @GetMapping("/publish/topic03")
    public String publish3(){

        for (int i = 0; i < 1000; i++) {
            kafkaTemplate.send("my-topic-03", "message-"+i);
        }

        return "done";
    }


}
