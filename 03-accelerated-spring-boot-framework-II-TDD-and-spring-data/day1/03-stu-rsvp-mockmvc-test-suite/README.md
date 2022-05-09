# RSVP MockMvc Test Suite

The purpose of this assignment is for you to gain experience unit-testing the controller portion of a Spring Boot REST web service while using a mock repository.

## Assignment

Create a comprehensive unit test suite for the REST endpoints of the given RSVP web service using Spring MockMvc. Implement code for each of the following `RsvpControllerTest` test cases:

```java
@Test
public void shouldCreateNewRsvpOnPostRequest() throws Exception {
}

@Test
public void shouldReturnRsvpById() throws Exception {
}

@Test
public void shouldBStatusOkForNonExistentRsvpId() throws Exception {
}

@Test
public void shouldReturnAllRsvps() throws Exception {
}

@Test
public void shouldUpdateByIdAndReturn200StatusCode() throws Exception {
}

@Test
public void shouldDeleteByIdAndReturn200StatusCode() throws Exception {
}
```

For each test case, use Mockito to create a mock `RsvpRepository`, which will be used by the `RsvpController`.

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.