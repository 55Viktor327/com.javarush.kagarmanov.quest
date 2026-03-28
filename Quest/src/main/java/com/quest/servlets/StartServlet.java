package com.quest.servlets;

import com.quest.model.GameState;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/start")
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        String player = req.getParameter("playerName");
        if(player == null || player.trim().isEmpty()){
            GameState existing = (GameState) session.getAttribute("gameState");
            if(existing != null && existing.getPlayerName() != null){
                player = existing.getPlayerName();
            }else{
                player = "Гость";
            }
        }

        GameState gameState = (GameState) req.getSession().getAttribute("gameState");
        if(gameState == null){
            gameState = new GameState(player, 1, 1);
        }else{
            gameState = new GameState(player, 1, gameState.getGamesPlayed()+1);
        }

        session.setAttribute("gameState", gameState);
        resp.sendRedirect(req.getContextPath() + "/quest");
    }
}
