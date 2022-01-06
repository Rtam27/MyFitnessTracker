/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.fitness.dao;

import com.sg.fitness.dto.Exercise;
import com.sg.fitness.dto.ExerciseRepSet;
import com.sg.fitness.dto.Save;
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
public class MyExerciseDaoFileImp implements MyExerciseDaoFile {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public void AddExerciseToDate(List<ExerciseRepSet> exercise, String Date) {
        String getQuery = "SELECT * FROM dateData WHERE date = ?";
        List<Save> check = jdbc.query(getQuery, new DateMapper(),Date);
        
        
     
        if(check.size()>0){
           int id = check.get(0).getId();
           String deleteIdQuery= "DELETE FROM MyExercise WHERE dateid = ? ";
           jdbc.update(deleteIdQuery, id);
           String deleteQuery = "DELETE FROM dateData WHERE date = ? ";
            jdbc.update(deleteQuery, Date);
        }
        
        String dateQuery = "INSERT INTO dateData(date) VALUES (?) ";
        jdbc.update(dateQuery, Date);
        String lastDateQuery = "SELECT * FROM dateData WHERE id=last_insert_id()";
        List<Save> save = jdbc.query(lastDateQuery, new DateMapper());
        
        int saveId = save.get(0).getId();
        
        for(ExerciseRepSet singleExercise: exercise ){
        String bodyPart = singleExercise.getBodyPart();
        String equipment = singleExercise.getEquipment();
        String gifUrl = singleExercise.getGifUrl();
        String id = singleExercise.getId();
        String name = singleExercise.getName();
        String target = singleExercise.getTarget();
        String rep = singleExercise.getRep();
        String sets = singleExercise.getSet();
        
    
        
        String Query = "INSERT INTO MyExercise(bodyPart,equipment,gifUrl,id,name,target, rep,sets, dateid ) VALUES(?,?,?,?,?,?,?,?,?)";
        jdbc.update(Query, bodyPart,equipment,gifUrl,id,name,target,rep,sets, saveId);
        
      
        

        
   
    }   }

    @Override
    public List<ExerciseRepSet> GetExerciseByDate(String Date) {
        String QUERY = "SELECT * FROM dateData WHERE date = ?";
        List<Save> save = jdbc.query(QUERY, new DateMapper(), Date);
        int id = save.get(0).getId();
        
        String QUERY2 = "SELECT * FROM MyExercise WHERE dateid =?";
        List<ExerciseRepSet> exercise = jdbc.query(QUERY2, new GameMapper(), id);
        
        return exercise;
         
    }
    
    
    
    
    

    private static final class GameMapper implements RowMapper<ExerciseRepSet> {

        @Override
        public ExerciseRepSet mapRow(ResultSet rs, int index) throws SQLException {
            ExerciseRepSet newExercise = new ExerciseRepSet();
                    newExercise.setBodyPart(rs.getString("bodyPart"));
                    newExercise.setEquipment(rs.getString("equipment"));
                    newExercise.setGifUrl(rs.getString("gifUrl"));
                    newExercise.setId(rs.getString("id"));
                    newExercise.setName(rs.getString("name"));
                    newExercise.setTarget(rs.getString("target"));
                    newExercise.setRep(rs.getString("rep"));        
                    newExercise.setSet(rs.getString("sets"));
                    return newExercise;
        }
    }
    
        private static final class DateMapper implements RowMapper<Save> {

        @Override
        public Save mapRow(ResultSet rs, int index) throws SQLException {
            Save newSave = new Save();
                    newSave.setId(rs.getInt("id"));
                    newSave.setDate(rs.getString("date"));
           
                    return newSave;
        }
    }



}
