# Using Lists

## Structure

- Add the code necessary to the `starter` project `UsingLists`.
- All classes should part of the `com.company` package.
- Tests can be found in the `test/java` directory. Once you have written each class, uncomment the code in the associated test and run it.

## Specifications

For all of the following, remember to program to the interface rather than to the concrete class (i.e., declare your variables as `List` instead of `ArrayList`).

1. Refactor the following array methods found in `App` to use an `ArrayList` instead: 
    - `total`
    - `totalEven`
    - `swapFirstAndLast`
    - `reverse`
    - `lessThanFive`
    - `splitAtFive` **Challenge**
    - `evensAndOdds` **Challenge**
2. Create a new class called `LinkedListApp` and refactor the activities to implement a `LinkedList` instead of an `ArrayList`.
3. Complete the following steps to create a `List` to hold information about your classmates.
    1. Create a `Classmate` class, which has the properties `name` and `hairColor`, along with the associated getters/setters.
    2. Create another class called `ClassmatesList` to hold `Classmate` objects.
    	- It should have a single private property which is an `ArrayList` of `Classmate` objects.
    	- Do not create getters and setters for this list.
      	1. Implement the following public methods in the `ClassmatesList` class:

      		- `add` which takes in a new `Classmate` and adds it to the list of classmates.
      		- `get` which takes in an `int` and returns the classmate at that index.
      		- `getAll` which returns the entire list.
4. Create a new class called `SetIterator` and create a public method called `printSet` which does the following:
	- Returns nothing
	- Takes in five integers as its arguments
	- Adds those integers into a new `HashSet`
	- Uses an `Iterator` to print all members of the `HashSet`

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.

