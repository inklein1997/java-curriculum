# Quote Service

## Introduction

In this activity, you will create a web service that returns random quotes. This web service will get its configuration from a cloud config server.

## Instructions

1. Create a new Spring Cloud Config Server project called `firstname-lastname-cloud-config-server` using the Spring Initializr by following the steps outlined in the lesson. Have the server run on port 9999, and have it use the Git repository that you created in class to store the configuration files for client applications.

2. Create a new Spring Boot REST web service called `firstname-lastname-random-quote-service`. This web service must meet the following requirements:

   * It uses the config server created in the previous step for all of its configuration settings.

   * It runs on port 2244.

   * It contains the following endpoint:

      `java
      URI: /quote
      HTTP Method: GET
      Request Body: None
      Response Body: Quote (String) 
      `

   * The endpoint should randomly return one of the following eight quotes:

      * To me programming is more than an important practical art. It is also a gigantic undertaking in the foundations of knowledge. &mdash;Grace Hopper

      * Programs must be written for people to read, and only incidentally for machines to execute. &mdash;Hal Ableson

      * Don't call me the mother of the internet. &mdash;Radia Perlman

      * When I first started using the phrase software engineering, it was considered to be quite amusing. They used to kid me about my radical ideas. Software eventually and necessarily gained the same respect as any other discipline. &mdash;Margaret Hamilton

      * Machines take me by surprise with great frequency. &mdash;Alan Turing

      * The function of good software is to make the complex appear simple. &mdash;Grady Booch

      * An API that isn't comprehensible isn't usable. &mdash;James Gosling

      * I'm not a great programmer; I'm just a good programmer with great habits. &mdash;Martin Fowler

## Hints

* Consider using an array or `ArrayList` to store the quotes.

* Consider using a random number to help you choose the quote to return.

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
