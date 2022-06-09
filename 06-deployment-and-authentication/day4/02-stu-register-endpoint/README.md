# Register Endpoint

## Introduction

In this activity, you will add a public and a private endpoint to register events. You will also add a new user to the database.

## Instructions

1. Open the `RsvpController` class, and add a new endpoint that does not require authentication called `/registerPublicEvent`. This endpoint returns the following message: "You are registering for a public event."

2. In the `RsvpController` class, add a new endpoint that requires the same authorization as the `privateEvent` called `/registerPrivateEvent`. This endpoint returns the following message: "You are registering for a private event."

3. Add a new user to the database called `'kim'` to the database that has the same authorities as `'alex'`.

4. Test the new endpoints to verify that they are working correctly.


---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
