-- CREATE DATABASE "Train"
-- WITH
-- OWNER = postgres
-- ENCODING = 'UTF8'
-- CONNECTION LIMIT = -1;

INSERT INTO Ticket (price, state, buyDate, sitNumber) VALUES (100, 'FORSELL','27.07.2017', 13);
INSERT INTO Ticket (price, state, buyDate, sitNumber) VALUES (100, 'FORSELL', '27.07.2017', 13);
INSERT INTO Ticket (price, state, buyDate, sitNumber) VALUES (100, 'FORSELL', '23.07.2017', 13);


INSERT INTO Train (type, sitscount, trainnumber, departdt, destdt) VALUES ('fast', 50, 1, '29.07.2017', '31.07.2017');
INSERT INTO Train (type, sitscount, trainnumber, departdt, destdt) VALUES ('fast', 45, 2, '23.07.2017', '27.07.2017');
INSERT INTO Train (type, sitscount, trainnumber, departdt, destdt) VALUES ('fast', 33, 3, '22.07.2017', '23.07.2017');

INSERT INTO Customer (name) VALUES ('Vasya');
INSERT INTO Customer (name) VALUES ('Lena');