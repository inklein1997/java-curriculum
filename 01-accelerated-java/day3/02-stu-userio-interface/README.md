# UserIO

## Introduction

In this activity, you will be provided with starter code that contains a `UserIO` interface and an `Application` class. The `Application` class contains a main method. You’ll be asked to create a new class called `Input` that implements the provided `UserIO` interface.

## Requirements

- Use the code in the "starter" folder.
- All code must be contained inside your `Input` class.
- You should not modify the `UserIO` interface or the `Application` class.

## Instructions

1. Create a new class called `Input` that implements the provided `UserIO` interface. This interface defines the following methods:

    - `readInt`, which displays a prompt and then reads an `int` from the user.

    - `readLong`, which displays a prompt reading a `long` from the user.

    - `readDouble`, which displays a prompt reading a `double` from the user.

    - `readFloat`, which displays a prompt reading a `float` from the user.

    - `readString`, which displays a prompt reading a `String` from the user.

    The methods in your `Input` class must contain the logic to read the value in, convert it to the appropriate type, and return it to the user. A `main()` method that uses this class in the `Application` class has been provided.

2. Once you have implemented this class, run `Application` to test your code.

3. All code must be contained inside your `Input` class. You should not modify the `UserIO` interface or the `Application` class.

**Hint**: You'll need to use `Scanner` in your `Input` class.

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
