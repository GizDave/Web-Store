drop database if exists webstoredb;
create database webstoredb;
use webstoredb;

create table Categories (
	categoryid		int				primary key			auto_increment,
    name			varchar(30)
);

create table Products (
	productid		int				primary key 		auto_increment,
    name			varchar(30),
    description		text,
    categoryid		int,
    thumbnail 		text,
    price			decimal(10,2),
    foreign key (categoryid) references Categories(categoryid)
);

create table Stock (
	stockid			int				primary key			auto_increment,
    productid		int,
    instock			bool			default false,
    quantity		int				default 0,
    foreign key (productid) references Products(productid)
);

create table Users (
	userid			int				primary key			auto_increment,
    username		varchar(30) 	not null,
    password		varchar(30)		not null,
    isadmin			bool			default false
);

create table Customers (
	customerid		int				primary key			auto_increment,
    userid			int,
    first_name		varchar(30),
    last_name		varchar(30),
    phone			varchar(30),
    email			varchar(60),
    foreign key (userid) references Users(userid)
);

create table Addresses (
	addressid		int				primary key			auto_increment,
    street			varchar(60),
	city			varchar(30),
	state			varchar(30),
    zipcode			varchar(15),
    country			varchar(30)
);

create table Customer_Address_Bridge (
	customerid		int,
    addressid		int,
    primary key(customerid, addressid),
    foreign key (customerid) references Customers(customerid),
    foreign key (addressid) references Addresses(addressid)
);

create table Images (
	imageid			int				primary key			auto_increment,
    productid		int,
    image_path		text,
    foreign key (productid) references Products(productid)
);

create table Customer_Payments (
	paymentmethodid	int				primary key			auto_increment,
    customerid		int,
    card_number		varchar(30),
    foreign key (customerid) references Customers(customerid)
);

create table Customer_Orders (
	orderid			int				primary key			auto_increment,
    paymentmethodid	int,
    customerid		int,
    date_ordered	datetime,
    total_price		decimal(10,2),
    foreign key (paymentmethodid) references Customer_Payments(paymentmethodid),
    foreign key (customerid) references Customers(customerid)
);

create table Customer_Order_Product_Bridge (
	orderid			int,
    productid		int,
    quantity		int,
    primary key(orderid, productid),
    foreign key (orderid) references Customer_Orders(orderid),
    foreign key (productid) references Products(productid)
);
