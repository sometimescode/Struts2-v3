package project.demo.action;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import project.demo.model.Account;

import java.sql.Connection;                
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountList extends ActionSupport {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private ArrayList<String> listOfFirstNames = new ArrayList<String>();
    private Account fetchedAccount = new Account();
    private String nameInput;
    private String error;

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<Account> getAccounts() {  
        return accounts;  
    }  

    public void setAccountList(ArrayList<Account> accounts) {  
        this.accounts = accounts;  
    }  

    public Account getFetchedAccount() {
        return fetchedAccount;
    }

    public void setFetchedAccount(Account fetchedAccount) {
        this.fetchedAccount = fetchedAccount;
    }

    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    
    public ArrayList<String> getListOfFirstNames() {
        return listOfFirstNames;
    }

    public void setListOfFirstNames(ArrayList<String> listOfFirstNames) {
        this.listOfFirstNames = listOfFirstNames;
    }

    public Connection connectToDB() throws SQLException {
        Connection connection = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/sampledb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            return connection;
         } catch (SQLException e) {
             error = e.toString();
         } catch (ClassNotFoundException e) {
            error = e.toString();
        }
         return null;
    }

    public Account findFromDB() throws SQLException {
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;

        try {
            if (connection != null) {
                String sql = "SELECT first_name, last_name, email FROM accounts WHERE first_name = '" + nameInput + "'";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                while(rs.next()){  
                    Account account = new Account();
                    account.setFirstName(rs.getString(1));
                    account.setLastName(rs.getString(2));
                    account.setEmail(rs.getString(3));
                    return account;
                }

                preparedStatement.close();
                connection.close();
            } 
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }

        return null;
    }

    public String execute() throws SQLException {
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;

        try {
            if (connection != null) {
                String sql = "SELECT first_name, last_name, email FROM accounts";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                while(rs.next()){  
                    Account account = new Account();
                    account.setFirstName(rs.getString(1));
                    account.setLastName(rs.getString(2));
                    account.setEmail(rs.getString(3));
                    accounts.add(account);
                    listOfFirstNames.add(account.getFirstName());
                }

                preparedStatement.close();
                connection.close();
            } 
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
        return SUCCESS;
    }

    public String displayUser() throws Exception {
        fetchedAccount = findFromDB();
        if(fetchedAccount != null) {
            return SUCCESS;
        } else{
            error = "User not found";
            return ERROR;
        }
    }
}