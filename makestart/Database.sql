USE [master];

ALTER DATABASE SENG2050_IT_SERVICE
SET SINGLE_USER
GO

IF DB_ID (N'SENG2050_IT_SERVICE') IS NOT NULL
DROP DATABASE [SENG2050_IT_SERVICE];

CREATE DATABASE [SENG2050_IT_SERVICE];
USE SENG2050_IT_SERVICE;


IF SUSER_ID(N'grop18') IS NOT NULL
BEGIN
	DROP LOGIN [grop18];
END


CREATE LOGIN grop18
WITH PASSWORD = 'mySecur3Passw0rd!';


IF USER_ID(N'grop18') IS NOT NULL
BEGIN
	DROP USER [grop18];
END


CREATE USER grop18
FOR LOGIN grop18;


SET NOCOUNT ON


GRANT SELECT, INSERT, UPDATE, DELETE TO grop18;



IF OBJECT_ID(N'person', N'U') IS NOT NULL
BEGIN
	DROP TABLE [person];
END
CREATE TABLE person 
(
	personID			  int,
	Fname				  varchar(20),
	Lname				  varchar(20),
	email				  VARCHAR(30),
	userPassword		   VARCHAR(20),
	phoneNo    			  varchar(20),
	roleInSystem           VARCHAR(20),

	PRIMARY KEY (personID),
)
go



IF OBJECT_ID(N'Issues', N'U') IS NOT NULL
BEGIN
	DROP TABLE [Issues];
END
CREATE TABLE Issues 
(
	issesId				 VARCHAR(30)PRIMARY KEY,
	personID			 int,
	issesState			 char(20),
	category			 char(30),
	subCategory          char(30),
	title				 char(30),
	reslotionDetails     char(300),
	dateReported		 char(30),
	timeReported	   	char(30),
	dateSolved			char(30),
	commentsId      VARCHAR(20),
	description      char(300),

	FOREIGN KEY(personID) REFERENCES person(personID)
	ON UPDATE CASCADE ON DELETE CASCADE,
)
go


IF OBJECT_ID(N'Comments', N'U') IS NOT NULL
BEGIN
	DROP TABLE [Comments];
END
CREATE TABLE Comments 
(
	commentsId      VARCHAR(20) PRIMARY KEY,
	personID       int,
	descreptions    char(200),
	issesId				 VARCHAR(30),

	FOREIGN KEY(issesId) REFERENCES Issues(issesId)
	ON UPDATE CASCADE ON DELETE CASCADE,
	
)
go



-- LOADING TO Person TABLE
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('3454', 'Bettina', 'Radabaugh', 'Bettina@Radabaugh.com ', 'BettinaRadabaugh', '0491749356', 'STUDENT')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('16765', 'Scarlett', 'Messer', 'Scarlett@Messer.com', 'ScarlettMesser', '0472943839', 'IT STAFF')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('56765', 'Verline', 'Cosper', 'Verline@Cosper.com', 'VerlineCosper', '0498899872', 'UNIVERST STAFF')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('345654', 'Deidra', 'Rush', 'Deidra@Rush.com', 'DeidraRush', '0437655786', 'STUDENT')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('45676', 'Danny', 'Eslinger', 'Danny@Eslinger.com', 'DannyEslinger', '0459349300', 'IT STAFF')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('8765', 'Rhett', 'Poissant', 'Rhett@Poissant.com', 'RhettPoissant', '0456475835', 'UNIVERST STAFF')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('456765', 'Leif', 'Capito', 'Leif@Capito.com', 'LeifCapito', '0484747432', 'STUDENT')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('4567', 'Bernita', 'Molina', 'Bernita@Molina.com', 'BernitaMolina', '0412348656', 'IT STAFF')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('6765', 'Rita', 'Findley', 'Rita@Findley.com', 'RitaFindley', '0478797700', 'UNIVERST STAFF')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('84567', 'Maryanna', 'Liptak', 'Maryanna@Liptak.com', 'MaryannaLiptak', '0412345654', 'STUDENT')

ALTER DATABASE SENG2050_IT_SERVICE
SET MULTI_USER
GO





