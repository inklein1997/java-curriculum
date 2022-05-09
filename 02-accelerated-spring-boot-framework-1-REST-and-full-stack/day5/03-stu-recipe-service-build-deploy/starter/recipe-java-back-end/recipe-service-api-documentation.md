# Recipe Service API Documentation

```openapi: 3.0.3
info:
  title: Api Documentation
  description: Api Documentation
  termsOfService: 'urn:tos'
  contact: {}
  license:
    name: Apache 2.0
    url: 'http://www.apache.org/licenses/LICENSE-2.0'
  version: '1.0'
servers:
  - url: 'http://localhost:8080'
    description: Inferred Url
tags:
  - name: data-loader-controller
    description: Data Loader Controller
  - name: ingredient-controller
    description: Ingredient Controller
  - name: prep-step-controller
    description: Prep Step Controller
  - name: rating-controller
    description: Rating Controller
  - name: recipe-controller
    description: Recipe Controller
paths:
  /load-data:
    get:
      tags:
        - data-loader-controller
      summary: loadData
      operationId: loadDataUsingGET
      responses:
        '200':
          description: OK
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
  /ingredients:
    put:
      tags:
        - ingredient-controller
      summary: updateIngredient
      operationId: updateIngredientUsingPUT
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Ingredient'
      responses:
        '200':
          description: OK
        '201':
          description: Created
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    post:
      tags:
        - ingredient-controller
      summary: addIngredient
      operationId: addIngredientUsingPOST
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Ingredient'
      responses:
        '201':
          description: Created
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Ingredient'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
  '/ingredients/recipe/{id}':
    get:
      tags:
        - ingredient-controller
      summary: getIngredientsByRecipe
      operationId: getIngredientsByRecipeUsingGET
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Ingredient'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
  '/ingredients/{id}':
    get:
      tags:
        - ingredient-controller
      summary: getIngrdient
      operationId: getIngrdientUsingGET
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Ingredient'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    delete:
      tags:
        - ingredient-controller
      summary: deleteIngredient
      operationId: deleteIngredientUsingDELETE
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      responses:
        '200':
          description: OK
        '204':
          description: No Content
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
  /prepsteps:
    put:
      tags:
        - prep-step-controller
      summary: updatePrepStep
      operationId: updatePrepStepUsingPUT
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/PrepStep'
      responses:
        '200':
          description: OK
        '201':
          description: Created
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    post:
      tags:
        - prep-step-controller
      summary: addPrepStep
      operationId: addPrepStepUsingPOST
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/PrepStep'
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/PrepStep'
        '201':
          description: Created
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
  '/prepsteps/recipe/{id}':
    get:
      tags:
        - prep-step-controller
      summary: getPrepStepsByRecipe
      operationId: getPrepStepsByRecipeUsingGET
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/PrepStep'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
  '/prepsteps/{id}':
    get:
      tags:
        - prep-step-controller
      summary: getPrepStep
      operationId: getPrepStepUsingGET
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/PrepStep'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    delete:
      tags:
        - prep-step-controller
      summary: deletePrepStep
      operationId: deletePrepStepUsingDELETE
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      responses:
        '200':
          description: OK
        '204':
          description: No Content
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
  /ratings:
    put:
      tags:
        - rating-controller
      summary: updateRating
      operationId: updateRatingUsingPUT
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Rating'
      responses:
        '200':
          description: OK
        '201':
          description: Created
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    post:
      tags:
        - rating-controller
      summary: addRating
      operationId: addRatingUsingPOST
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Rating'
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Rating'
        '201':
          description: Created
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
  '/ratings/recipe/{id}':
    get:
      tags:
        - rating-controller
      summary: getRatingsByRecipe
      operationId: getRatingsByRecipeUsingGET
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Rating'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
  '/ratings/{id}':
    get:
      tags:
        - rating-controller
      summary: getRating
      operationId: getRatingUsingGET
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Rating'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    delete:
      tags:
        - rating-controller
      summary: deleteRating
      operationId: deleteRatingUsingDELETE
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      responses:
        '200':
          description: OK
        '204':
          description: No Content
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
  /recipes:
    get:
      tags:
        - recipe-controller
      summary: getAllRecipes
      operationId: getAllRecipesUsingGET
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Recipe'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    put:
      tags:
        - recipe-controller
      summary: updateRecipe
      operationId: updateRecipeUsingPUT
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Recipe'
      responses:
        '200':
          description: OK
        '201':
          description: Created
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    post:
      tags:
        - recipe-controller
      summary: addRecipe
      operationId: addRecipeUsingPOST
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Recipe'
      responses:
        '201':
          description: Created
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Recipe'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
  '/recipes/category/{category}':
    get:
      tags:
        - recipe-controller
      summary: getRecipesByCategory
      operationId: getRecipesByCategoryUsingGET
      parameters:
        - name: category
          in: path
          description: category
          required: true
          style: simple
          schema:
            type: string
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Recipe'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
  '/recipes/{id}':
    get:
      tags:
        - recipe-controller
      summary: getRecipe
      operationId: getRecipeUsingGET
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Recipe'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    delete:
      tags:
        - recipe-controller
      summary: deleteRecipe
      operationId: deleteRecipeUsingDELETE
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      responses:
        '200':
          description: OK
        '204':
          description: No Content
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
components:
  schemas:
    Ingredient:
      title: Ingredient
      type: object
      properties:
        amount:
          type: string
        description:
          type: string
        ingredientId:
          type: integer
          format: int32
        name:
          type: string
        recipeId:
          type: integer
          format: int32
    PrepStep:
      title: PrepStep
      type: object
      properties:
        prepStepId:
          type: integer
          format: int32
        prepStepText:
          type: string
        recipeId:
          type: integer
          format: int32
        stepNumber:
          type: integer
          format: int32
    Rating:
      title: Rating
      type: object
      properties:
        numStars:
          type: integer
          format: int32
        ratingId:
          type: integer
          format: int32
        ratingText:
          type: string
        recipeId:
          type: integer
          format: int32
        recommended:
          type: boolean
    Recipe:
      title: Recipe
      type: object
      properties:
        category:
          type: string
        cookTime:
          type: string
        description:
          type: string
        ingredients:
          uniqueItems: true
          type: array
          items:
            $ref: '#/components/schemas/Ingredient'
        prepSteps:
          uniqueItems: true
          type: array
          items:
            $ref: '#/components/schemas/PrepStep'
        prepTime:
          type: string
        ratings:
          uniqueItems: true
          type: array
          items:
            $ref: '#/components/schemas/Rating'
        recipeId:
          type: integer
          format: int32
        servings:
          type: integer
          format: int32
        title:
          type: string
```