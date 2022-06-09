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
         } catch (Exception e) {
            e.printStackTrace();
         }

         return null;
    }

    public Map<String, Account> findAllAccounts() throws SQLException{
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;
        // map.clear();

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
            }
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
        
        return map;
    }

    public Map<String, Account> getAccountById(int id) throws SQLException{
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;
        // map.clear();

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
            } 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
        
        return map;
    }

    public Map<String, Account> updateAccountById(int id, Account account) throws SQLException{
        String sql = queryStringBuilder(id, account);

        if(sql != null) {
            Connection connection = connectToDB();
            Statement statement = null;
    
            try {
                if (connection != null) {
                    statement = connection.createStatement();
                    statement.executeUpdate(sql);
                } 
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
                if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
            }
        }
        
        return map;
    }

    public Map<String, Account> save(Account account) throws SQLException{
        if(checkFields(account)) {
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
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
                if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
            }
        }

        return map;
    }

    private boolean queryFieldChecker (String fieldName, String value) {
        switch (fieldName) {
            case "username": 
                if(value != null && (value.length() >= 4 && value.length() <= 20)) {
                    return true;
                }
            case "password":
                if(value != null && (value.length() >= 8 && value.length() <= 20)) {
                    return true;
                }
            case "firstName":
                if(value != null && value.length() <= 50) {
                    return true;
                }
            case "lastName":
                if(value != null && value.length() <= 50) {
                    return true;
                }
            case "email":
                if(value != null && value.length() <= 50) {
                    return true;
                }
            default:
                return false;
        }
    }

    private String singleQuoteWrapper(String string) {
        return "'" + string + "'";
    }

    private String queryStringBuilder(int id, Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
        String firstName = account.getFirstName();
        String lastName = account.getLastName();
        String email = account.getEmail();

        String query = "UPDATE accounts\n" +
            "SET\n";

        boolean updateFlag = false;
        
        if(queryFieldChecker("username", username)) {
            updateFlag = true;
            query += "username = " + singleQuoteWrapper(username);
            if(queryFieldChecker("password", password)) {
                query += ", ";
            }
        }
        if(queryFieldChecker("password", password)) {
            updateFlag = true;
            query += "password = " + singleQuoteWrapper(password);
            if(queryFieldChecker("firstName", firstName)) {
                query += ", ";
            }
        }
        if(queryFieldChecker("firstName", firstName)) {
            updateFlag = true;
            query += "first_name = " + singleQuoteWrapper(firstName);
            if(queryFieldChecker("lastName", lastName)) {
                query += ", ";
            }
        }
        if(queryFieldChecker("lastName", lastName)) {
            updateFlag = true;
            query += "last_name = " + singleQuoteWrapper(lastName);
            if(queryFieldChecker("email", email)) {
                query += ", ";
            }
        }
        if(queryFieldChecker("email", email)) {
            updateFlag = true;
            query += "email = " + singleQuoteWrapper(email);
        }
            
        query += "\nWHERE id = " + id;

        if(!updateFlag) {
            query = null;
        }
        
        return query;
    }

    private boolean checkFields(Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
        String firstName = account.getFirstName();
        String lastName = account.getLastName();
        String email = account.getEmail();

        if((username == null || (username.length() < 4 || username.length() > 20)) ||
            (password == null || (password.length() < 8 || password.length() > 20)) ||
            (firstName == null || firstName.length() > 50) ||
            (lastName == null || lastName.length() > 50) ||
            (email == null || email.length() > 50)) {
                return false;
        }

        return true;
    }
}
