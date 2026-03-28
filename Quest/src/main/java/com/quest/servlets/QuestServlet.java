package com.quest.servlets;

import com.quest.model.GameState;
import com.quest.model.Question;
import com.quest.service.GameService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;

@WebServlet("/quest")
public class QuestServlet extends HttpServlet {
    GameService gameService;

    @Override
    public void init() throws ServletException {
        try {
            gameService = GameService.getInstance();
        } catch (IOException e) {
            throw new ServletException();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");
        if(gameState == null){
            resp.sendRedirect(req.getContextPath() + "/start");
            return;
        }

        int currentQuestionId = gameState.getCurrentQuestionId();
        Question currentQuestion = gameService.getQuestionById(currentQuestionId);
        if(currentQuestion == null){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Question not found!");
            return;
        }

        req.setAttribute("question", currentQuestion);
        req.getRequestDispatcher("/WEB-INF/views/game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");
        String answer = req.getParameter("answer");
        if(answer == null){
            resp.sendRedirect(req.getContextPath() + "/quest");
            return;
        }

        Question currentQuestion = gameService.getQuestionById(gameState.getCurrentQuestionId());
        String next = currentQuestion.getAnswers().get(answer);
        if(next == null){
            resp.sendRedirect(req.getContextPath() + "/quest");
            return;
        }

        if(gameService.isEnding(next)){
            gameState.setLastResult(next);
            resp.sendRedirect(req.getContextPath() + "/result?endingId=" + next);
            return;
        }else{
            int nextStep = Integer.parseInt(next);
            gameState.setCurrentQuestionId(nextStep);
            resp.sendRedirect(req.getContextPath() + "/quest");
            return;
        }
    }
}
