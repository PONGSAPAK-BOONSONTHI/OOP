

public class Customer {
    private String firstName;
    private String lastName;
    private CheckingAccount acct;
    
    public Customer() {
        this("", "", null);
    }
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.acct = null;
    }
    public Customer(String firstName, String lastName, CheckingAccount acct) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.acct = acct;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAcct(CheckingAccount acct) {
        this.acct = acct;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public CheckingAccount getAcct() {
        return acct;
    }
    @Override
    public String toString() {
        if (acct != null) {
            return  "The " + firstName + " account has " + acct.getBalance() + " baht and " + acct.getCredit() + " credits.";
        }
        return firstName + " " + lastName + " doesn’t have account.";
    }
    public boolean equals(Customer c) {
        return this.firstName.equals(c.firstName) && this.lastName.equals(c.lastName);
    }
}
