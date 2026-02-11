package Ex1;

public class Customer {
    private String firstName;
    private String lastName;
    private Account acct[];
    private int numOfAccount;
    
    public Customer() {
        this("", "");
    }
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.acct = new Account[5];
    }
    public void addAccount(Account acct) {
        this.acct[numOfAccount] = acct;
        numOfAccount += 1;
    }
    public Account getAccount(int index) {
        return acct[index];
    }
    public int getNumOfAccount() {
        return numOfAccount;
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
