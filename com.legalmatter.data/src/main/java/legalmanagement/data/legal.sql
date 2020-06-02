CREATE Database if not exists legal_directory;

Use legal_directory;



DROP TABLE if exists attorney;

CREATE TABLE attorney (
`attorney_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(45) DEFAULT NULL,
`last_name` VARCHAR(45) DEFAULT NULL,
`other_name` VARCHAR(45) DEFAULT NULL,
`username` VARCHAR(45) DEFAULT NULL,
`title` VARCHAR(45) DEFAULT NULL,
`email` VARCHAR(45) DEFAULT NULL,
`password` VARCHAR(100) DEFAULT NULL,
`phone_number` VARCHAR(45) DEFAULT NULL,
`enrollment_number` VARCHAR(45) DEFAULT NULL,
`enrollment_year` VARCHAR(45) DEFAULT NULL,
`call_to_bar_cert_number` VARCHAR(45) DEFAULT NULL,
`nationality` VARCHAR(45) DEFAULT NULL,
PRIMARY KEY (`attorney_id`)
);

INSERT into attorney values
(1, 'Olabisi', 'Ogundairo', 'O','QueenBEE', 'Barrister', 'faeyemi@gmail.com',
'123qwerty', '221100045', 'AQ1235778', '2005', '10000023', 'Ukraine'),
(2, 'Mayor', 'Immanuel', 'P','Alpha', 'Barrister', 'Imma.peter@yahoo.com',
'asdfl890', '09876544322', 'AQB1235778', '2002', '10120023', 'Cyprus');




DROP TABLE if exists client;

CREATE TABLE client (
`client_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(45) DEFAULT NULL,
`last_name` VARCHAR(45) DEFAULT NULL,
`other_name` VARCHAR(45) DEFAULT NULL,
`username` VARCHAR(45) DEFAULT NULL,
`email` VARCHAR(45) DEFAULT NULL,
`password` VARCHAR(100) DEFAULT NULL,
`phone_number` VARCHAR(45) DEFAULT NULL,
`nationality` VARCHAR(45) DEFAULT NULL,
PRIMARY KEY (`client_id`)
);

INSERT into client VALUES
(1, 'Olamide', 'Fadare', 'C', 'pcolamide', 'Olamidefadare@gmail.com', 'asdfgh', '090999999944', 'Niger');



DROP TABLE if exists client_company;

CREATE TABLE client_company (
`client_company_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
`company_name` VARCHAR(45) DEFAULT NULL,
`company_address` VARCHAR(45) DEFAULT NULL,
`company_email` VARCHAR(45) DEFAULT NULL,
`company_phone_number` VARCHAR(45) DEFAULT NULL,
`city` VARCHAR(45) DEFAULT NULL,
`LGA` VARCHAR(45) DEFAULT NULL,
`state` VARCHAR(45) DEFAULT NULL,
PRIMARY KEY (`client_company_id`)
);

INSERT into client_company VALUES
(1, 'Olamide Corporate World Inc', '234, Fadare Crescent off Bourdele way; Niger',
 'OlaCoporateWorld@coporate.inc.uk', '21109455345', 'Ankara', 'Urbui', 'Korvi');



DROP TABLE if exists law_firm;

CREATE TABLE law_firm (
`law_firm_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
`law_firm_name` VARCHAR(45) DEFAULT NULL,
`law_firm_address` VARCHAR(45) DEFAULT NULL,
`law_firm_phone_number` VARCHAR(45) DEFAULT NULL,
`law_firm_email` VARCHAR(45) DEFAULT NULL,
`law_firm_reg_number` VARCHAR(45) DEFAULT NULL,
`city` VARCHAR(45) DEFAULT NULL,
`LGA` VARCHAR(45) DEFAULT NULL,
`state` VARCHAR(45) DEFAULT NULL,
PRIMARY KEY (`law_firm_id`)
);

INSERT into law_firm VALUE
(1, 'Delano and Delano Solicitors Ltd', '201, Ligali Ayorinde way',
 '23400999943', 'delanoanddelano@gmail.com', '23886M', 'VI', 'Eti-Osa', 'Lagos');



DROP TABLE if exists attorney_roles;

CREATE TABLE attorney_roles(
`id` BIGINT(10) NOT NULL AUTO_INCREMENT,
`attorney_id` BIGINT(10) NOT NULL,
`role_id` BIGINT(10) NOT NULL,
PRIMARY KEY(`id`)
);

insert into attorney_roles value
(1,1,1),
(2,1,4);


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

DROP TABLE if EXISTS persistent_logins;

CREATE TABLE persistent_logins (

`username` varchar(64) not null,
`series` varchar(64) not null,
`token` varchar(64) not null,
`last_used` timestamp not null,
PRIMARY KEY (series)
);


DROP TABLE if exists roles;

CREATE TABLE roles(
`role_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) DEFAULT NULL,
PRIMARY KEY (`role_id`)
);

insert into roles value
(1, 'ROLE_ADMIN'),
(4, 'ROLE_USER');