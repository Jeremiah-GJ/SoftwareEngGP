// Database.java
package final_proj;

import java.sql.*;

public class Database {
    private Connection conn;

    public Database() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/chatdb"; 
        String user = "root"; 
        String password = ""; 
        conn = DriverManager.getConnection(url, user, password);
    }

    public boolean verifyAccount(String username, String password) {
        try {
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
    public boolean createNewAccount(String username, String password) {
        try {
            String checkQuery = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                return false; 
            }

            String insertQuery = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            insertStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
