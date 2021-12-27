/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.fitness.controller;

import com.sg.fitness.dao.ExerciseDaoFile;
import com.sg.fitness.dao.MyExerciseDaoFile;
import com.sg.fitness.dto.ExerciseRepSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author raymondtam
 */

@RestController
@RequestMapping("/api")
public class SavingController {
    
      @Autowired
   public MyExerciseDaoFile myExeDao;
      
     @PostMapping(value = "/addSave/{date}", consumes = "application/json")
   public void newFunc(@RequestBody List<ExerciseRepSet> exercise,@PathVariable String date){
        myExeDao.AddExerciseToDate(exercise, date);

   }
   
    @GetMapping("/getSave/{date}")
    public List<ExerciseRepSet> aFunc(@PathVariable String date){
        return myExeDao.GetExerciseByDate(date);
    }
}
