# Recipe Service Build and Deploy

In this assignment, you will complete the development of the Recipe Service provided in the Starter Code and deploy it to Heroku. The Recipe Service allows you to create, retrieve, update, and delete recipes. Recipes include a title, description, preparation time, cooking time, number of servings as well as preparations steps, ingredients, and ratings.

It is your job to complete the Recipe Service API, build a React front-end for the service and then deploy the application to the cloud. The Recipe Service API will be deployed to Heroku and the React front-end will be deployed to Netlify.

## Set Up

* A partially completed completed Recipe Service is included in the Starter Code for this assignment.
* You must complete the code in this project for this assignment.
* This includes code that implements the data model and JPA persistence code (similar to the code you saw in the pre-work project).
* You must update the `application.properties` file with the proper credentials for your local MySQL server.
* No further changes are necessary to the model and persistence code.
* The Recipe Service API is documented in the `recipe-service-api-documentation.md` file in the same folder as the Starter Code.

## Requirements

### Server-Side Spring Boot Service

* Complete the Recipe Service so that it fully implements the REST API described in the `recipe-service-api-documentation.md` file.
  * All of your work will be done in the Controllers.
  * You must complete the following Controllers:
    * `PrepStepController`
    * `RatingController`
    * `RecipeController`
  * The `IngredientController` has been fully implemented. Use this as a guide for the remaining controllers. Follow the pattern shown in this code for using the PrepStep, Rating, and Recipe Repositories in their respective Controllers.
  * After you have implemented the API, you can hit the `/load-data` endpoint to load a recipe into the database. This will help you exercise your API with Postman.
* Deploy your completed Recipe Service to Heroku following the steps you used for the RSVP Service in the lesson.
  * NOTE: You **will not** have to create the database table with a SQL script as you did with the RSVP Service. This is because the Recipe Service uses JPA for the persistence layer and we have configured it to automatically create the database on startup. We will learn about JPA in the next module.

## Client-Side React App

### Requirements

* Set up and organize components/pages as you see fit.
* You will need to display the complete list of Recipes. Consider this the `HomePage`. Each recipe should include:
  * `title`
  * `servings`
  * `prepTime`
  * `cookTime`
  * `category`
* Each Recipe should link to a page to edit and view more details for that particular recipe.
* On the individual recipe page, display the recipe fields, along with the other details:
  * `ingredients`
  * `prepSteps` (if time permits)
  * `ratings` (if time permits)
* All of the information on this page should also be editable. This means that we would need forms to add an `ingredient`, a `rating` or a `prepStep` **in addition to** being able to edit each individual `ingredient` and `prepStep`.
* On the `HomePage`, provide a button to add a new recipe. This form would just have the initial details for the recipe. Then, we would click on this recipe to edit `ingredients` and `prepSteps`, etc.

