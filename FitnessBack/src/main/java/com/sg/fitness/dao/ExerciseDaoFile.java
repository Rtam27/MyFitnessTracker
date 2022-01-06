/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.fitness.dao;

import com.sg.fitness.dto.Exercise;
import java.util.List;

/**
 *
 * @author raymondtam
 */
public interface ExerciseDaoFile {
    
    List<Exercise> getAllExercise();
    List<Exercise> getAlLExerciseByPart(Exercise exercise);
    void AddExercise(Exercise exercise);
    void EditExercise(Exercise exercise);
    void DeleteExercise(Exercise exercise);
    void AddListExercise(List<Exercise> exercises);
    
}
