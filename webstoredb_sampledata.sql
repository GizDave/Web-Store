use webstoredb;

insert into Users (username, password, isadmin) values
("imadmin", "123456", true),
("imuser1", "123456", false),
("imuser2", "123456", false);

insert into Categories (name) values 
("A"),
("B"),
("C");

insert into Products (name, description, categoryid, thumbnail, price) values
("A1", "testDescription1", 1, "https://i.ytimg.com/vi/RTfvXkEXa-k/maxresdefault.jpg", 1.2),
("A2", "testDescription2", 1, "https://i.ytimg.com/vi/XlUPuj2V6PM/maxresdefault.jpg", 1.4),
("A3", "testDescription3", 1, "https://i.ytimg.com/vi/Haj9TAFCv5w/maxresdefault.jpg", 1.6),
("B1", "testDescription4", 2, "https://i.ytimg.com/vi/XkTsdHlMXZM/maxresdefault.jpg", 0.2),
("B2", "testDescription5", 2, "https://i.ytimg.com/vi/2cSVLjqTMU4/maxresdefault.jpg", 0.4),
("C1", "testDescription6", 3, "https://thumbs.dreamstime.com/z/animal-alphabet-f-13450939.jpg", 10);

insert into Stock (productid, instock, quantity) values
(1, true, 10),
(2, true, 1),
(3, false, 10),
(4, false, 0),
(5, true, 6),
(6, true, 100);

insert into Customers (userid, first_name, last_name, phone, email) values 
(1, "im", "admin", "1234567890", "im.admin@mthree.com"), 
(2, "im", "user1", "0000000000", "im.user1@mthree.com"), 
(3, "im", "user2", "0000000000", "im.user2@mthree.com");

insert into Customer_Payments (customerid, card_number) values 
(2, 4673763931227905);