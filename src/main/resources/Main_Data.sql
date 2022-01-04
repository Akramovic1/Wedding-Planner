USE wedding_planner;
#Adding Service providers
INSERT INTO users VALUES(0,"amrmomtaz@gmail.com","12345678","admin","AmrMomtaz","010");
INSERT INTO users VALUES(1,"radwan@gmail.com","12345678","sp","Radwan","11");
INSERT INTO users VALUES(2,"moemen@gmail.com","12345678","sp","Moemen","12");
INSERT INTO users VALUES(3,"mostafa@gmail.com","12345678","sp","Mostafa","15");
INSERT INTO users VALUES(4,"akram@gmail.com","12345678","customer","Akram","15");
INSERT INTO users VALUES(5,"rana@gmail.com","12345678","customer","Rana","15");

#Adding Serivces
INSERT INTO services VALUES(1,"place");
INSERT INTO services VALUES(2,"place");
INSERT INTO services VALUES(3,"place");
INSERT INTO services VALUES(4,"place");
INSERT INTO services VALUES(5,"place");
INSERT INTO services VALUES(6,"place");
INSERT INTO services VALUES(7,"place");
INSERT INTO services VALUES(8,"place");
INSERT INTO services VALUES(9,"place");
INSERT INTO services VALUES(10,"place");
INSERT INTO services VALUES(11,"person");
INSERT INTO services VALUES(12,"person");
INSERT INTO services VALUES(13,"person");
INSERT INTO services VALUES(14,"person");
INSERT INTO services VALUES(15,"person");
INSERT INTO services VALUES(16,"person");
INSERT INTO services VALUES(17,"person");
INSERT INTO services VALUES(18,"person");
INSERT INTO services VALUES(19,"person");
INSERT INTO services VALUES(20,"person");

#Adding Places
INSERT INTO places VALUES(1,"Wedding Hall A","description for hall A",9.6,1,200000,"alexandria",2000,"wedding hall");
INSERT INTO places VALUES(2,"Wedding Hall B","description for hall B",9.4,1,180000,"alexandria",1800,"wedding hall");
INSERT INTO places VALUES(3,"Wedding Hall C","description for hall C",8.3,1,60000,"alexandria",600,"wedding hall");
INSERT INTO places VALUES(4,"Wedding Hall D","description for hall D",8.9,1,140000,"alexandria",1400,"wedding hall");
INSERT INTO places VALUES(5,"Wedding Hall E","description for hall E",9.1,2,160000,"cairo",1600,"wedding hall");
INSERT INTO places VALUES(6,"Wedding Hall F","description for hall F",7.5,2,40000,"cairo",400,"wedding hall");
INSERT INTO places VALUES(7,"Wedding Hall G","description for hall G",8.4,2,75000,"cairo",750,"wedding hall");
INSERT INTO places VALUES(8,"Wedding Hall H","description for hall H",6.9,3,65000,"cairo",650,"wedding hall");
INSERT INTO places VALUES(9,"Wedding Hall I","description for hall I",7.8,3,70000,"aswan",700,"wedding hall");
INSERT INTO places VALUES(10,"Wedding Hall J","description for hall J",7.7,3,45000,"aswan",450,"wedding hall");

#Adding Persons
INSERT INTO persons VALUES(11,"Photographer A","Description for Photographer A",9.6,1,20000,"photographer");
INSERT INTO persons VALUES(12,"Photographer B","Description for Photographer B",9.4,1,18000,"photographer");
INSERT INTO persons VALUES(13,"Photographer C","Description for Photographer C",8.3,2,6000,"photographer");
INSERT INTO persons VALUES(14,"Photographer D","Description for Photographer D",8.9,2,14000,"photographer");
INSERT INTO persons VALUES(15,"Photographer E","Description for Photographer F",9.1,3,16000,"photographer");
INSERT INTO persons VALUES(16,"Makeup artist A","Description for Makeup artist A",7.5,1,4000,"makeup artist");
INSERT INTO persons VALUES(17,"Makeup artist B","Description for Makeup artist B",8.4,2,7500,"makeup artist");
INSERT INTO persons VALUES(18,"Makeup artist C","Description for Makeup artist C",6.9,2,6500,"makeup artist");
INSERT INTO persons VALUES(19,"Makeup artist D","Description for Makeup artist D",7.8,3,7000,"makeup artist");
INSERT INTO persons VALUES(20,"Makeup artist E","Description for Makeup artist E",7.7,3,4500,"makeup artist");

#Adding Persons Location
INSERT INTO person_locations VALUES(11,"alexandria");
INSERT INTO person_locations VALUES(11,"cairo");
INSERT INTO person_locations VALUES(12,"alexandria");
INSERT INTO person_locations VALUES(12,"cairo");
INSERT INTO person_locations VALUES(13,"cairo");
INSERT INTO person_locations VALUES(14,"alexandria");
INSERT INTO person_locations VALUES(15,"alexandria");
INSERT INTO person_locations VALUES(15,"cairo");
INSERT INTO person_locations VALUES(16,"cairo");
INSERT INTO person_locations VALUES(16,"giza");
INSERT INTO person_locations VALUES(17,"alexandria");
INSERT INTO person_locations VALUES(17,"cairo");
INSERT INTO person_locations VALUES(18,"alexandria");
INSERT INTO person_locations VALUES(18,"cairo");
INSERT INTO person_locations VALUES(18,"aswan");
INSERT INTO person_locations VALUES(19,"cairo");
INSERT INTO person_locations VALUES(20,"alexandria");

#Adding busy dates
INSERT INTO busy VALUES (1,"2022-01-07");
INSERT INTO busy VALUES (1,"2022-01-08");
INSERT INTO busy VALUES (1,"2022-01-09");
INSERT INTO busy VALUES (1,"2022-01-12");
INSERT INTO busy VALUES (1,"2022-01-13");
INSERT INTO busy VALUES (2,"2022-01-07");
INSERT INTO busy VALUES (2,"2022-01-08");
INSERT INTO busy VALUES (2,"2022-01-17");
INSERT INTO busy VALUES (3,"2022-01-09");
INSERT INTO busy VALUES (3,"2022-01-10");
INSERT INTO busy VALUES (4,"2022-01-15");
INSERT INTO busy VALUES (5,"2022-01-09");
INSERT INTO busy VALUES (5,"2022-01-17");
INSERT INTO busy VALUES (6,"2022-01-07");
INSERT INTO busy VALUES (6,"2022-01-16");
INSERT INTO busy VALUES (7,"2022-01-29");
INSERT INTO busy VALUES (8,"2022-01-20");
INSERT INTO busy VALUES (9,"2022-01-25");
INSERT INTO busy VALUES (10,"2022-01-07");
INSERT INTO busy VALUES (11,"2022-01-14");
INSERT INTO busy VALUES (11,"2022-01-19");
INSERT INTO busy VALUES (12,"2022-01-14");
INSERT INTO busy VALUES (12,"2022-01-28");
INSERT INTO busy VALUES (13,"2022-01-07");
INSERT INTO busy VALUES (13,"2022-01-16");
INSERT INTO busy VALUES (14,"2022-01-17");
INSERT INTO busy VALUES (14,"2022-01-27");
INSERT INTO busy VALUES (15,"2022-01-14");
INSERT INTO busy VALUES (15,"2022-01-16");
INSERT INTO busy VALUES (16,"2022-01-07");
INSERT INTO busy VALUES (17,"2022-01-07");
INSERT INTO busy VALUES (18,"2022-01-11");
INSERT INTO busy VALUES (19,"2022-02-01");
INSERT INTO busy VALUES (20,"2022-01-21");