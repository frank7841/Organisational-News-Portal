CREATE DATABASE organisational_news_portal;
\c organisational_news_portal;
CREATE TABLE users (id SERIAL PRIMARY KEY,userName varchar,positionInCompany varchar,role varchar,departmentId INTEGER);
CREATE TABLE departments(id SERIAL PRIMARY KEY,depName varchar,description varchar);
CREATE TABLE news(id SERIAL PRIMARY KEY,content varchar,userid INTEGER,departmentId INTEGER,type varchar);
CREATE DATABASE organizational_news_portal_test WITH TEMPLATE organisational_news_portal;