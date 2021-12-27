package com.sg.fitness;



import com.sg.fitness.controller.FitnessController;
import com.sg.fitness.dao.ExerciseDaoFileImpl;
import com.sg.fitness.dto.Exercise;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootApplication

public class App  {
  
         
     public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
       
    }

}
