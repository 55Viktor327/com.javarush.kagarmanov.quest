package com.quest.model;

public class GameState {
    private String playerName;
    private int currentQuestionId;
    private int gamePlayed;
    private String lastResult;

    public GameState() {
    }

    public GameState(String playerName, int currentQuestionId, int gamePlayed, String lastResult) {
        this.playerName = playerName;
        this.currentQuestionId = currentQuestionId;
        this.gamePlayed = gamePlayed;
        this.lastResult = lastResult;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCurrentQuestionId() {
        return currentQuestionId;
    }

    public void setCurrentQuestionId(int currentQuestionId) {
        this.currentQuestionId = currentQuestionId;
    }

    public int getGamePlayed() {
        return gamePlayed;
    }

    public void setGamePlayed(int gamePlayed) {
        this.gamePlayed = gamePlayed;
    }

    public String getLastResult() {
        return lastResult;
    }

    public void setLastResult(String lastResult) {
        this.lastResult = lastResult;
    }
}
