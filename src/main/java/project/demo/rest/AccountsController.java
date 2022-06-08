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
            map = accountRepository.findAllAccounts();
        } catch (Exception e) {
            System.out.print("[error]" + e.toString());
        }
    }

    public HttpHeaders create() throws Exception {
        System.out.println("CAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        model = accountRepository.save(account);
        System.out.println(account.toString());
        return new DefaultHttpHeaders("create");
    }

    public HttpHeaders show() {
        System.out.println("SAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        try {
            model = accountRepository.getAccountById(getId());
        } catch (Exception e) {

        }
        return new DefaultHttpHeaders("show");
    }

    public HttpHeaders index() {
        System.out.println("IAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
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
}