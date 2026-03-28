package com.quest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quest.model.Ending;
import com.quest.model.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class GameService {
    private static GameService instance;
    private Map<Integer, Question> questions;
    private Map<String, Ending> endings;
    private ObjectMapper objectMapper = new ObjectMapper();

    private GameService() throws IOException {
        loadQuestions();
    }


    public static GameService getInstance() throws IOException {
        if(instance == null){
            instance = new GameService();
        }

        return instance;
    }

    public Map<Integer, Question> getQuestions() {
        return questions;
    }

    public Map<String, Ending> getEndings() {
        return endings;
    }

    public void loadQuestions() throws IOException{
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("questions.json");){
            JsonNode rootJson = objectMapper.readTree(inputStream);
            questions = new HashMap<>();
            for(JsonNode questionNode : rootJson.get("questions")){
                Question question = objectMapper.treeToValue(questionNode, Question.class);
                questions.put(question.getId(), question);
            }

            endings = new HashMap<>();
            JsonNode endingNode = rootJson.get("endings");
            endingNode.fields().forEachRemaining(entry -> {
                String endingId = entry.getKey();
                JsonNode endingData = entry.getValue();
                try {
                    Ending ending = objectMapper.treeToValue(endingData, Ending.class);
                    endings.put(endingId, ending);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public Question getQuestionById(int id){
        return questions.get(id);
    }

    public Ending getEnding(String id){
        return endings.get(id);
    }

    public boolean isEnding(String target){
        return target != null && target.startsWith("win")
                || target.startsWith("lose")
                || target.startsWith("neutral");
    }
}
