package DB;

import java.sql.*;
import java.lang.AutoCloseable;

public class DBconnection {

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String CONN = "jdbc:mysql://localhost:3306";
    private static final String CONNURL = "jdbc:mysql://localhost:3306/SE_proj";

    public static Connection getConnection () throws SQLException {
       return DriverManager.getConnection(CONN, USERNAME, PASSWORD);
    }

    public static void CreateAndConnect () throws SQLException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = null;

        String sqlCreatePriorityTypes = "CREATE TABLE `SE_proj`.`priority_type` ( `id` INT(30) NOT NULL AUTO_INCREMENT , `name` VARCHAR(30) NOT NULL , PRIMARY KEY (`id`))";
        String sqlCreateProjects = "CREATE TABLE `SE_proj`.`projects` ( `id` INT(30) NOT NULL AUTO_INCREMENT , `name` VARCHAR(30) NOT NULL , `priority_id` INT(30) NOT NULL , `user_id` INT(30) NOT NULL , PRIMARY KEY (`id`))";
        String sqlCreateSkillTypes = "CREATE TABLE `SE_proj`.`skil_types` ( `id` INT(30) NOT NULL AUTO_INCREMENT , `skill` VARCHAR(30) NOT NULL , PRIMARY KEY (`id`))";
        String sqlCreateSubTasks = "CREATE TABLE `SE_proj`.`sub_tasks` ( `id` INT(30) NOT NULL AUTO_INCREMENT , `name` VARCHAR(3000) NOT NULL , `priority_id` INT NOT NULL , `user_id` INT NOT NULL , `skill_id` INT NOT NULL , `task_id` INT NOT NULL , PRIMARY KEY (`id`))";
        String sqlCreateTasks = "CREATE TABLE `SE_proj`.`tasks` ( `id` INT(30) NOT NULL AUTO_INCREMENT , `name` VARCHAR(30) NOT NULL , `priority_id` INT NOT NULL , `user_id` INT NOT NULL , `skill_id` INT NOT NULL , `project_id` INT NOT NULL , PRIMARY KEY (`id`))";
        String sqlCreateUserAuth = "CREATE TABLE `SE_proj`.`user_auth` ( `id` INT(30) NOT NULL AUTO_INCREMENT , `user_name` VARCHAR(200) NOT NULL , `password` VARCHAR(30) NOT NULL , `user_id` INT(30) NOT NULL , PRIMARY KEY (`id`))";
        String sqlCreateUsers = "CREATE TABLE `SE_proj`.`users` ( `id` INT(30) NOT NULL AUTO_INCREMENT , `first_name` VARCHAR(30) NOT NULL , `sure_name` VARCHAR(30) NOT NULL , `user_name` VARCHAR(30) NOT NULL , `email` VARCHAR(50) NOT NULL , `is_admin` BOOLEAN NOT NULL , PRIMARY KEY (`id`))";
        }

     public static    
    }



