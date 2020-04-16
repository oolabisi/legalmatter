CREATE Database if not exists legal_directory;

Use legal_directory;



#DROP TABLE if exists attorney;

#CREATE TABLE attorney (
#`attorneyId` int(10) NOT NULL AUTO_INCREMENT,
#`firstName` VARCHAR(45) DEFAULT NULL,
#`lastName` VARCHAR(45) DEFAULT NULL,
#`otherName` VARCHAR(45) DEFAULT NULL,
#`title` VARCHAR(45) DEFAULT NULL,
#`email` VARCHAR(45) DEFAULT NULL,
#`password` VARCHAR(45) DEFAULT NULL,
#`phoneNumber` VARCHAR(45) DEFAULT NULL,
#`enrollmentNumber` VARCHAR(45) DEFAULT NULL,
#`enrollmentYear` VARCHAR(45) DEFAULT NULL,
#`callToBarCertNumber` VARCHAR(45) DEFAULT NULL,
#`nationality` VARCHAR(45) DEFAULT NULL,
#PRIMARY KEY (`AttorneyId`)
#);

#INSERT into attorney VALUE
#(1, `Olabisi`, `Ogundairo`,`O`, `Barrister`, `faeyemi@gmail.com`,
#`123qwerty`, `221100045`, `AQ1235778`, `2005`, `10000023`, `Ukraine`);




#DROP TABLE if exists client;

#CREATE TABLE client (
#`clientId` INT(10) NOT NULL AUTO_INCREMENT,
#`firstName` VARCHAR(45) DEFAULT NULL,
#`lastName` VARCHAR(45) DEFAULT NULL,
#`otherName` VARCHAR(45) DEFAULT NULL,
#`email` VARCHAR(45) DEFAULT NULL,
#`password` VARCHAR(45) DEFAULT NULL,
#`phoneNumber` VARCHAR(45) DEFAULT NULL,
#`nationality` VARCHAR(45) DEFAULT NULL,
#PRIMARY KEY (`clientId`)
#);

#INSERT into client VALUE
#(1, `Olamide`, `Fadare`, `C`, `Olamidefadare@gmail.com`, `asdfgh`, `090999999944`, `Niger`);



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

#INSERT into clientCompany VALUE
#(1, `Olamide Corporate World Inc`, `234, Fadare Crescent off Bourdele way; Niger`,
# `OlaCoporateWorld@coporate.inc.uk`, `21109455345`, `Ankara`, `Urbui`, `Korvi`);






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

#INSERT into lawFirm VALUE
#(1, `Delano and Delano Solicitors Ltd`, `201, Ligali Ayorinde way`,
# `23400999943`, `delanoanddelano@gmail.com`, `23886M`, `VI`, `Eti-Osa`, `Lagos`);
