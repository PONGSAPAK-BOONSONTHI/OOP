package Ex2;

import java.util.*;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Account> acct;
    
    public Customer() {
        this("", "");
    }
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.acct = new ArrayList();
    }
    public void addAccount(Account acct) {
        this.acct.add(acct);
    }
    public Account getAccount(int index) {
        return acct.get(index);
    }
    public int getNumOfAccount() {
        return acct.size();
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    @Override
    public String toString() {
        if (acct != null) {
            return  "The " + firstName + " " + lastName + " account has " + this.getNumOfAccount() + " Accoun.";
        }
        return firstName + " " + lastName + " doesn’t have account.";
    } 
}
