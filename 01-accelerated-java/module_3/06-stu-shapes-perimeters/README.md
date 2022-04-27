# Shapes and Perimeters

In this activity, you will compare two procedures for implementing a class: concrete implementation and abstract implementation. At the end of the exercise, you will compare and contrast the two implementations.

There is starter code for this exercise.

## Instructions

**Part 1: Concrete Class Implementation**

1. Using package `com.company.concreteapproach`, create a basic class called `Shape`. Include properties for name, color, x coordinate, and y coordinate. Provide an empty implementation for `area()` and `perimeter()` methods.

2. Once you have the `Shape` class created, create the following classes. Each class will inherit from the  `Shape` class. 

    - Each class should have properties appropriate to it and an implementation for `area()` and `perimeter()`.

         - `Circle`
         - `Square`
         - `Triangle`

**Part 2: Abstract Class Implementation**

3. Using package `com.company.abstractapproach`, create an abstract class called `Shape`. Include the same basic properties as before, but this time, declare the `area()` and `perimeter()` methods as `abstract`.

4. Create the `Circle`, `Square`, and `Triangle` classes, inheriting from the new abstract `Shape` class.

**Part 3: Interface Implementation**

5. Perform a code review of all the classes present in the `com.company.interfaceapproach` package, which are provided in the starter code. This should help give you a complete understanding of how the Interface and classes all work together to provide this project's functionality.

6. You will be recreating this implementation first with a `Concrete` classes approach, and second with an Abstract class approach. In the end, all three versions of this implementation should work the same.

7. Compare the three approaches and provide your summary as the deliverable for this activity. 

**Part 4: Written Response**

8. In your own words, write a few paragraphs comparing and contrasting these approaches. Which implementation is "best"? Feel free to create a `main` method and test out each approach.

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.