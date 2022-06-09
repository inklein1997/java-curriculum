# Guest List Endpoint

## Introduction

In this activity, you will add a private endpoint to view the guest list. You will also add a new user to the database and new authority.

## Instructions

1. Add a new user called `'bill'` to the database.

2. Add a new authority to the database called `'EVENT_PUBLISHER'` to the database. Give `'bill'` the `'EVENT_PUBLISHER'` authority.

3. In the `RsvpController` class, add a new endpoint called `/guestList`. This endpoint requires the `'EVENT_PUBLISHER'` authorization and returns the following message: "Hello, <username>. Because you are an event publisher, you can see this guest list."
   - The username should be the name of the user who is calling the endpoint.

4. Test the new endpoint to verify it is working correctly:

   - Close all your incognito windows (to clear all session information).
   - Open a new incognito window.
   - Go to [http://localhost:8080/guestList](http://localhost:8080/guestList).
   - Log in as bill.


---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
