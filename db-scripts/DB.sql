CREATE table city(
        id bigint NOT NULL AUTO_INCREMENT primary key,
        name varchar(100) NOT NULL,
        state varchar(100) NOT NULL,
        country varchar(100) NOT NULL,
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into city values (11, 'Ahmedabad', 'Gujarat', 'India', 1,1,now(),now());
insert into city values (12, 'Baroda', 'Gujarat', 'India', 1,1,now(),now());

CREATE table customer(
        id bigint NOT NULL AUTO_INCREMENT primary key,
        firstName varchar(100) NOT NULL,
        lastName varchar(100) NULL,
        email varchar(100) NOT NULL,
        mobileNumber decimal(12,0) NOT NULL,
        gender varchar(10) NOT NULL,
        type int NOT NULL,
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
INSERT into customer values (101, 'David', 'Backham', 'a@b.com', 8460893274, 'male', 3, 1,1,now(),now());

CREATE table theater(
        id bigint NOT NULL AUTO_INCREMENT primary key,
        name varchar(100) NOT NULL,
        partnerId int NOT NULL,
        cityId int NOT NULL,
        address TEXT NOT NULL,
        pincode double NOT NULL,
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into theater values (1, 'PVR Cinemas', 101, 11, "Address of the Theater", 380008, 1,1,now(),now());

CREATE table screen(
        id bigint NOT NULL AUTO_INCREMENT primary key,
        name varchar(100) NOT NULL,
        theaterId int NOT NULL,
        capacity int NOT NULL,
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into screen values (1, "screen 1", 1, 50, 1,1,now(),now());
insert into screen values (2, "screen 2", 1, 60, 1,1,now(),now());
insert into screen values (3, "screen 3", 1, 70, 1,1,now(),now());
insert into screen values (4, "screen 4", 1, 80, 1,1,now(),now());
	
CREATE table bookingtype(
        id bigint NOT NULL AUTO_INCREMENT primary key,
        name varchar(100) NOT NULL,
        displayName varchar(100) NOT NULL,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into bookingtype values (1, 'Recliners', 'Recliners', 'active',1,1,now(),now());
insert into bookingtype values (2, 'Gold', 'Gold', 'active',1,1,now(),now());
insert into bookingtype values (3, 'Executive', 'Executive', 'active',1,1,now(),now());
insert into bookingtype values (4, 'Upper Circle', 'Upper Circle', 'active',1,1,now(),now());
insert into bookingtype values (5, 'Delux Circle', 'Delux Circle', 'active',1,1,now(),now());
insert into bookingtype values (6, 'Box', 'Box', 'active',1,1,now(),now());
insert into bookingtype values (7, 'Balcony', 'Balcony', 'active',1,1,now(),now());

CREATE table bookingunit(
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
insert into bookingunit values (1, 5, "movie1", now(), 'active',1,1,now(),now());
insert into bookingunit values (2, 5, "movie2", now(), 'active',1,1,now(),now());

CREATE table bookingunit_price(
        id bigint NOT NULL AUTO_INCREMENT primary key,
        bookingTypeId int NOT NULL,
        price double DEFAULT 0,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into bookingunit_price values (1, 1, 10.0, 'active',1,1,now(),now());
insert into bookingunit_price values (2, 2, 20.0, 'active',1,1,now(),now());

CREATE table bookingunit_capacity(
        id bigint NOT NULL AUTO_INCREMENT primary key,
        bookingTypeId int NOT NULL,
        totalSeats int NOT NULL default 0,
        availableSeats int  NOT NULL default 0,
        status varchar(10) DEFAULT 'active',
        created int(11) DEFAULT 0,
  	lastModified int(11) DEFAULT 0,
  	createdDate datetime NOT NULL,
  	lastModifiedDate datetime DEFAULT current_timestamp()
);
insert into bookingunit_capacity values (1, 1, 50, 50, 'active', 1,1,now(),now());
insert into bookingunit_capacity values (2, 2, 100, 100, 'active', 1,1,now(),now());

