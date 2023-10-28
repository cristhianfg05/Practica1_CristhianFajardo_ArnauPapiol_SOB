<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert Data into Database</title>
</head>
<style>
    .error {
        color: red;
    }
    pre {
        color: green;
    }
</style>
<body>
    <h2>Insert Data into Database</h2>
    <%
        String dbname = "gameStore";
        String schema = "ROOT";
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbname, "root", "root");
        Statement stmt = con.createStatement();

        /* Insert data */
        String[] dataInsertStatements = new String[]{
            "INSERT INTO " + schema + ".GAME (DESCRIPTION, CONSOLE, DISPONIBLE, PRICE, TITLE, TYPE, STOREADRESS) VALUES " +
            "('Awesome game 1', 'PS5', true, 59.99, 'Game 1', 'Action', 'Store 1')",
            
            "INSERT INTO " + schema + ".GAME (DESCRIPTION, CONSOLE, DISPONIBLE, PRICE, TITLE, TYPE, STOREADRESS) VALUES " +
            "('Exciting adventure', 'Xbox Series X', true, 49.99, 'Game 2', 'Adventure', 'Store 2')",
            
            "INSERT INTO " + schema + ".GAME (DESCRIPTION, CONSOLE, DISPONIBLE, PRICE, TITLE, TYPE, STOREADRESS) VALUES " +
            "('Multiplayer challenge', 'PC', false, 29.99, 'Game 3', 'Multiplayer', 'Store 3')",
            
            "INSERT INTO " + schema + ".GAME (DESCRIPTION, CONSOLE, DISPONIBLE, PRICE, TITLE, TYPE, STOREADRESS) VALUES " +
            "('Sci-fi experience', 'PS5', true, 54.99, 'Game 4', 'Sci-Fi', 'Store 4')",
            
            "INSERT INTO " + schema + ".GAME (DESCRIPTION, CONSOLE, DISPONIBLE, PRICE, TITLE, TYPE, STOREADRESS) VALUES " +
            "('Puzzle-solving fun', 'Nintendo Switch', true, 39.99, 'Game 5', 'Puzzle', 'Store 5')",
            
            "INSERT INTO " + schema + ".USERS (DNI, NOMBRE, HOMEADRESS, PSWD, TLF) VALUES " +
            "('12345678A', 'User 1', 'Address 1', 'password1', '123456789')",
            
            "INSERT INTO " + schema + ".USERS (DNI, NOMBRE, HOMEADRESS, PSWD, TLF) VALUES " +
            "('23456789B', 'User 2', 'Address 2', 'password2', '987654321')",
            
            "INSERT INTO " + schema + ".USERS (DNI, NOMBRE, HOMEADRESS, PSWD, TLF) VALUES " +
            "('34567890C', 'User 3', 'Address 3', 'password3', '567890123')",
            
            "INSERT INTO " + schema + ".USERS (DNI, NOMBRE, HOMEADRESS, PSWD, TLF) VALUES " +
            "('45678901D', 'User 4', 'Address 4', 'password4', '654321098')",
            
            "INSERT INTO " + schema + ".USERS (DNI, NOMBRE, HOMEADRESS, PSWD, TLF) VALUES " +
            "('56789012E', 'User 5', 'Address 5', 'password5', '432109876')",
            
            "INSERT INTO " + schema + ".RENT (DAYRENTED, TOTALPRICE, RETURNDATE, USER_DNI, GAME_ID) VALUES " +
            "('2023-10-01', 49.99, '2023-10-10', '12345678A', 1)",
            
            "INSERT INTO " + schema + ".RENT (DAYRENTED, TOTALPRICE, RETURNDATE, USER_DNI, GAME_ID) VALUES " +
            "('2023-10-03', 39.99, '2023-10-12', '23456789B', 5)",
            
            "INSERT INTO " + schema + ".RENT (DAYRENTED, TOTALPRICE, RETURNDATE, USER_DNI, GAME_ID) VALUES " +
            "('2023-10-05', 59.99, '2023-10-15', '34567890C', 2)",
            
            "INSERT INTO " + schema + ".RENT (DAYRENTED, TOTALPRICE, RETURNDATE, USER_DNI, GAME_ID) VALUES " +
            "('2023-10-07', 29.99, '2023-10-17', '45678901D', 3)",
            
            "INSERT INTO " + schema + ".RENT (DAYRENTED, TOTALPRICE, RETURNDATE, USER_DNI, GAME_ID) VALUES " +
            "('2023-10-09', 54.99, '2023-10-19', '56789012E', 4)"
        };

        for (String insertStatement : dataInsertStatements) {
            try {
                stmt.execute(insertStatement);
                out.println("<pre>Inserted data: " + insertStatement + "</pre>");
            } catch (SQLException ex) {
                out.println("<span class='error'>Error inserting data: " + ex.getMessage() + "</span>");
                return;
            }
        }
    %>
    <button onclick="window.location='<%=request.getSession().getServletContext().getContextPath()%>'">Go home</button>
</body>
</html>
