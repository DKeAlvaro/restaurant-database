CREATE DATABASE PizzaAPI;
USE PizzaAPI;

CREATE TABLE Customer(id double, name VARCHAR(30), adress VARCHAR(45) , PRIMARY KEY (id));
CREATE TABLE Staff(deliverers INTEGER, waiters INTEGER );

CREATE TABLE Menu(id INTEGER, name VARCHAR(45),price DOUBLE, PRIMARY KEY (id));
CREATE TABLE Pizzas(id INTEGER, name VARCHAR(45), price DOUBLE, vegan BIT);

CREATE TABLE Ingredients(id INTEGER, name VARCHAR(45), price DOUBLE, vegan BIT, PRIMARY KEY (id));

CREATE TABLE Desserts(id INTEGER, name VARCHAR(45), price DOUBLE, primary key (id));

CREATE TABLE Drinks(id INTEGER, name VARCHAR(45), price DOUBLE, PRIMARY KEY (id));

CREATE TABLE Customers(id INTEGER, name VARCHAR(45), lastname VARCHAR(45), numberorder INTEGER, adress VARCHAR(45), PRIMARY KEY(id));

CREATE TABLE PizzaIngredients(id INTEGER, pepperoni bit, ham bit, tomato bit, herbs bit, cheese bit, chicken bit, funghi bit, cheddar bit, gouda bit, bluecheese bit, dutchcheese bit, 
salami bit, pienapple bit, olives bit,barbequesauce bit, price double);



SHOW FULL TABLES;









