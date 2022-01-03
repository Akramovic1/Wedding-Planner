CREATE SCHEMA wedding_planner;
USE wedding_planner;

# Creating tables
CREATE TABLE users(
ID INT NOT NULL,
email VARCHAR(30) NOT NULL,
password VARCHAR(28) NOT NULL,
type VARCHAR(10) NOT NULL,
username VARCHAR(15) NOT NULL,
phonenumber VARCHAR(15) DEFAULT NULL,
PRIMARY KEY(ID),
CONSTRAINT Check_User_Type CHECK (type IN ('admin', 'sp', 'customer')),
UNIQUE (email)
);

CREATE TABLE services(
ID INT NOT NULL,
type VARCHAR(10) NOT NULL,
PRIMARY KEY(ID),
CONSTRAINT Check_Service_Type CHECK (type IN ('person', 'place'))
);

CREATE TABLE persons(
ID INT NOT NULL,
name VARCHAR(32) NOT NULL,
description VARCHAR(300) NOT NULL,
rate FLOAT NOT NULL,
owner_ID INT NOT NULL,
cost INT,
job VARCHAR(20),
PRIMARY KEY(ID),
CONSTRAINT Persons_ID_FK FOREIGN KEY (ID) REFERENCES services(ID) ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT Owner_ID_Persons_FK FOREIGN KEY (owner_ID) REFERENCES users(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE places(
ID INT NOT NULL,
name VARCHAR(32) NOT NULL,
description VARCHAR(300) NOT NULL,
rate FLOAT NOT NULL,
owner_ID INT NOT NULL,
cost INT NOT NULL,
location VARCHAR(20) NOT NULL,
capacity INT NOT NULL,
category VARCHAR(20),
PRIMARY KEY(ID),
CONSTRAINT Places_ID_FK FOREIGN KEY (ID) REFERENCES services(ID) ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT Owner_ID_Places_FK FOREIGN KEY (owner_ID) REFERENCES users(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE busy(
ID INT NOT NULL,
date DATE NOT NULL,
PRIMARY KEY(ID,date),
CONSTRAINT Busy_Service_ID_FK FOREIGN KEY (ID) REFERENCES services(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE person_locations(
ID INT NOT NULL,
location VARCHAR(24) NOT NULL,
PRIMARY KEY(ID,location),
CONSTRAINT Person_Location_ID_FK FOREIGN KEY (ID) REFERENCES persons(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE pictures(
ID INT NOT NULL,
URL VARCHAR(128) NOT NULL,
PRIMARY KEY(ID,url),
CONSTRAINT Pictures_ID_FK FOREIGN KEY (ID) REFERENCES services(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

# Creating Stored procedures
USE DELIMITER //
CREATE PROCEDURE get_service(service_ID INT)
BEGIN
	SET @service_table = (SELECT type FROM services WHERE ID = service_ID);
	IF @service_table = "place" THEN
		 (SELECT  * FROM (places NATURAL JOIN services) WHERE ID = service_ID);
	ELSE
		 (SELECT  * FROM (persons NATURAL JOIN services)  WHERE ID = service_ID);
	END IF;
END//
USE DELIMITER ;

# Adding administrators
INSERT INTO users VALUES(0,"amrmomtaz@gmail.com","momtaz","admin","amrmomtaz","01060682208");
INSERT INTO users VALUES(1,"mohamedradwan@gmail.com","radwan","admin","radwan","01000000000");
INSERT INTO users VALUES(2,"moemenibrahim@gmail.com","moemen","admin","moemen","011000000000");
INSERT INTO users VALUES(3,"mostafaahmed@gmail.com","mostafa","admin","mostafaahmed","012000000000");
INSERT INTO users VALUES(4,"ahmedakram@gmail.com","akram","admin","ahmedakram",NULL);
INSERT INTO users VALUES(5,"rana@gmail.com","rana","admin","rana",NULL);

# Adding service providers
INSERT INTO users VALUES(6,"moemen@gmail.com","moemen","sp","moemen",NULL);
INSERT INTO users VALUES(7,"kolibaly@gmail.com","kolibaly","sp","kolibaly",NULL);
INSERT INTO users VALUES(8,"hassan@gmail.com","hassan","sp","hassan",NULL);

# Adding customers
INSERT INTO users VALUES(9,"yamenwalid@gmail.com","yamen","customer","yamen",NULL);
INSERT INTO users VALUES(10,"youssefsameh@gmail.com","ysa","customer","ysa",NULL);
INSERT INTO users VALUES(11,"marwanshokry@gmail.com","marwan","customer","shika",NULL);
INSERT INTO users VALUES(12,"mohamedihab@gmail.com","bob","customer","bob",NULL);
INSERT INTO users VALUES(13,"nabilkhaled@gmail.com","nabil","customer","nabilkhaled",NULL);
INSERT INTO users VALUES(14,"mohamedezz@gmail.com","ezz","customer","azooz",NULL);
INSERT INTO users VALUES(15,"tarekghanem@gmail.com","tarek","customer","tico",NULL);

# Adding services
INSERT INTO services VALUES (0,"place");
INSERT INTO places VALUES (0,"Wedding Hall A","This is the first wedding hall",9.6,6,200000,"alexandria",2000,"wedding hall");

INSERT INTO services VALUES (1,"place");
INSERT INTO places VALUES (1,"Wedding Hall B","This is the second wedding hall",8.4,7,150000,"cairo",1500,"wedding hall");

INSERT INTO services VALUES (2,"place");
INSERT INTO places VALUES (2,"Wedding Hall C","This is the third wedding hall",7.9,8,100000,"dahab",1000,"wedding hall");

INSERT INTO services VALUES (3,"person");
INSERT INTO persons VALUES (3,"Photographer A", "I'm photographer A",8.5,6,8000,"photographer");

INSERT INTO services VALUES (4,"person");
INSERT INTO persons VALUES (4,"Photographer B", "I'm photographer B",9.7,7,10000,"photographer");

INSERT INTO services VALUES (5,"person");
INSERT INTO persons VALUES (5,"Photographer C", "I'm photographer C",9,8,9000,"photographer");