package com.trilogyed.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class QuoteServiceController {
    String[] quotes = {
            "To me programming is more than an important practical art. It is also a gigantic undertaking in the foundations of knowledge - Grace Hopper",
            "Programs must be written for people to read, and only incidentally for machines to execute - Hal Ableson",
            "Don't call me the mother of the internet - Radia Perlman",
            "When I first started using the phrase software engineering, it was considered to be quite amusing. They used to kid me about my radical ideas. Software eventually and necessarily gained the same respect as any other discipline - Margaret Hamilton",
            "Machines take me by surprise with great frequency - Alan Turing",
            "The function of good software is to make the complex appear simple - Grady Booch",
            "An API that isn't comprehensible isn't usable - James Gosling",
            "I'm not a great programmer; I'm just a good programmer with great habits - Martin Fowler"
    };

    Random rndNumGenerator = new Random();

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${eightBallServiceName}")
    private String eightBallServiceName;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;

    @GetMapping(value="/quote")
    public String getQuote() {
        return quotes[rndNumGenerator.nextInt(8)];
    }

    @GetMapping(value="/answerme")
    public String getAnswer() {
        List<ServiceInstance> instances = discoveryClient.getInstances(eightBallServiceName);

        String randomGreetingServiceUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;

        String answer = restTemplate.getForObject(randomGreetingServiceUri, String.class);

        return answer;
    }
}
