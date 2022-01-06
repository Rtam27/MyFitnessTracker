/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.fitness.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author raymondtam
 */
public class Round {
    int id;
    int roundNumber;
    String currentTime;
    int guess;
    int partialRight;
    int exactRight;
    int gameId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getPartialRight() {
        return partialRight;
    }

    public void setPartialRight(int partialRight) {
        this.partialRight = partialRight;
    }

    public int getExactRight() {
        return exactRight;
    }

    public void setExactRight(int exactRight) {
        this.exactRight = exactRight;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
        hash = 43 * hash + this.roundNumber;
        hash = 43 * hash + Objects.hashCode(this.currentTime);
        hash = 43 * hash + this.guess;
        hash = 43 * hash + this.partialRight;
        hash = 43 * hash + this.exactRight;
        hash = 43 * hash + this.gameId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Round other = (Round) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.roundNumber != other.roundNumber) {
            return false;
        }
        if (this.guess != other.guess) {
            return false;
        }
        if (this.partialRight != other.partialRight) {
            return false;
        }
        if (this.exactRight != other.exactRight) {
            return false;
        }
        if (this.gameId != other.gameId) {
            return false;
        }
        if (!Objects.equals(this.currentTime, other.currentTime)) {
            return false;
        }
        return true;
    }
    
    
    
}
