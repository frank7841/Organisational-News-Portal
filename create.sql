CREATE DATABASE organisational_news_portal;
\c organisational_news_portal;
CREATE TABLE users (id SERIAL PRIMARY KEY,username varchar,positionincompany varchar,role varchar,departmentid INTEGER);
CREATE TABLE departments(id SERIAL PRIMARY KEY,depname varchar,description varchar);
CREATE TABLE news(id SERIAL PRIMARY KEY, content varchar,userid INTEGER,departmentid INTEGER,type varchar);
CREATE DATABASE organizational_news_portal_test WITH TEMPLATE organisational_news_portal;