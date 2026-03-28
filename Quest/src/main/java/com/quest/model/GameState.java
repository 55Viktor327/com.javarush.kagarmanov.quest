package com.quest.model;

public class GameState {
    private String playerName;
    private int currentQuestionId;
    private int gamesPlayed;
    private String lastResult;

    public GameState() {
    }

    public GameState(String playerName, int currentQuestionId, int gamesPlayed, String lastResult) {
        this.playerName = playerName;
        this.currentQuestionId = currentQuestionId;
        this.gamesPlayed = gamesPlayed;
        this.lastResult = lastResult;
    }

    public GameState(String playerName, int currentQuestionId, int gamesPlayed) {
        this.playerName = playerName;
        this.currentQuestionId = currentQuestionId;
        this.gamesPlayed = gamesPlayed;
    }

    public String getPlayerName() {
        return playerName;
    }

     public int getCurrentQuestionId() {
        return currentQuestionId;
    }

    public void setCurrentQuestionId(int currentQuestionId) {
        this.currentQuestionId = currentQuestionId;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public String getLastResult() {
        return lastResult;
    }

    public void setLastResult(String lastResult) {
        this.lastResult = lastResult;
    }
}
