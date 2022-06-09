# Admin Endpoint

## Introduction

In this activity, we will add an admin authority, a new user, and a new endpoint.

## Instructions

1. Add a new `RSVP_ADMIN` authority.

2. Add a new user called `'francis'`.

3. Give `'francis'` all of the existing authorities.

4. In the `RsvpController` class, add a new endpoint called `/eventPublishersList`. This endpoint requires the `'RSVP_ADMIN'` authorization and returns the following message: "Hello, <username>. You may view a list of event publishers."
   - The username should be the name of the user who is calling the endpoint.

5. Now close all your incognito windows (to clear all session information).

6. Test the `publicEvent` endpoint to verify it is working correctly:

   - Open a new incognito window.
   - Go to [http://localhost:8080/publicEvent](http://localhost:8080/publicEvent).

7. Test the `guestList` endpoint to verify it is working correctly:

   - Go to [http://localhost:8080/guestList](http://localhost:8080/guestList).
   - Log in as francis.

8. Test the `privateEvent` endpoint to verify it is working correctly:

   - Go to [http://localhost:8080/privateEvent](http://localhost:8080/privateEvent).

9. Test the `privateEvent` endpoint to verify it is working correctly:

   - Go to [http://localhost:8080/eventPublishersList](http://localhost:8080/eventPublishersList).


---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
