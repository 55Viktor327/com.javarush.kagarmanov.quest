package com.quest.servlets;

import com.quest.model.Ending;
import com.quest.model.GameState;
import com.quest.service.GameService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
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
        String endingId = req.getParameter("endingId");
        if(endingId == null){
            resp.sendRedirect(req.getContextPath() + "/start");
            return;
        }

        Ending ending = gameService.getEnding(endingId);
        if(ending == null){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Ending not found!");
            return;
        }

        HttpSession session = req.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");
        req.setAttribute("gameState", gameState);
        req.setAttribute("ending", ending);
        req.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(req, resp);
    }
}
