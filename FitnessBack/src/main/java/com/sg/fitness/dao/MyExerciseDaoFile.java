/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.fitness.dao;

import com.sg.fitness.dto.ExerciseRepSet;
import java.util.List;

/**
 *
 * @author raymondtam
 */
public interface MyExerciseDaoFile {
    void AddExerciseToDate(List<ExerciseRepSet> exercise, String Date);
    List<ExerciseRepSet> GetExerciseByDate(String Date);
    
}
