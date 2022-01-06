/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.fitness.dao;

import com.sg.fitness.dto.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author raymondtam
 */
@Repository
@Component
public class RoundDaoFileImpl implements RoundDaoFile {
    @Autowired
    JdbcTemplate jdbc;
    
    
    private static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round newRound = new Round();
            newRound.setId(rs.getInt("id"));
            newRound.setRoundNumber(rs.getInt("RoundNumber"));
            newRound.setCurrentTime(rs.getString("currentTime"));
            newRound.setGuess(rs.getInt("Guess"));
             newRound.setPartialRight(rs.getInt("PartialRight"));
             newRound.setExactRight(rs.getInt("ExactRight"));
             newRound.setGameId(rs.getInt("gameId"));            
            
            
          
            return newRound;
        }
    }
    
    @Override
    public List<Round> getAllRounds(int gameId) {
        final String SELECT_ALL_ROUNDS = "SELECT * FROM rounds Where gameId = ? ";
        return jdbc.query(SELECT_ALL_ROUNDS, new RoundMapper(), gameId);
    }

    @Override
    public List<Round> getRoundById(int id) {
              String SELECT_ROUNDID = "SELECT * FROM rounds WHERE id=?";
        List<Round> round = jdbc.query(SELECT_ROUNDID, new RoundMapper(), id);
        return round;

    }
    
    

    @Override
    public void addRound(Round round) {
       int roundNumber = round.getRoundNumber();
       String currentTime = round.getCurrentTime();
       int guess = round.getGuess();
       int partial = round.getPartialRight();
       int exact = round.getExactRight();
       int gameId = round.getGameId();



        
       jdbc.update("INSERT INTO rounds(RoundNumber,Guess,currentTime,PartialRight,ExactRight,gameId ) VALUES(?,?,?,?,?,?)", roundNumber,guess,currentTime,partial,exact,gameId);
       
     
    }

    @Override
    public void updateRound(Round round) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testMethod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
  
    
}
