# Add a MySQL Databae to a Heroku Application

If you have an application that uses MySQL, you can run MySQL on your own computer during development, but what if you want to deploy the application to Heroku? An application running on Heroku should not use a database installed on your local computer. Fortunately, you can set up a database on the Heroku platform that will work with your application. Here's how.

## Step 1: Create the project on the Heroku Cloud Platform

If you don't already have your application set up in Heroku, you can create one.
1. In a browser navigate to the Heroku Dashboard page at: https://dashboard.heroku.com/
2. Create a new app on Heroku. This example uses the rsvp-service, so call your app rsvp-service-firstname-lastname (because application names on heroku need to be globally unique).
   * In the upper right corner, click the `New` button and select `Create new app`.

        ![Image highlights "Create New App" menu item](./heroku-100-new-app.png)

   * Name the app `rsvp-service-firstname-lastname` and click the `Create app` button.

        ![Image highlights "Create App" button](./heroku-210-create-app.png)

## Step 2: Add a free MySQL database instance to the project on Heroku

1. From the app's main page, click the Resources menu link.
2. Under Add-ons type 'clearDb' in the text field and you will see an option to select ClearDB MySQL. You can use this for free.
    ![Image displays "ClearDB MySQL" add-on](./heroku-300-resources-clear-db.png)
   * Click ClearDB MysSQL. Leave the Plan name alone and click `Submit Order Form`.


    **Note:** Before you can add resources, you will be required to provide a credit card number. As long as you only utilize free add-on resources and do not use more than 999 hours of service processing you will not be charged. We will not ask you to use any paid resources for any of our lesson activities.

## Step 3: Configure MySQL on Heroku 

1. Now on your app's Heroku Dashboard, click the Settings menu at the top of the page.
2. In the middle of the page, find the Config Vars section and click the `Reveal Config Vars button`.

    ![Image highlights "Settings" menu item](./heroku-400-settings-reveal-config-vars.png)

3. When the Config(uration) Var(iable)s are revealed, note that there is one Config Var named
   `CLEARDB_DATABASE_URL`.  

     * Add a new Config Var named `DB_URL` by typing that name in the `Key` text field. 
     * Copy the value in the `CLEARDB_DATABASE_URL` variable and paste that into the value field for the new `DB_URL` that you are creating.
     * Be sure to click the `Add` button to complete and save the new Config Var.

     ![Image displays adding new variable via "Config Vars"](./heroku-500-new-config-var.png)

## Step 4: Connect MySQL Workbench to the Heroku MySQL database and run the RSVP schema

Just like you do in your local environment with your local instance of MySQL, you need to create the database schema and create the tables that will be utilized by your Java API. You will need to do the same in the MySQL database on Heroku to be able to connect your Java API on Heroku with the MySQL support database. To do so, you will connect MySQL Workbench to your MySQL Heroku database in the following steps.

1. Open MySQL Workbench.

2. On the MySQL Workbench Dashboard page locate the `MySQL Connections` and click the '+' (plus) symbol to add a new connection.

    ![Image highlights "+" button to add connection](./mysql-100-new-connection-button.png)

   The Setup New Connection dialog box will open.

3. You will need to provide the required values in the Setup New Connection dialog box. Those values are included in the value of the `DB_URL` Config Var that you created in the previous section. Follow these steps:

     * Go back to the Heroku Dashboard and again locate the Config Vars on your app's Settings tab. Click the `Reveal Config Vars` button to display the DB_URL variable.
     * Copy the value of the `DB_URL` variable. It should look similar to this:

       ```mysql://b131244f843ddf:250306b6@us-cdbr-east-04.cleardb.com/heroku_d96da8468c53ef0?reconnect=true```

     * You will need to dissect this environment variable to find the values needed to populate the fields in the Setup New Connection dialog box. Follow this breakdown to obtain the values needed for `Hostname`, `Username`, `Password` and `default schema`. The variable is of the form `mysql://<USERNAME>:<PASSWORD>@<HOSTNAME>/<DEFAULT_SCHEMA>?reconnect=true`

        So, in this example

        * Username is `b131244f843ddf`
        * Password is `250306b6`
        * Hostname is `us-cdbr-east-04.cleardb.com`
        * Default Schema is `heroku_d96da8468c53ef0`


    ![Image displays "Setup New Connection" dialog](./mysql-200-connection-information.png)

     * Name the Connection by adding a name in the `Connection Name` text field. 

     * Click the ```Test Connection``` button to verify the connection.
       * You may receive a warning about features on MySQL Workbench that might be unavailable. Click ```Continue``` to move forward with the connection test. 

    ![Image displays confirmation of connection creation](./mysql-300-successful-connection.png)
     * Once the values are populated and the connection is verified, click the ```OK``` button to create the connection.
     * After the connection is created, you will see that new connection as an option on the MySQL Workbench Dashboard.

     ![Image displays list of MySQL connections](./mysql-400-connection-created-on-landing-page.png)


## Step 4: Create the schema and table on the new ClearDB database

1. Now that you have MySQL Workbench connected to the Heroku MySQL database, click that connection on the MySQL Workbench Dashboard to open the connection.
   
  * The Schemas pane should be on the left side of the top of MySQL Workbench. Sometimes that pane displays Administration information. In that case, click the Schemas tab to switch to the Schemas view.

  ![Image displays "Schemas" pane](./mysql-500-schemas-tab.png)
  
   On the Schemas menu, notice that the Schema for the new connection is the `Default Schema` value that you entered in the New Connection dialog box. This is because, unlike your local MySQL database where you create multiple schemas in your local database instance, there will only be one schema per database instance on Heroku.
   
   * Now, create the rsvp table on this Heroku database.
   
        Since you do not have to create the schema (because it is already established in our connection), simply run the following SQL script to create the table on the Heroku database. Replace the schema name in the following block with your own schema name.
   
        ```
        use heroku_d96da8468c53f0;  -- replace this with the name of your schema
                  
        create table if not exists rsvp (
           rsvp_id int not null auto_increment primary key,
           guest_name varchar(50) not null,
           total_attending int not null
        );
        ```

        ![Image displays table creation in query editor](./mysql-600-create-table.png)

   
       Run the SQL script by clicking the lightning bolt button.

       ![Image highlights "lightning bolt" button](./mysql-700-lightning-bolt.png)
       
       When the script is complete, you should see a success message. Also, you can click the refresh button on the Schemas pane, 
       
        ![Image highlights refresh button](./mysql-800-success-and-refresh.png)

       and then expand the Tables in the schema to observe that the table was created.

        ![Image displays newly created table in hierarchy](./mysql-900-table-created.png
        )