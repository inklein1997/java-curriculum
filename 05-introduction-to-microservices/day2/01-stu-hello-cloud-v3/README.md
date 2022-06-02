# Hello Cloud Service v3

## Introduction

In this activity, you will use the Feign web service client and the Eureka service registry to communicate with other services in the system.

## System Design

![Image displays diagram of Cloud components interacting](images/hello-cloud-v2.png)

## Modify the System

We will modify the `hello-cloud` project by swapping out the `RestTemplate` for the Feign web service client. We'll build the system in the following steps:

1. Add dependencies to the POM file.

2. Enable Feign.

3. Create the Feign client.

4. Modify the controller to use the Feign client.

### Step 1: Add Dependencies

Before you begin, open the `hello-cloud` project in IntelliJ.

The first step is to add the Feign libraries to the project. To do so, open the POM file and add the following dependency:

```xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-feign</artifactId>
			<version>1.4.7.RELEASE</version>
		</dependency>
```

### Step 2: Enable Feign

The next step is to enable Feign. To do so, we will add the `@EnableFeignClients` annotation to the `com.trilogyed.config.HelloCloudService.java` class. 

Open `com.trilogyed.config.HelloCloudService.java`, and modify it so it looks like this:

```java
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class HelloCloudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloCloudServiceApplication.class, args);
	}
}
```

### Step 3: Create the Feign Client

The Feign library allows us to create web service clients in a declarative manner using annotations and an interface definition. No code is required beyond the annotated interface definition. We will use the following two annotations:

* `@FeignClient`

* `@RequestMapping`

#### @FeignClient

This interface-level annotation marks our interface as a Feign client. The `name` parameter allows us to specify the web service that our client interacts with.

#### @RequestMapping

This is the same annotation we use to define endpoints in our web service controllers. In this case, we use it to define which of the service endpoints a given method definition should interact with.

Create a new Java interface called `com.trilogyed.config.util.feign.RandomGreetingClient.java`, and add the following code:

`java
@FeignClient(name = "quote-service")
public interface QuoteClient {

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public String getRandomQuote();
}
`

Items to note about this code:

1. The `@FeignClient` marks this interface as a Feign client. The `name` attribute is the name of the service this client will interact with. This name must match the name of a service registered with Eureka.

2. The `@RequestMapping` annotation allows us to specify which endpoint should be called when the annotated method is invoked. In our case, a `GET` request will be issued to `/greeting` on the `random-greeting-service` whenever `getRandomGreeting` is invoked in our code.

### Step 4: Modify the Controller

Finally, we will modify the controller to use the Feign client instead of the `RestTemplate` for interaction with the `random-greeting-service`.

Open `com.trilogyed.hellocloudservice.controller.HelloCloudServiceController.java`, and modify it so it looks like the following code. The original `RestTemplate`-based code as been commented out so we can see each version side by side. It is clear that the Feign-based code is much less complex.

```java
@RestController
@RefreshScope
public class HelloCloudServiceController {

//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    private RestTemplate restTemplate = new RestTemplate();
//
//    @Value("${randomGreetingServiceName}")
//    private String randomGreetingServiceName;
//
//    @Value("${serviceProtocol}")
//    private String serviceProtocol;
//
//    @Value("${servicePath}")
//    private String servicePath;
//
//    @Value("${officialGreeting}")
//    private String officialGreeting;

    @Autowired
    private final RandomGreetingClient client;


    HelloCloudServiceController(RandomGreetingClient client) {
        this.client = client;
    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String helloCloud() {

//        List<ServiceInstance> instances = discoveryClient.getInstances(randomGreetingServiceName);
//
//        String randomGreetingServiceUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;
//
//        String greeting = restTemplate.getForObject(randomGreetingServiceUri, String.class);
//
//        return greeting;

        return client.getRandomGreeting();
    }
}
```

Items to note about this code:

1. No additional annotations are needed on the controller.

2. We use DI constructor injection to wire the `RandomGreetingClient` into the controller.

3. The Feign client makes the web service call to the `random-greeting-service` look like a normal method call.

## Run the System

Start the services in the following order:

1. `config-server`

2. `registry`

3. `quote-service`

4. `hello-cloud`

Open a browser and visit http://localhost:7979/hello. You should see one of the random quotes from the Quote Service. Refresh the page and you should get different quotes.

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
