-- script for creating db from scretch

CREATE TABLE "users" (
	"id" INTEGER PRIMARY key AUTOINCREMENT,
	"first_name" varchar(100) NOT NULL,
	"sure_name" varchar(100) NOT NULL,
	"is_admin" tinyint(4) NOT NULL DEFAULT '0');

CREATE TABLE "priority_types" (
	"id" integer NOT NULL,
	"priority" varchar(100) NOT NULL, 
	PRIMARY KEY (id));

CREATE TABLE "skill_types" (
	"id" integer NOT NULL,
	"skill" varchar(100) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE "projects" (
	"id" INTEGER PRIMARY KEY AUTOINCREMENT,
	"name" varchar(100) NOT NULL,
	"priority_id" INTEGER NOT NULL,
	"user_id" INTEGER,
  	FOREIGN KEY(user_id) REFERENCES users(id)
 	FOREIGN KEY(priority_id) REFERENCES priority_types(id)
);

CREATE TABLE "tasks" (
	"id" INTEGER PRIMARY KEY AUTOINCREMENT,
	"name" varchar(100) NOT NULL,
	"priority_id" INTEGER NOT NULL,
	"user_id" INTEGER,
	"skill_id" INTEGER NOT NULL,
	"project_id" INTEGER,
  	FOREIGN KEY(user_id) REFERENCES users(id)
 	FOREIGN KEY(priority_id) REFERENCES priority_types(id)
 	FOREIGN KEY(skill_id) REFERENCES skill_types(id)
 	FOREIGN KEY(project_id) REFERENCES projects(id)
);

CREATE TABLE "sub_tasks" (
	"id" INTEGER PRIMARY KEY AUTOINCREMENT,
	"name" varchar(100) NOT NULL,
	"priority_id" INTEGER NOT NULL,
	"user_id" INTEGER,
	"skill_id" INTEGER NOT NULL,
	"task_id" INTEGER NOT NULL,
  	FOREIGN KEY(user_id) REFERENCES users(id)
 	FOREIGN KEY(priority_id) REFERENCES priority_types(id)
 	FOREIGN KEY(skill_id) REFERENCES skill_types(id)
 	FOREIGN KEY(task_id) REFERENCES tasks(id)
);

CREATE TABLE "user_auth" (
	"id" INTEGER PRIMARY KEY AUTOINCREMENT,
	"user_name" varchar(100) NOT NULL,
	"password" varchar(100) NOT NULL,
	"user_id" INTEGER NOT NULL,
  	FOREIGN KEY(user_id) REFERENCES users(id)
);


INSERT INTO "users" ("id", "first_name", "sure_name", "is_admin") VALUES ('1', 'noam', 'solan', '1'),
('2', 'yarin', 'kimhi', '1'),
('3', 'ronen', 'rozin', '1'),
('4', 'pika', 'chu', '0');

INSERT INTO "priority_types" ("id", "priority") VALUES ('1', 'Low'),
('2', 'Medium'),
('3', 'High');

INSERT INTO "skill_types" ("id", "skill") VALUES ('1', 'Backend'),
('2', 'DB'),
('3', 'Ops'),
('4', 'Frontend'),
('5', 'Scripting'),
('6', 'BI');

INSERT INTO "projects" ("id", "name", "priority_id", "user_id") VALUES ('1', 'New Site', '2', '4'),
('2', 'Script for somthing', '1', '4');

INSERT INTO "tasks" ("id", "name", "priority_id", "user_id", "skill_id", "project_id") VALUES ('1', 'get url from user', '3', '1', '4', NULL),
('2', 'get url from admin', '3', '1', '4', NULL);

INSERT INTO "sub_tasks" ("id", "name", "priority_id", "user_id", "skill_id", "task_id") VALUES ('1', 'new function for strings', '3', '3', '3', '2');

INSERT INTO "user_auth" ("id", "user_name", "password", "user_id") VALUES ('1', 'noam5456', 'Aa1234567', '1');
