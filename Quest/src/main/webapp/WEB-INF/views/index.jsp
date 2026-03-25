<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Киберпанк: Взлом OmniCorp</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>Киберпанк: Взлом OmniCorp</h2>
<p>
    2127 год. Корпорация OmniCorp контролирует всё — от городской инфраструктуры до сознания людей.
    Слухи о незаконных экспериментах с нейросетями расползаются по тёмным углам сети.<br><br>
    Вы — Ne0n, хакер-одиночка, который находит уязвимость в системе безопасности корпорации.
    Цель: проникнуть в закрытую базу данных и выкрасть компромат.<br><br>
    Однако OmniCorp не прощает ошибок. Каждое ваше решение может привести к триумфу… или бесследному исчезновению.<br><br>
    Готовы рискнуть?
</p>

<form action="${pageContext.request.contextPath}/start" method="post">
    <label for="playerName">Введите ваше имя:</label>
    <input type="text" id="playerName" name="playerName" required>
    <button type="submit">Начать игру</button>
</form>
</body>
</html>