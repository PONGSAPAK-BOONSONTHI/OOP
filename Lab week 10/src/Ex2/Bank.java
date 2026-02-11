package Ex2;

public class Bank {
    private Account Acct[];
    private int numAcct;
    
    public Bank() {
        Acct = new Account[10];
    }
    public void addAccount(Account ac) {
        Acct[numAcct] = ac;
        numAcct += 1;
    }
    public Account getAccount(int index) {
        return Acct[index];
    }
    public int getNumAccount() {
        return numAcct;
    }
}
