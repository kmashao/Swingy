CREATE DATABASE swingy;
use swingy;
CREATE TABLE heroes (
	heroID int(3) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	heroName varchar(30) NOT NULL,
	heroClass varchar(20) NOT NULL,
	heroLevel int NOT NULL,
	heroExperience int NOT NULL,
	heroAttack int NOT NULL,
	heroDefense int NOT NULL,
	heroHitPoints int NOT NULL
);