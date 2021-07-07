use webstoredb;

insert into Users (username, password, isadmin) values
("imadmin", "123456", true),
("imuser", "123456", false);

insert into Categories (name) values 
("A"),
("B"),
("C");

insert into Products (name, description, categoryid, thumbnail, price) values
("A1", "testDescription1", 1, "https://i.ytimg.com/vi/RTfvXkEXa-k/maxresdefault.jpg", 1.2),
("A2", "testDescription2", 1, "https://i.ytimg.com/vi/XlUPuj2V6PM/maxresdefault.jpg", 1.4),
("B1", "testDescription3", 2, "https://i.ytimg.com/vi/Haj9TAFCv5w/maxresdefault.jpg", 0.2);
