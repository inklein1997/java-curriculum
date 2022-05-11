# Complete Record Collection Test Suite

Your assignment is to complete the following ServiceLayerTest unit tests found in the `starter` folder using Mockito, as outlined in class. Use existing tests as a guide.

* `public void saveFindAlbum()`
* `public void saveFindFindAllArtist()`
* `public void saveFindFindAllLabel()`

## Structure

Your solution must have the following structural elements:

1. Complete the ServiceLayerTest JUnit test class in the `record-collection` project in the `starter` folder.
2. Turn in the entire project.

## Configuration Note

The project in the `starter` folder contains two test cases in `AlbumRepositoryTests.java` that write the field `releaseDate` to the database and immediately read it back.

In the case that the time zone of your installed `MySQL` instance is mismatched with the time zone specified in the project's `application.properties`, the test cases will fail with with the following error:

```
java.lang.AssertionError: 
Expected :Album{id=169, title='NEW TITLE', artistId=167, releaseDate=2000-07-06, labelId=167, listPrice=15.68}
Actual   :Album{id=169, title='NEW TITLE', artistId=167, releaseDate=2000-07-07, labelId=167, listPrice=15.68}
```

In this case, you will need to change `UTC` in the `spring.datasource.url` field to a more specific time zone setting based on your location, such as: `serverTimezone=US/Central`.  For example:

```
spring.datasource.url: jdbc:mysql://localhost:3306/record_collection?useSSL=false&serverTimezone=US/Central&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true
```

Note that you will need to update the `application.properties` file accordingly in the `resources` directory in both the project's `main` and `test` directory structures.


---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.