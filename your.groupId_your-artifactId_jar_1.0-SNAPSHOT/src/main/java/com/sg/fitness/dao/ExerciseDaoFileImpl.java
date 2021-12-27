/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.fitness.dao;

import com.sg.fitness.dto.Exercise;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raymondtam
 */
@Repository
@Component
public class ExerciseDaoFileImpl implements ExerciseDaoFile {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Exercise> getAllExercise() {
        String QUERY = "SELECT * FROM exercise;";
        return jdbc.query(QUERY, new GameMapper());
    }

    @Override
    public List<Exercise> getAlLExerciseByPart(Exercise exercise) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AddExercise(Exercise exercise) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EditExercise(Exercise exercise) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteExercise(Exercise exercise) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AddListExercise(List<Exercise> exercises) {
        for(Exercise exe: exercises){
            String bodyPart = exe.getBodyPart();
            String equipment = exe.getEquipment();
            String gifUrl= exe.getGifUrl();
            String id = exe.getId();
            String name = exe.getName();
            String target = exe.getTarget();
            String QUERY = "INSERT INTO exercise(bodyPart,equipment,gifUrl,id,name,target) VALUES(?,?,?,?,?,?)"; 
                    
            jdbc.update(QUERY, bodyPart,equipment,gifUrl, id, name, target);
        }
        
        
       
    }
    
    

    private static final class GameMapper implements RowMapper<Exercise> {

        @Override
        public Exercise mapRow(ResultSet rs, int index) throws SQLException {
            Exercise newExercise = new Exercise();
                    newExercise.setBodyPart(rs.getString("bodyPart"));
                    newExercise.setEquipment(rs.getString("equipment"));
                    newExercise.setGifUrl(rs.getString("gifUrl"));
                    newExercise.setId(rs.getString("id"));
                    newExercise.setName(rs.getString("name"));
                    newExercise.setTarget(rs.getString("target"));
                            
                    return newExercise;
        }
    }



}
