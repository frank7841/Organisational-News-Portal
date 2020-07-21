# Organisational_news_portal
##### By Frankline SImiyu

## Description
Organisational_news_portal is a project where we practice using REST API for querying and retrieving information. As a user, you should be able to view all all departments present, news articles (general or department-specific) and create users within a department as well as view information regarding a particular department or user.

##Database SetUp
CREATE DATABASE organisational_news_portal;
\c organisational_news_portal;
CREATE TABLE users (id SERIAL PRIMARY KEY,username varchar,positionincompany varchar,role varchar,departmentid INTEGER);
CREATE TABLE departments(id SERIAL PRIMARY KEY,depname varchar,description varchar);
CREATE TABLE news(id SERIAL PRIMARY KEY, content varchar,userid INTEGER,departmentid INTEGER,type varchar);
CREATE DATABASE organizational_news_portal_test WITH TEMPLATE organisational_news_portal;
## Setup/Installation Requirements
* To use this project, clone it.
* Make sure java, gradle, heroku,postman extension and postgresql is installed
* Navigate to src/main/java/resources/db and run in terminal psql < create.sql(creates required database with required tables)
* Test links in App in postman.
* Clone Github link https://github.com/frank7841/Organisational-News-Portal.git

## Technologies Used
Java
Heroku
Postgresql
postman

## Paths
| Url                            | Http Verb  | Description |
| :----------------------------- |:---:| -------------------------:|
| /department/new                |POST|     Add New Departments  |
| /departments                   |GET |     Display all departments |
| /users/new                     |POST|     Add new Users|
| /users                         |GET |     Show All users|
| /generalnews/new               |POST|     Post General News|
| /generalnews                   |GET |     Display General News |
| /departmentnews/new            |POST|     Post Department News|
| /users/:id                     |GET |     Display specific user|
| /department/:id                |GET |     Get specific Department|
| /users/department/:id          |GET |     Get Users from a specific Department|
| /departmentnews/department/:id |GET |     Get department news from a specific department|
| /department/:id                |GET |     Get specific departments|

## Support and contact details
Contact +254790943918 for any questions concerning the app. Feel free to give your feedback too.
### License


Copyright (c) 2020 **Frankline Simiyu**
