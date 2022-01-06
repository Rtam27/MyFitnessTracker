/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.fitness.dao;

import com.sg.fitness.dto.Round;
import java.util.List;

/**
 *
 * @author raymondtam
 */
public interface RoundDaoFile {
       
        List<Round> getAllRounds(int gameId);
    List<Round> getRoundById(int id);
    void addRound(Round round);
    void updateRound(Round round);
    void testMethod();
}
