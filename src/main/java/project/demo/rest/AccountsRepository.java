package project.demo.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import project.demo.model.Account;

public class AccountsRepository {
    private static Map<String, Account> map = new HashMap<String, Account>();
   
    public Connection connectToDB() throws SQLException {
        Connection connection = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/sampledb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            return connection;
         } catch (SQLException e) {
            //  error = e.toString();
         } catch (ClassNotFoundException e) {
            // error = e.toString();
        }
         return null;
    }

    public Map<String, Account> findAllAccounts() throws SQLException{
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;
        map.clear();

        try {
            if (connection != null) {
                String sql = "SELECT id, first_name, last_name, email FROM accounts";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                int index = 0;

                while(rs.next()){  
                    Account account = new Account();
                    account.setId(rs.getInt(1));
                    account.setFirstName(rs.getString(2));
                    account.setLastName(rs.getString(3));
                    account.setEmail(rs.getString(4));
                    map.put(Integer.toString(++index), account);
                }

                preparedStatement.close();
                connection.close();
            } 
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
        
        return map;
    }

    public Map<String, Account> getAccountById(int id) throws SQLException{
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;
        map.clear();

        try {
            if (connection != null) {
                String sql = "SELECT id, first_name, last_name, email FROM accounts WHERE id = '" + id + "'";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                int index = 0;

                while(rs.next()){  
                    Account account = new Account();
                    account.setId(rs.getInt(1));
                    account.setFirstName(rs.getString(2));
                    account.setLastName(rs.getString(3));
                    account.setEmail(rs.getString(4));
                    map.put(Integer.toString(++index), account);
                }

                preparedStatement.close();
                connection.close();
            } 
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
        
        return map;
    }

    public Map<String, Account> save(Account account) throws SQLException{
        Connection connection = connectToDB();
        Statement statement = null;

        try {
            if(connection != null) {
                statement = connection.createStatement();
                String sql = "INSERT INTO ACCOUNTS(username, password, first_name, last_name, email) " +
                    "VALUES('"+account.getUsername()+"','"+account.getPassword()+"','"+
                    account.getFirstName()+"','"+account.getLastName()+"','" +
                    account.getEmail()+"')";
                statement.executeUpdate(sql);

            }
        } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
        
        return map;
    }
}
