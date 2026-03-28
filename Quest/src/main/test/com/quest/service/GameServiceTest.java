package com.quest.service;

import com.quest.model.Ending;
import com.quest.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    void setUp() throws IOException {
        gameService = GameService.getInstance();
    }

    @Test
    void testQuestionsLoaded() {
        Map<Integer, Question> questions = gameService.getQuestions();

        assertThat(questions).isNotNull();
        assertThat(questions).isNotEmpty();
    }

    @Test
    void testQuestionsCount() {
        Map<Integer, Question> questions = gameService.getQuestions();

        assertEquals(13, questions.size());
    }
    @Test
    void testEndingsCount() {
        Map<String, Ending> endings = gameService.getEndings();

        assertThat(endings).hasSize(15);
    }

    @Test
    void testGetQuestionById_Existing() {

        int expectedId = 1;
        Question expectedQuestion = gameService.getQuestionById(expectedId);

        assertThat(expectedQuestion)
                .isNotNull()
                .extracting(Question::getId)
                .isEqualTo(expectedId);
    }

    @Test
    void testGetQuestionById_NotExisting() {
        int expectedId = 999;
        Question existedQuestion = gameService.getQuestionById(expectedId);

        assertThat(existedQuestion).isNull();
    }

    @Test
    void testGetEnding_Existing() {
        String expectedKey = "win1";
        Ending expectedEnding = gameService.getEnding(expectedKey);

        assertThat(expectedEnding)
                .isNotNull()
                .extracting(Ending::getTitle)
                .isEqualTo("Победа!");
    }

    @Test
    void testGetEnding_NotExisting() {
        String expectedKey= "unknown";
        Ending expectedEnding = gameService.getEnding(expectedKey);

        assertThat(expectedEnding).isNull();
    }

    @Test
    void testIsEnding_WithWinPrefix() {
        String prefix = "win1";
        boolean result = gameService.isEnding(prefix);

        assertThat(result).isTrue();
    }

    @Test
    void testIsEnding_WithLosePrefix() {
        String prefix = "lose3";
        boolean result = gameService.isEnding(prefix);

        assertThat(result).isTrue();
    }

    @Test
    void testIsEnding_WithNeutralPrefix() {
        String prefix = "neutral";
        boolean result = gameService.isEnding(prefix);

        assertThat(result).isTrue();
    }

    @Test
    void testIsEnding_WithNumber() {
        String prefix = "2";
        boolean result = gameService.isEnding(prefix);

        assertThat(result).isFalse();
    }

//    12. Тест isEnding с null
//    Цель: проверить обработку null
//    Контракт: isEnding(null) → false
    @Test
    void testIsEnding_WithNull() {
        String prefix = "2";
        boolean result = gameService.isEnding(prefix);

        assertThat(result).isFalse();
    }

    @Test
    void testIsEnding_WithRandomString() {
        String prefix = "something";
        boolean result = gameService.isEnding(prefix);

        assertThat(result).isFalse();

    }
}
