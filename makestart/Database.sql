USE [master];

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



GRANT SELECT, INSERT, UPDATE, DELETE TO grop18;


IF OBJECT_ID(N'Comments', N'U') IS NOT NULL
BEGIN
	DROP TABLE [Comments];
END

CREATE TABLE Comments 
(
	commentsId      VARCHAR(20),
	personID        VARCHAR(20),
	descreptions    char(200),
	PRIMARY KEY (commentsId),
)
go


IF OBJECT_ID(N'KnowledgeBased', N'U') IS NOT NULL
BEGIN
	DROP TABLE [KnowledgeBased];
END


CREATE TABLE KnowledgeBased 
(
	k_baseId      VARCHAR(30),
	personID        VARCHAR(30),
	descreptions    char(300),
	PRIMARY KEY (k_baseId),
)
go


IF OBJECT_ID(N'person', N'U') IS NOT NULL
BEGIN
	DROP TABLE [person];
END


CREATE TABLE person 
(
	personID			  VARCHAR(30),
	Fname				  char(20),
	Lname				  char(20),
	email				VARCHAR(30),
	userPassword		 VARCHAR(20),
	phoneNo    			int,
	roleInSystem         VARCHAR(20),

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
	personID			 VARCHAR(30),
	issesState			 char(20),
	category			 char(30),
	subCategory         char(30),
	title				char(30),
	reslotionDetails   char(300),
	dateReported		char(30),
	timeReported		char(30),
	dateSolved			char(30),
	commentsId      VARCHAR(20),
	k_baseId      VARCHAR(30),

	FOREIGN KEY(commentsId) REFERENCES Comments(CommentsId)
		ON UPDATE CASCADE ON DELETE CASCADE, 
	FOREIGN KEY(k_baseId) REFERENCES KnowledgeBased(k_baseId)
		ON UPDATE CASCADE ON DELETE CASCADE
)
go




--select * from person

-- LOADING TO Person TABLE
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('9rj9P', 'Bettina', 'Radabaugh', 'Bettina@Radabaugh.com ', 'BettinaRadabaugh', '0491749356', 'STUDENT')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('1GldM', 'Scarlett', 'Messer', 'Scarlett@Messer.com', 'ScarlettMesser', '0472943839', 'IT STAFF')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('mtHF6', 'Verline', 'Cosper', 'Verline@Cosper.com', 'VerlineCosper', '0498899872', 'UNIVERST STAFF')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('6PPMq', 'Deidra', 'Rush', 'Deidra@Rush.com', 'DeidraRush', '0437655786', 'STUDENT')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('p9zUg', 'Danny', 'Eslinger', 'Danny@Eslinger.com', 'DannyEslinger', '0459349300', 'IT STAFF')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('Z6K38', 'Rhett', 'Poissant', 'Rhett@Poissant.com', 'RhettPoissant', '0456475835', 'UNIVERST STAFF')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('AuCK0', 'Leif', 'Capito', 'Leif@Capito.com', 'LeifCapito', '0484747432', 'STUDENT')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('jYTBM', 'Bernita', 'Molina', 'Bernita@Molina.com', 'BernitaMolina', '0412348656', 'IT STAFF')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('yfpVP', 'Rita', 'Findley', 'Rita@Findley.com', 'RitaFindley', '0478797700', 'UNIVERST STAFF')
INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
VALUES ('83F0b', 'Maryanna', 'Liptak', 'Maryanna@Liptak.com', 'MaryannaLiptak', '0412345654', 'STUDENT')












