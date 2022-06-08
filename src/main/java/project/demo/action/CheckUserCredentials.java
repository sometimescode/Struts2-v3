package project.demo.action;

import java.sql.PreparedStatement;
import java.sql.Connection;                
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import project.demo.model.Account;

public class CheckUserCredentials  extends ActionSupport {
    private String username;
    private String password;

    private Account fetchedAccount;
    private String error = "";
    private String validationString = "";

    public String execute() throws SQLException {
        username = getUsername();
        password = getPassword();

        if(fetchFromDB()) {
            if(fetchedAccount == null) {
                validationString = "Username or password is invalid.";
                return INPUT;
            }
            else {
                return SUCCESS;
            }
        } else {
            return ERROR;
        }
    }

    public boolean fetchFromDB() throws SQLException  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String URL = "jdbc:mysql://localhost:3306/sampledb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            if (connection != null) {
                String sql = "SELECT first_name, last_name, email FROM ACCOUNTS WHERE username = '" + username + "' AND password = '" + password + "'";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){  
                    fetchedAccount = new Account();
                    fetchedAccount.setFirstName(rs.getString(1)); 
                    fetchedAccount.setLastName(rs.getString(2));
                    fetchedAccount.setEmail(rs.getString(3));
                }
                return true;
            } else {
                error = "DB connection failed";
                return false;
            }
         } catch (Exception e) {
            error = e.toString();
            return false;
         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getFetchedAccount() {
        return fetchedAccount;
    }

    public void setFetchedAccount(Account fetchedAccount) {
        this.fetchedAccount = fetchedAccount;
    }

    public String getError() {
        return error;
    }

    public String getValidationString() {
        return validationString;
    }
}
