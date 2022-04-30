# Largest Cities

## Specification

Your program must do the following:

1. Create a class called `City` with the following properties:
    a. `name`
    b. `population`
2. Create `City` variables to hold the following data.

        |       City      |    Population     |
        |-----------------|-------------------|
        | New York        |      8654321      |
        | Los Angeles     |      4563218      |
        | Chicago         |      2716520      |
        | Denver          |       704621      |
        | Des Moines      |       217521      |
        | Atlanta         |       486213      |

3. In the `main` method, create a Map that holds the names of states and their corresponding City objects. (State name is the `key` and City object is the `value`.)
4. Print the `name` and `population` for each City along with its corresponding state name to the screen.
5. **Write the tests** for a `filterByPopulation`, which takes in a Map with String keys and City values and an integer for population, and returns a new map containing only those cities which fall above the population value.
    
    - This method should **not** include the `Scanner` class at all. Any user input should take place in the `main` method.
6. Implement the `filterByPopulation` method.
7. In the main method, print the states with cities that have a population over a given value (this value is typed in by the user of the program) to the screen. 

**Hint:** You will have to add code to ask the user for a minimum population. Once you have this value, go through each state/city pair as you did for #4 previously but only print the information for cities that have a population above the limit.

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.