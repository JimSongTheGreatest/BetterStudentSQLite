BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "users" (
	"id"	int(11) NOT NULL,
	"username"	varchar(255) NOT NULL,
	"password"	varchar(255) NOT NULL,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "schedule" (
	"hrsStudy"	int(11) NOT NULL,
	"hrsSlept"	int(11) NOT NULL,
	"eating"	int(11) NOT NULL,
	"gpa"	int(11) NOT NULL,
	"id"	int(11) NOT NULL,
	FOREIGN KEY("id") REFERENCES "users"("id")
);
INSERT INTO "users" VALUES (3,'test','test');
INSERT INTO "schedule" VALUES (5,5,5,4,3);
COMMIT;
