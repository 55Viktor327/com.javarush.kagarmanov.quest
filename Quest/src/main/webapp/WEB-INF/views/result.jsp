
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Киберпанк: Взлом OmniCorp</title>
    </head>

    <body>
        <h1>${ending.title}</h1>
        <p>${ending.text}</p>
        <p>Игрок: ${gameState.playerName}</p>
        <p>Сыграно игр: ${gameState.gamesPlayed}</p>
        <form action="${pageContext.request.contextPath}/start" method="post">
            <input type="hidden" name="playerName" value="${gameState.playerName}">
            <button type="submit">Начать новую игру</button>
        </form>

    </body>
</html>
