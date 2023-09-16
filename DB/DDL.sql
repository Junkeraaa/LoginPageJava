CREATE DATABASE TasksListDB; --create database

USE TasksListDB; -- select the database

CREATE TABLE credentials( -- creation of table in TaskListDB, and put the types of colums
	id int Primary Key auto_increment,
    username varchar(32),
	password varchar(32)
);

