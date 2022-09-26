CREATE DATABASE PizzaAPI;
USE PizzaAPI;

CREATE TABLE Customer(id double, name VARCHAR(30), adress VARCHAR(45) , PRIMARY KEY (id));
DROP TABLE Customer;


CREATE TABLE Staff(deliverers INTEGER, waiters INTEGER );
DROP TABLE Staff;

CREATE TABLE Menu(id INTEGER, name VARCHAR(45),price DOUBLE, PRIMARY KEY (id));
DROP TABLE Menu;

CREATE TABLE Pizzas(id INTEGER, name VARCHAR(45), price DOUBLE, vegan BIT);
DROP TABLE Pizzas;
SELECT * FROM Pizzas;

CREATE TABLE Ingredients(id INTEGER, name VARCHAR(45), price DOUBLE, vegan BIT, PRIMARY KEY (id));
DROP TABLE Ingredients;
SELECT * FROM Ingredients;

CREATE TABLE Desserts(id INTEGER, name VARCHAR(45), price DOUBLE, primary key (id));
DROP TABLE Desserts;
SELECT * FROM Desserts; 

CREATE TABLE Drinks(id INTEGER, name VARCHAR(45), price DOUBLE, PRIMARY KEY (id));
DROP TABLE Drinks;
SELECT * FROM Drinks; 

CREATE TABLE Customers(id INTEGER, name VARCHAR(45), lastname VARCHAR(45), numberorder INTEGER, adress VARCHAR(45), PRIMARY KEY(id));
DROP TABLE Customers;
SELECT * FROM Customers;



CREATE TABLE MargaritaIngredients(ID integer, name varchar(45), Price integer);
SELECT * FROM MargaritaIngredients;

CREATE TABLE BarbequeIngredients(ID integer, name varchar(45), Price integer);
SELECT * FROM BarbequeIngredients;

CREATE TABLE ChickenIngredients(ID integer, name varchar(45), Price integer);
SELECT * FROM ChickenIngredients;

CREATE TABLE DiavolaIngredients(ID integer, name varchar(45), Price integer);
SELECT * FROM DiavolaIngredients;

CREATE TABLE FourCheeseIngredients(ID integer, name varchar(45), Price integer);
SELECT * FROM FourCheeseIngredients;

CREATE TABLE FunghiIngredients(ID integer, name varchar(45), Price integer);
SELECT * FROM FunghiIngredients;

CREATE TABLE HamIngredients(ID integer, name varchar(45), Price integer);
SELECT * FROM HamIngredients;

CREATE TABLE HawaiIngredients(ID integer, name varchar(45), Price integer);
SELECT * FROM HawaiIngredients;

CREATE TABLE PepperoniIngredients(ID integer, name varchar(45), Price integer);
SELECT * FROM Pepperon;

CREATE TABLE ProsciutoIngredients(ID integer, name varchar(45), Price integer);
SELECT * FROM Prosciutoingrdeints;

CREATE TABLE PizzaIngredients(id INTEGER, pepperoni bit, ham bit, tomato bit, herbs bit, cheese bit, chicken bit, funghi bit, cheddar bit, gouda bit, bluecheese bit, dutchcheese bit, 
salami bit, pienapple bit, olives bit,barbequesauce bit, price double);
SELECT * FROM PizzaIngredients;



SHOW FULL TABLES;









