package kr.co.sjo112777.controller;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
public class MainController {

    @GetMapping("/")
    public String index() {
        return "service2 index!!!";
    }
}
