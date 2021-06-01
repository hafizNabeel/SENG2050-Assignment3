USE [master];

IF DB_ID (N'SENG2050_IT_SERVICE') IS NOT NULL
DROP DATABASE [SENG2050_IT_SERVICE];

CREATE DATABASE [SENG2050_IT_SERVICE];

USE SENG2050_IT_SERVICE;

IF SUSER_ID(N'group18') IS NOT NULL
BEGIN
	DROP LOGIN [group18];
END
CREATE LOGIN group18
WITH PASSWORD = 'mySecur3Passw0rd!';

IF USER_ID(N'group18') IS NOT NULL
BEGIN
	DROP USER [group18];
END
CREATE USER group18
FOR LOGIN group18;



GRANT SELECT, INSERT, UPDATE, DELETE TO group18;


IF OBJECT_ID(N'person', N'U') IS NOT NULL
BEGIN
	DROP TABLE [person];
END


CREATE TABLE person
(
	personID			  UNIQUEIDENTIFIER,
	Fname				  char(20),
	Lname				  char(20),
	email				VARCHAR(30),
	userPassword		 VARCHAR(100),
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
	issueID				 UNIQUEIDENTIFIER PRIMARY KEY,
	personID			 UNIQUEIDENTIFIER,
	issueState			 char(20),
	category			 char(30),
	subCategory          char(30),
	title				 char(30),
	resolutionDetails     char(300),
	dateReported		 char(30),
	timeReported	   	char(30),
	dateSolved			char(30),
	description      char(300),
	FOREIGN KEY(personID) REFERENCES person(personID)
)
go

IF OBJECT_ID(N'Comments', N'U') IS NOT NULL
BEGIN
	DROP TABLE [Comments];
END

CREATE TABLE Comments
(
	commentsId      UNIQUEIDENTIFIER,
	personID			  UNIQUEIDENTIFIER,
	description    char(300),
	issueID				 UNIQUEIDENTIFIER,
	PRIMARY KEY (commentsId),
	FOREIGN KEY(issueID) REFERENCES Issues(issueId),
	FOREIGN KEY(personID) REFERENCES person(personID)

)
go

-- -- LOADING TO Person TABLE
-- --Admins
-- INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
-- VALUES ('1GldM', 'Scarlett', 'Messer', 'Scarlett@Messer.com', 'ScarlettMesser', '0472943839', 'Admin')
-- INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
-- VALUES ('p9zUg', 'Danny', 'Eslinger', 'Danny@Eslinger.com', 'DannyEslinger', '0459349300', 'Admin')
-- INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
-- VALUES ('p9zUj', 'Danny', 'Eslinger', 'Danny@Eslinger.com', 'DannyEslinger', '0459349300', 'Admin')
-- INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
-- VALUES ('jYTBM', 'Bernita', 'Molina', 'Bernita@Molina.com', 'BernitaMolina', '0412348656', 'Admin')
-- INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
-- VALUES ('83F0b', 'Maryanna', 'Liptak', 'Maryanna@Liptak.com', 'MaryannaLiptak', '0412345654', 'Admin')
-- --Normal users
-- INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
-- VALUES ('9rj9P', 'Bettina', 'Radabaugh', 'Bettina@Radabaugh.com ', 'BettinaRadabaugh', '0491749356', 'User')
-- INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
-- VALUES ('mtHF6', 'Verline', 'Cosper', 'Verline@Cosper.com', 'VerlineCosper', '0498899872', 'User')
-- INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
-- VALUES ('6PPMq', 'Deidra', 'Rush', 'Deidra@Rush.com', 'DeidraRush', '0437655786', 'User')
-- INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
-- VALUES ('Z6K38', 'Rhett', 'Poissant', 'Rhett@Poissant.com', 'RhettPoissant', '0456475835', 'User')
-- INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
-- VALUES ('AuCK0', 'Leif', 'Capito', 'Leif@Capito.com', 'LeifCapito', '0484747432', 'User')
-- INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo, roleInSystem)
-- VALUES ('yfpVP', 'Rita', 'Findley', 'Rita@Findley.com', 'RitaFindley', '0478797700', 'User')
