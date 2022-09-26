USE PizzaAPI;
select * from Customers;
INSERT INTO Customers(id, name, lastname, numberorder,adress) VALUES(1, 'Juan', 'Escutia', 0, '11th street');
INSERT INTO Customers(id, name, lastname, numberorder,adress) VALUES(2, 'Pablo', 'Barrera', 0, '12th street');
INSERT INTO Customers(id, name, lastname, numberorder,adress) VALUES(3, 'Rimelque', 'Gomez', 0, '13th street');

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

INSERT INTO PizzaIngredients VALUES (0, true,false,true,false,true,false,false, false,false,false,false,false,false,false,false,9);#pepperoni
INSERT INTO PizzaIngredients VALUES (1, false,true,true,false,true,false,false, false,false,false,false,false,false,false,false,9);#ham
INSERT INTO PizzaIngredients VALUES (2, false,false,true,true,true,false,false, false,false,false,false,false,false,false,false,7);#margarita
INSERT INTO PizzaIngredients VALUES (3, false,false,true,false,true,true,false, false,false,false,false,false,false,false,false,9);#chicken
INSERT INTO PizzaIngredients VALUES (4, false,false,true,false,true,false,true, false,false,false,false,false,false,false,false,8);#funghi
INSERT INTO PizzaIngredients VALUES (5, false,false,true,false,false,false,false, true,true,true,false,false,false,false,false,12);#fourcheese
INSERT INTO PizzaIngredients VALUES (6,true,false,true,false,true,false,true, false,false,false,false,true,false,false,false,13);#diavola
INSERT INTO PizzaIngredients VALUES (7, false,true,true,false,true,false,false, false,false,false,false,false,false,false,false,12);#hawai
INSERT INTO PizzaIngredients VALUES (8, false,false,true,false,true,false,false, false,false,false,false,false,true,true,true,10);#barbeque
INSERT INTO PizzaIngredients VALUES (9, false,false,true,false,true,false,true, false,false,false,false,false,false,true,false,12);#profunghi


