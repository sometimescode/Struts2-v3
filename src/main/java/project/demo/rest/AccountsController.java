package project.demo.rest;

import java.util.Map;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

import project.demo.model.Account;

public class AccountsController implements ModelDriven<Object> {
    private static final long serialVersionUID = 1L; 
    private Object model;
    private AccountsRepository accountRepository = new AccountsRepository();
    private static Map<String, Account> map;
    private int id;
    private Account account = new Account();

    {
        try {
            map = null;
            map = accountRepository.findAllAccounts();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HttpHeaders update() {
        try {
            model = accountRepository.updateAccountById(getId(), account);
            System.out.println(account.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DefaultHttpHeaders("update");
    }

    public HttpHeaders create() {
        try {
            model = accountRepository.save(account);
            System.out.println(account.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DefaultHttpHeaders("create");
    }

    public HttpHeaders show() {
        try {
            model = accountRepository.getAccountById(getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DefaultHttpHeaders("show");
    }

    public HttpHeaders index() {
        model = map;
        return new DefaultHttpHeaders("index").disableCaching();
    }    

    @Override
    public Object getModel() {
        return (model != null ? model : account);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
}