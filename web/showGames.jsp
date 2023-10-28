<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.persistence.EntityManagerFactory" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="javax.persistence.Persistence" %>
<%@ page import="modelo.Game" %>
<%@ page import="service.EntityService" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Juegos</title>
</head>
<body>
    <h1>Listado de Juegos</h1>
        <%
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersitenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityService entityService = new EntityService(em);
        List<Game> games = entityService.getGames(null, null); // Llama al método getGames para obtener la lista de juegos
        // Itera a través de la lista de juegos y muéstralos
        for (Game game : games) {
    %>
        <div>
            <h2><%= game.getTitle() %></h2>
            <p>Descripción: <%= game.getDescription() %></p>
            <p>Tipo: <%= game.getType() %></p>
            <p>Consola: <%= game.getConsole() %></p>
            <p>Precio: <%= game.getPrice() %></p>
            <!-- Puedes mostrar más atributos según tus necesidades -->
        </div>
    <%
        }
    %>
</body>
</html>