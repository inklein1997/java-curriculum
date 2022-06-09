# Deploy a Java Application to Heroku

1. In a browser navigate to the Heroku Dashboard page at: https://dashboard.heroku.com/

2. Create a new app on Heroku.

   In the upper right corner click the `New` button and select `Create New App`.

   ![Image highlights "Create new app" menu item](./heroku-100-new-app.png)
   Name the app `hello-heroku-firstname-lastname`
   
   App names on heroku need to be unique. If you don't want to use your name, you just need a unique name for the app.
   
   When ready, click the `Create New App` button to create the application on Heroku.
   ![Image highlights "Create app" button](./heroku-200-create-app.png)

3. Switch to the terminal and navigate to the folder that is the root of your project. Run the following command:

   ```heroku login```
   
   Follow the prompts to open a browser window and to login from that browser window. This will ensure you are logged in through the Heroku command line CLI.

   ![Image displays "Logged In" confirmation dialog](./heroku-300-logged-in.png)

4. To connect your local repository to heroku, run

    ```heroku git:remote -a [appName]```

   Where [appName] is what you named the app on Heroku.
   You should see a confirmation that git remote heroku is now set.

5. Push the code and the app out to the Heroku Cloud Platform by running the command

   ```git push heroku main```

   You should see a long tailing log that represents the deployment to Heroku with a final deployment confirmation.

   ![Image displays deployment confirmation log messages](./terminal-100-heroku-deployment-confirmation.png)
   
6. Following deployment, return to the Heroku dashboard page at: https://dashboard.heroku.com/

   Click on your new app.
   
   In the upper right corner, click the ```more``` button and select ```View logs```.

   ![Image highlights "View Logs" menu item](./heroku-400-view-logs.png)
   
   You should see logging that confirms that the app was deployed, initialized, and started.

   ![Image displays deployment log messages](./heroku-500-app-up-log.png)

7. Click on the ```Open app``` button in the upper right-hand corner and a browser window will open.

   ![Image highlights "Open app" button](./heroku-600-open-app.png)

   If your app does not have a front end (for example, an API), nothing will display. This is the base URL for your app. If you have a REST API with a GET endpoint at `/hello`, you can go there with a browser or Postman by appending `/hello` to the URL. For example `https://hello-heroku-bill-preston.herokuapp.com/hello`


Congratulations! You have just deployed your application to the Heroku Cloud Platform.

## Important! Shutting Down and Starting the Service

For our class, we will only be creating free apps on Heroku. However, it is good practice to always shut down the Heroku Service whenever you are not planning on running the service to ensure that there is no way any usage charges can be incurred.

Here are the steps you can use on the Heroku Dashboard to start and stop your services:

1. From the Dashboard, click the App to open its main page.

2. From the ```Overview``` tab, in the middle of the page click the ```Configure Dynos``` link.

   ![Image highlights "Configure Dynos" link](./heroku-700-overview-dynos.png)
     
3. You should see the one dyno that is deployed. Click the Edit button for that dyno.

   ![Image highlights "pencil" edit button](./heroku-800-dyno-edit.png)
     
4. You should now see the dyno on/off slider button. This is the on/off switch for the service. Click on the slider switch, and then click the `Confirm` button to save the change.

   ![Image highlights slider switch and "Confirm" button](./heroku-900-turn-off-dyno.png)
       
   Turning this slider to the off position when the service is not needed will ensure that no service changes will be incurred.