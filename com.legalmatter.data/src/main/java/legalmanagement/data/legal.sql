CREATE Database if not exists legal_directory;

Use legal_directory;


DROP TABLE if exists attorney;

CREATE TABLE attorney (
`attorneyId` BIGINT(10) NOT NULL AUTO_INCREMENT,
`firstName` VARCHAR(45) DEFAULT NULL,
`lastName` VARCHAR(45) DEFAULT NULL,
`otherName` VARCHAR(45) DEFAULT NULL,
`username` VARCHAR(45) DEFAULT NULL,
`title` VARCHAR(45) DEFAULT NULL,
`email` VARCHAR(45) DEFAULT NULL,
`password` VARCHAR(100) DEFAULT NULL,
`phoneNumber` VARCHAR(100) DEFAULT NULL,
`enrollmentNumber` VARCHAR(45) DEFAULT NULL,
`enrollmentYear` VARCHAR(45) DEFAULT NULL,
`callToBarCertNumber` VARCHAR(45) DEFAULT NULL,
`nationality` VARCHAR(45) DEFAULT NULL,
PRIMARY KEY (`AttorneyId`)
);

INSERT into attorney values (1, 'Olabisi', 'Ogundairo', 'O','QueenBEE', 'Barrister', 'faeyemi@gmail.com',
'123qwerty', '221100045', 'AQ1235778', '2005', '10000023', 'Ukraine');


DROP TABLE if exists client;

CREATE TABLE client (
`clientId` INT(10) NOT NULL AUTO_INCREMENT,
`firstName` VARCHAR(45) DEFAULT NULL,
`lastName` VARCHAR(45) DEFAULT NULL,
`otherName` VARCHAR(45) DEFAULT NULL,
`username` VARCHAR(45) DEFAULT NULL,
`email` VARCHAR(45) DEFAULT NULL,
`password` VARCHAR(45) DEFAULT NULL,
`phoneNumber` VARCHAR(45) DEFAULT NULL,
`nationality` VARCHAR(45) DEFAULT NULL,
PRIMARY KEY (`clientId`)
);

INSERT into client VALUES
(1, 'Olamide', 'Fadare', 'C', 'pcolamide', 'Olamidefadare@gmail.com', 'asdfgh', '090999999944', 'Niger');



DROP TABLE if exists clientCompany;

CREATE TABLE clientCompany (
`clientCompanyId` INT(10) NOT NULL AUTO_INCREMENT,
`companyName` VARCHAR(45) DEFAULT NULL,
`companyAddress` VARCHAR(45) DEFAULT NULL,
`companyEmail` VARCHAR(45) DEFAULT NULL,
`companyPhoneNumber` VARCHAR(45) DEFAULT NULL,
`city` VARCHAR(45) DEFAULT NULL,
`LGA` VARCHAR(45) DEFAULT NULL,
`state` VARCHAR(45) DEFAULT NULL,
PRIMARY KEY (`clientCompanyId`)
);

INSERT into clientCompany VALUES
(1, 'Olamide Corporate World Inc', '234, Fadare Crescent off Bourdele way; Niger',
 'OlaCoporateWorld@coporate.inc.uk', '21109455345', 'Ankara', 'Urbui', 'Korvi');



DROP TABLE if exists lawFirm;

CREATE TABLE lawFirm (
`lawFirmId` INT(10) NOT NULL AUTO_INCREMENT,
`lawFirmName` VARCHAR(45) DEFAULT NULL,
`lawFirmAddress` VARCHAR(45) DEFAULT NULL,
`lawFirmPhoneNumber` VARCHAR(45) DEFAULT NULL,
`lawFirmEmail` VARCHAR(45) DEFAULT NULL,
`lawFirmRegNumber` VARCHAR(45) DEFAULT NULL,
`city` VARCHAR(45) DEFAULT NULL,
`LGA` VARCHAR(45) DEFAULT NULL,
`state` VARCHAR(45) DEFAULT NULL,
PRIMARY KEY (`lawFirmId`)
);

INSERT into lawFirm VALUE
(1, 'Delano and Delano Solicitors Ltd', '201, Ligali Ayorinde way',
 '23400999943', 'delanoanddelano@gmail.com', '23886M', 'VI', 'Eti-Osa', 'Lagos');



DROP TABLE if exists roles;

CREATE TABLE roles(
`roleId` BIGINT(10) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) DEFAULT NULL,
PRIMARY KEY (`roleId`)
);



DROP TABLE if exists attorney_roles;

CREATE TABLE attorney_roles(
`id` BIGINT(10) NOT NULL AUTO_INCREMENT,
`attorneyId` BIGINT(10) NOT NULL,
`roleId` BIGINT(10) NOT NULL,
PRIMARY KEY(`id`)
);


#alter table attorney_roles
#add constraint attorney_roles_PK primary key(id);

#alter table attorney_roles
#add constraint attorney_roles_UK unique(attorneyId,roleId);

#alter table attorney_roles
#add constraint attorney_roles_FK1 foreign key(AttorneyId)
#reference Attorney(attorneyId);

#alter table attorney_roles
#add constraint attorney_roles_FK2 foreign key(roleId)
#reference roles(roleId);

DROP TABLE if EXISTS Persistent_Logins;

CREATE TABLE Persistent_Logins (

`username` varchar(64) not null,
`series` varchar(64) not null,
`token` varchar(64) not null,
`last_used` timestamp not null,
PRIMARY KEY (series)
);
