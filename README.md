# Football Manager 

The application allows for reading and manipulating data using a web interface.
It uses Hibernate for database objects, Spring for deploying the application,
JSP for the front-end interface and the database used is MySQL (no other database
system were tested).

## Installation

1. Setup the database - connect to the database (preferably MySQL - I used
MySQL Workbench) and execute the commands found in the `databaseSetup.txt`
file - 2 tables should be created: 'players' and 'teams'
2. Configure the `hibernate.cfg.xml` file - the important section is this one:

```xml
<property name="connection.url">jdbc:mysql://localhost:3306/football</property>
<property name="connection.username">root</property>
<property name="connection.password">root123</property>
```

Change the schema name to the one you created and modify the username and password
if necessary.

3. Run the application - the application can be launched by running the main class
'MainApplication' from the IDE or by executing the following commands from the
command line
```bash
mvn clean install
mvn exec:java
```

4. Access the webUI - by default the main page can be accessed via browser using the
URL - http://localhost:8080/football