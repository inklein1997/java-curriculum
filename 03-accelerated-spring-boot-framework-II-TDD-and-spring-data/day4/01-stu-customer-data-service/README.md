# Customer Data Service Project

In this project, you will build a simple full-stack application to keep track of customer data. You will implement the back-end REST API using Spring Boot, Spring Data JPA, and MySQL. You will implement the front end using React.

## Requirements/Features

* Your application must track the following data for each customer:

  * Customer ID
  * First name
  * Last name
  * Street
  * City
  * State
  * Zip code
  * Level (Gold, Silver, Bronze)

* The REST API must have the following features (see the API documentation for further detail):

  * Create a new customer record.
  * Update an existing customer record.
  * Delete an existing customer record.
  * Find a customer record by id.
  * Find customer records by level.
  * Find customer records by state.

* The front end must have the following features:

  * Select/dropdowns to filter by state and/or levels.
  * Display the relevant information for each customer (First Name, Last Name, Street, etc.) as per the earlier specs.
  * Each displayed customer should have a button to delete the customer record.
  * Each displayed customer should have a button to edit the customer record.
  * A form to add a new customer. The form should accept all of the appropriate fields as previously mentioned. For the level, you could use a dropdown with predetermined choices or just an input field. As soon as the form is submitted, the new customer should be seen at the bottom of the page.

## User Stories

Your application must complete the following user stories:

- As a user, I would like to be able to filter data by state and/or levels.

- As a user, I would like to be display the data relevant to each customer.

- As a user, I would like to be able to delete customer records.

- As a user, I would like to be able to edit customer records.

- As a user, I would like to be able to add new customer records.

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.