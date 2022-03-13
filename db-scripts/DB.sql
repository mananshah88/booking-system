CREATE table city(
        id bigint NOT NULL AUTO_INCREMENT primary key,
        name varchar(100) NOT NULL,
        state varchar(100) NOT NULL,
        country varchar(100) NOT NULL,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into city values (11, 'Ahmedabad', 'Gujarat', 'India', 'active',1,1,now(),now());
insert into city values (12, 'Baroda', 'Gujarat', 'India', 'active',1,1,now(),now());

CREATE table customer(
        id bigint NOT NULL AUTO_INCREMENT primary key,
        firstName varchar(100) NOT NULL,
        lastName varchar(100) NULL,
        email varchar(100) NOT NULL,
        mobileNumber decimal(12,0) NOT NULL,
        gender varchar(10) NOT NULL,
        type int NOT NULL,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
INSERT into customer values (101, 'David', 'Backham', 'a@b.com', 8460893274, 'male', 3, 'active', 1,1,now(),now());

CREATE table theater(
        id bigint NOT NULL AUTO_INCREMENT primary key,
        name varchar(100) NOT NULL,
        partnerId int NOT NULL,
        cityId int NOT NULL,
        address TEXT NOT NULL,
        pincode double NOT NULL,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into theater values (1, 'PVR Cinemas', 101, 11, "Address of the Theater", 380008, 'active',1,1,now(),now());

CREATE table screen(
        id bigint NOT NULL AUTO_INCREMENT primary key,
        name varchar(100) NOT NULL,
        theaterId int NOT NULL,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into screen values (1, "screen 1", 1, 'active',1,1,now(),now());
insert into screen values (2, "screen 2", 1, 'active',1,1,now(),now());
insert into screen values (3, "screen 3", 1, 'active',1,1,now(),now());
insert into screen values (4, "screen 4", 1, 'active',1,1,now(),now());
	
CREATE table movie_timeslot(
        id bigint NOT NULL AUTO_INCREMENT primary key,
        screenId int NOT NULL,
        movieId varchar(30) NOT NULL,
        timeslot datetime NOT NULL,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into movie_timeslot values (1, 5, "movie1", now(), 'active',1,1,now(),now());
insert into movie_timeslot values (2, 5, "movie2", now(), 'active',1,1,now(),now());

CREATE table seat_details(
        id bigint NOT NULL AUTO_INCREMENT primary key,
        movietimeslotId int NOT NULL,
        seatcategory varchar(10) NOT NULL,
        positionRowNo int NOT NULL,
        positionOrderFromLeft int NOT NULL,
        seatName varchar(10) NOT NULL,
        price DECIMAL(8,2) DEFAULT 0,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into seat_details values (1, 1, "Gold", 1, 1, 'A1', 50.50, 'active',1,1,now(),now());

CREATE table seat_reservation (
        id bigint NOT NULL AUTO_INCREMENT primary key,
        version int NOT NULL DEFAULT 1,
        seatId int NOT NULL,
        bookingStatus int DEFAULT 0,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp(),
  	CONSTRAINT seatId_unique UNIQUE (seatId)
);
INSERT INTO seat_reservation values (1, 1, 1, 0, 'active',1,1,now(),now());

CREATE table purchase (
        id bigint NOT NULL AUTO_INCREMENT primary key,
        priceForSingleTicket  DECIMAL(8,2) DEFAULT NULL,
        quantity int NOT NULL,
        totalamount DECIMAL(8,2)  DEFAULT NULL,
        tax DECIMAL(8,2) DEFAULT NULL,
        promotionCode varchar(20) DEFAULT NULL,
        discount DECIMAL(8,2)  DEFAULT NULL,
        payableamount DECIMAL(8,2)  DEFAULT NULL,
        bookingStatus int DEFAULT NULL,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into purchase values (1, 5, '100.0', '250.0', '36.0', 'MYBOOKING15', '15.0', '271.0', 2, 'active',1,1,now(),now());
insert into purchase values (2, 5, '100.0', '250.0', '36.0',  null, '0.0', '286.0', 4, 'active',1,1,now(),now());

create table purchase_item (
        id bigint NOT NULL AUTO_INCREMENT primary key,
	purchaseId int NOT NULL,        
        seatId int NOT NULL,
        price DECIMAL(8,2) DEFAULT NULL,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into purchase_item values (1, 1, 1, '250.0', 'active',1,1,now(),now());
insert into purchase_item values (2, 1, 2, '250.0', 'active',1,1,now(),now());

create table orders (
        id bigint NOT NULL AUTO_INCREMENT primary key,
	purchaseId int NOT NULL,
	paymentId int NOT NULL,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
INSERT INTO orders values (1,1,1,'active',1,1,now(),now());

create table promotion (
        id bigint NOT NULL AUTO_INCREMENT primary key,
        promotionCode varchar(20) NOT NULL,
        name varchar(20) NOT NULL NOT NULL,
        type varchar(20) NOT NULL NOT NULL,
        description text DEFAULT NULL,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into promotion values (1, 'MYBOOK10', 'MYBOOK10', 'manual', '','active',1,1,now(),now());

create table promotion_entity (
        id bigint NOT NULL AUTO_INCREMENT primary key,
	promotionId int NOT NULL,
	entityType varchar(20) NOT NULL DEFAULT 'overall', /* overall, individual */
	entityValue varchar(20) DEFAULT NULL, /* 3rd ticket */
	entityOperator varchar(20) DEFAULT NULL, /* any, onwards */
	promotionType varchar(10) NOT NULL, /* Fixed,Percentage*/ 
	promotionValue double DEFAULT 0,  /* 50 */
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into promotion_entity values (1, 1, 'overall', '', 'any', 'fixed', '50', 'active',1,1,now(),now());

create table promotion_restriction (
        id bigint NOT NULL AUTO_INCREMENT primary key,
	promotionId int NOT NULL,
	conditionType varchar(20) NOT NULL, /* 'city', 'theater', 'nooftickets', 'showtime' */
	conditionValue varchar(20) NOT NULL,
	conditionOperator varchar(20) NOT NULL, /* 'eq','neq','in','nin','gt','lt','gte','lte', */
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into promotion_restriction values (1, 1, 'city', 'ahmedabad', 'eq', 'active',1,1,now(),now());


