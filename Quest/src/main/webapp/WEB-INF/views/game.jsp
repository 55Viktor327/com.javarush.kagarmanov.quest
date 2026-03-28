<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Киберпанк: Взлом OmniCorp</title>
    </head>
        <body>
            <h1>Киберпанк: Взлом OmniCorp</h1>
            <c:set var="gameState" value="${sessionScope.gameState}" />
            <p>Игрок: ${gameState.playerName}</p>
            <p>Сыграно игр: ${gameState.gamesPlayed}</p>

            <h2>${question.text}</h2>

            <form action="${pageContext.request.contextPath}/quest" method="post">
                <c:forEach var="entry" items="${question.answers}">
                    <button type="submit" name="answer" value="${entry.key}">
                            ${entry.key}
                    </button>
                </c:forEach>
            </form>
        </body>
</html>
