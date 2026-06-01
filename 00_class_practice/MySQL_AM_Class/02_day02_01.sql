CREATE TABLE `UserTBL` (
	`userName`	varchar(3)	NOT NULL,
	`birthYear`	int	NOT NULL,
	`Field`	varchar(2)	NOT NULL,
	`mobile`	varchar(12)	NULL
);

CREATE TABLE `buyTBL` (
	`userName`	varchar(3)	NOT NULL,
	`prodName`	varchar(3)	NULL,
	`price`	int	NULL,
	`amount`	int	NULL
);

ALTER TABLE `UserTBL` ADD CONSTRAINT `PK_USERTBL` PRIMARY KEY (
	`userName`
);

ALTER TABLE `buyTBL` ADD CONSTRAINT `PK_BUYTBL` PRIMARY KEY (
	`userName`
);

ALTER TABLE `buyTBL` ADD CONSTRAINT `FK_UserTBL_TO_buyTBL_1` FOREIGN KEY (
	`userName`
)
REFERENCES `UserTBL` (
	`userName`
);

