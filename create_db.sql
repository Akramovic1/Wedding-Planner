CREATE SCHEMA wedding_planner;
USE wedding_planner;

CREATE TABLE users(
id INT NOT NULL,
email VARCHAR(30) NOT NULL,
password VARCHAR(28) NOT NULL,
type VARCHAR(10) NOT NULL,
username VARCHAR(15) NOT NULL,
phonenumber VARCHAR(15) DEFAULT NULL,
PRIMARY KEY(id),
UNIQUE (email)
);

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