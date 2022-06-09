# Hierarchical Access

## Introduction

In this activity, we will add multiple authorities to a single user.

## Instructions

1. Open MySQL Workbench, and ask learners: "What do we need to add to the database to allow the user, bill, to access the `privateEvent` endpoint?"

2. The following insert will add the `REGISTERED_USER` authority for `bill`:

   ```sql
   insert into authorities (username, authority) values ('bill', 'REGISTERED_USER');
   ```

3. Now, close all your incognito windows (to clear all session information).

4. Test the `publicEvent` endpoint to verify it is working correctly:

   - Open a new incognito window.
   - Go to [http://localhost:8080/publicEvent](http://localhost:8080/publicEvent).

5. Test the `guestList` endpoint to verify it is working correctly:

   - Go to [http://localhost:8080/guestList](http://localhost:8080/guestList).
   - Log in as bill.

6. Test the `privateEvent` endpoint to verify it is working correctly:

   - Go to [http://localhost:8080/privateEvent](http://localhost:8080/privateEvent).

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
