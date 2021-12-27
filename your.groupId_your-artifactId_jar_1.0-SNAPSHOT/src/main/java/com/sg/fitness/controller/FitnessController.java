/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author raymondtam
 */

package com.sg.fitness.controller; // Change to [your-base-package].controllers

import com.sg.fitness.dao.ExerciseDaoFileImpl;
import com.sg.fitness.dao.GuessValidationException;
import com.sg.fitness.dao.RoundDaoFile;
import com.sg.fitness.dto.Exercise;
import com.sg.fitness.dto.Round;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sg.fitness.dao.ExerciseDaoFile;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class FitnessController {
   
   @Autowired
   public ExerciseDaoFile exeDao;
   
   public FitnessController(){
       
   }
 
   
   @GetMapping
   public String gameStart(){
        return "Hello";

   }
   
   
   @GetMapping("/Exercise")
   public List<Exercise> getAllExe(){
       List<Exercise> getAllExercise = exeDao.getAllExercise();
       return getAllExercise;
   } 
   
   @PostMapping(value = "/ListExercise", consumes = "application/json")
   public void addAllListExe(@RequestBody List<Exercise> exercise){
       exeDao.AddListExercise(exercise);
   }
    
 
  
    
    
    
}
