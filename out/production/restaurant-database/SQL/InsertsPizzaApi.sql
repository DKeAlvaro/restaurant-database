USE PizzaAPI;
select * from Customers;
INSERT INTO Customer VALUES(1, 'Juan',  '11th street',31065343);
INSERT INTO Customer VALUES(2, 'Pablo',   '12th street',3124590);
INSERT INTO Customer VALUES(3, 'Rimelque',  '13th street',31233345);

INSERT INTO Ingredients(id, name, price, vegan) VALUES(0, 'Pepperoni', 4, false);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(1, 'Ham', 4, false);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(2, 'Tomato', 2, true);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(3, 'Herbs', 2, true);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(4, 'Cheese', 3, true);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(5, 'Chicken', 4, false);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(6, 'Funghi', 3,true);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(7, 'Cheddar', 3, true);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(8, 'Gouda', 3, true);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(9, 'Blue Cheese', 3, true);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(10, 'Dutch Cheese', 3, true);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(11, 'Salami', 4, false);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(12, 'Pineapple', 3, true);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(13, 'Olives', 2, true);
INSERT INTO Ingredients(id, name, price,vegan) VALUES(14, 'Barbeque sauce', 2, false);

INSERT INTO Desserts(id, name, price) VALUES(15, 'Brownie', 6);
INSERT INTO Desserts(id, name, price) VALUES(16, 'Cheesecake', 6);

INSERT INTO Drinks(id,name, price ) VALUES (17, 'Sprite', 3);
INSERT INTO Drinks(id,name, price ) VALUES (18, 'Coke', 3);
INSERT INTO Drinks(id,name, price ) VALUES (19, 'Fanta', 3);
INSERT INTO Drinks(id,name, price ) VALUES (20, 'Redbull', 3);

INSERT INTO PizzaIngredients VALUES (21, true,false,true,false,true,false,false, false,false,false,false,false,false,false,false,9);#pepperoni  drop it
INSERT INTO PizzaIngredients VALUES (22, false,true,true,false,true,false,false, false,false,false,false,false,false,false,false,9);#ham
INSERT INTO PizzaIngredients VALUES (23, false,false,true,true,true,false,false, false,false,false,false,false,false,false,false,7);#margarita
INSERT INTO PizzaIngredients VALUES (24, false,false,true,false,true,true,false, false,false,false,false,false,false,false,false,9);#chicken
INSERT INTO PizzaIngredients VALUES (25, false,false,true,false,true,false,true, false,false,false,false,false,false,false,false,8);#funghi
INSERT INTO PizzaIngredients VALUES (26, false,false,true,false,false,false,false, true,true,true,false,false,false,false,false,12);#fourcheese
INSERT INTO PizzaIngredients VALUES (27,true,false,true,false,true,false,true, false,false,false,false,true,false,false,false,13);#diavola
INSERT INTO PizzaIngredients VALUES (28,false,true,true,false,true,false,false, false,false,false,false,false,false,false,false,12);#hawai
INSERT INTO PizzaIngredients VALUES (29, false,false,true,false,true,false,false, false,false,false,false,false,true,true,true,10);#barbeque
INSERT INTO PizzaIngredients VALUES (30, false,false,true,false,true,false,true, false,false,false,false,false,false,true,false,12);#profunghi

INSERT INTO Pizzas VALUES(21,'Pepperoni',9,false);
INSERT INTO Pizzas VALUES(22,'Ham',9,false);
INSERT INTO Pizzas VALUES(23,'Margarita',7,true);
INSERT INTO Pizzas VALUES(24,'Chicken',9,false);
INSERT INTO Pizzas VALUES(25,'Funghi',8,true);
INSERT INTO Pizzas VALUES(26,'FourCheese',12,false);
INSERT INTO Pizzas VALUES(27,'Diavola',13,false);
INSERT INTO Pizzas VALUES(28,'Hawai',12,false);
INSERT INTO Pizzas VALUES(29,'Barbeque',10,false);
INSERT INTO Pizzas VALUES(30,'Prosciuto Funghi',12,false);

INSERT INTO MENU VALUES(15, 'Brownie', 6);
INSERT INTO MENU VALUES(16, 'Cheesecake', 6);
INSERT INTO MENU VALUES(17, 'Sprite', 3);
INSERT INTO MENU VALUES(18, 'Coke', 3);
INSERT INTO MENU VALUES(19, 'Fanta', 3);
INSERT INTO MENU VALUES(20, 'Redbull', 3);
INSERT INTO MENU VALUES(21, 'Pepperoni', 9);
INSERT INTO MENU VALUES(22, 'Ham', 9);
INSERT INTO MENU VALUES(23, 'Margarita', 7);
INSERT INTO MENU VALUES(24, 'Chicken', 9);
INSERT INTO MENU VALUES(25, 'Funghi', 8);
INSERT INTO MENU VALUES(26, 'FourCheese', 12);
INSERT INTO MENU VALUES(27, 'Diavola', 13);
INSERT INTO MENU VALUES(28, 'Hawai', 12);
INSERT INTO MENU VALUES(29, 'Barbeque', 10);
INSERT INTO MENU VALUES(30, 'Profunghi',12);

INSERT INTO Staff VALUES(1,'Tom', 0,0);
INSERT INTO Staff VALUES(2,'Mary', 0,0);
INSERT INTO Staff VALUES(3,'John', 0,0);
INSERT INTO Staff VALUES(4,'Molly', 0,0);
INSERT INTO Staff VALUES(5,'Liam', 0,0);






