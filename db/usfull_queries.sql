-- get user from auth
select 
	users.*
from 
	user_auth
join users on user_auth.user_id = users.id
where
	user_auth.user_name = "noam5456" -- string should be replaced in java code by the inserted user name
	and user_auth.password = "Aa1234567" -- string should be replaced in java code by the inserted password
;

-- get all tasks under a project
select
	tasks.*
from
	tasks
where
	tasks.project_id = 2 -- integer value should be replaced by java code with the project id
;	

-- get all sub_tasks under a task
select
	tasks.*
from
	tasks
where
	tasks.project_id = 2 -- integer value should be replaced by java code with the project id
;

select
	sub_tasks.*
from
	sub_tasks
where
	sub_tasks.task_id = 2 -- integer value should be replaced by java code with the project id
;

-- get all tasks assigned to a user
select
	tasks.*
from
	tasks
where
	tasks.user_id = 1 -- integer value should be replaced by java code with the project id
;

-- list all tasks 
select 
    tasks.* 
from 
    tasks;

-- list all tasks 
select 
    users.* 
from 
    users;

--list all project
select 
    projects.* 
from 
    projects;