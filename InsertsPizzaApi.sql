USE PizzaAPI;
select * from Customers;
INSERT INTO Customers(id, name, lastname, numberorder) VALUES(1, 'Juan', 'Escutia', 1);
INSERT INTO Customers(id, name, lastname, numberorder) VALUES(2, 'Pablo', 'Barrera', 1);
INSERT INTO Customers(id, name, lastname, numberorder) VALUES(3, 'Rimelque', 'Gomez', 1);

INSERT INTO Ingredients(id, name, price) VALUES(0, 'Pepperoni', 4);
INSERT INTO Ingredients(id, name, price) VALUES(1, 'Ham', 4);
INSERT INTO Ingredients(id, name, price) VALUES(2, 'Tomato', 2);
INSERT INTO Ingredients(id, name, price) VALUES(3, 'Herbs', 2);
INSERT INTO Ingredients(id, name, price) VALUES(4, 'Cheese', 3);
INSERT INTO Ingredients(id, name, price) VALUES(5, 'Chicken', 4);
INSERT INTO Ingredients(id, name, price) VALUES(6, 'Funghi', 3);
INSERT INTO Ingredients(id, name, price) VALUES(7, 'Cheddar', 3);
INSERT INTO Ingredients(id, name, price) VALUES(8, 'Gouda', 3);
INSERT INTO Ingredients(id, name, price) VALUES(9, 'Blue Cheese', 3);
INSERT INTO Ingredients(id, name, price) VALUES(10, 'Dutch Cheese', 3);
INSERT INTO Ingredients(id, name, price) VALUES(11, 'Salami', 4);
INSERT INTO Ingredients(id, name, price) VALUES(12, 'Pineapple', 3);
INSERT INTO Ingredients(id, name, price) VALUES(13, 'Olives', 2);
INSERT INTO Ingredients(id, name, price) VALUES(14, 'Barbeque sauce', 2);

INSERT INTO Desserts(id, name, price) VALUES(15, 'Brownie', 6);
INSERT INTO Desserts(id, name, price) VALUES(16, 'Cheesecake', 6);

INSERT INTO Drinks(id,name, price ) VALUES (17, 'Sprite', 3);
INSERT INTO Drinks(id,name, price ) VALUES (18, 'Coke', 3);