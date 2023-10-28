<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Database Table Creation</title>
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
    <h2>Database Table Creation</h2>
    <%
        String dbname = "gameStore";
        String schema = "ROOT";
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbname, "root", "root");
        Statement stmt = con.createStatement();

        /* Drop tables if they exist */
        String[] tableDropStatements = new String[]{
            "DROP TABLE " + schema + ".RENT",
            "DROP TABLE " + schema + ".USERS",
            "DROP TABLE " + schema + ".GAME"
        };

        for (String dropTableStatement : tableDropStatements) {
            try {
                stmt.execute(dropTableStatement);
                out.println("<pre>Dropped table: " + dropTableStatement + "</pre>");
            } catch (SQLException ex) {
                // Ignore errors if the table doesn't exist
                out.println("<pre>Drop failed " + ex+ "</pre>");
            }
        }

        /* Create tables */
        String[] tableCreationStatements = new String[]{
            "CREATE TABLE " + schema + ".GAME (" +
                "ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                "DESCRIPTION VARCHAR(1000), " +
                "CONSOLE VARCHAR(255), " +
                "DISPONIBLE BOOLEAN, " +
                "PRICE DECIMAL(10, 2), " +
                "TITLE VARCHAR(255), " +
                "TYPE VARCHAR(255), " +
                "STOREADRESS VARCHAR(1000), " +
                "PRIMARY KEY (ID)" +
            ")",
            
            "CREATE TABLE " + schema + ".USERS (" +
                "DNI VARCHAR(255), " +
                "NOMBRE VARCHAR(255), " +
                "HOMEADRESS VARCHAR(1000), " +
                "PSWD VARCHAR(255), " +
                "TLF VARCHAR(255), " +
                "PRIMARY KEY (DNI)" +
            ")",
            
            "CREATE TABLE " + schema + ".RENT (" +
                "ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                "DAYRENTED DATE, " +
                "TOTALPRICE DECIMAL(10, 2), " +
                "RETURNDATE DATE, " +
                "USER_DNI VARCHAR(255), " +
                "GAME_ID INT, " +
                "PRIMARY KEY (ID), " +
                "FOREIGN KEY (USER_DNI) REFERENCES " + schema + ".USERS(DNI), " +
                "FOREIGN KEY (GAME_ID) REFERENCES " + schema + ".GAME(ID)" +
            ")"
        };

        for (String createTableStatement : tableCreationStatements) {
            try {
                stmt.execute(createTableStatement);
                out.println("<pre>Created table: " + createTableStatement + "</pre>");
            } catch (SQLException ex) {
                out.println("<span class='error'>Error creating table: " + ex.getMessage() + "</span>");
                return;
            }
        }
    %>
    <button onclick="window.location='<%=request.getSession().getServletContext().getContextPath()%>'">Go home</button>
</body>
</html>
