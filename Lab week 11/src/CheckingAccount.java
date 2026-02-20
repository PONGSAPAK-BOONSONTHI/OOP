

public class CheckingAccount extends Account{
    private double credit;

    public CheckingAccount() {
        this(0, "", 0);
    }
    public CheckingAccount(double balance, String name, double credit) {
        super(balance, name);
        this.credit = credit;
    }
    public void setCredit(double credit) {
        if (credit <= 0) {
            System.out.println("Input number must be a positive integer.");
            return;
        }
        this.credit = credit;
    }
    public double getCredit() {
        return credit;
    }
    @Override
    public void withdraw(double a) throws WithdrawException {
        if (a < 0) {
            System.out.println("Input number must be a positive integer.");
            return;
        }
        if (balance >= a) {
            System.out.println(a + " baht is withdrawn from " + name + " and your credit balance is " + credit + ".");
            balance -= a;
        } else if ((balance + credit) >= a) {
            credit -= a - balance;
            balance = 0;
            System.out.println(a + " baht is withdrawn from " + name + " and your credit balance is " + credit + ".");
        } else {
            throw new WithdrawException("Account " + getName() + " has not enough money.");           
        }
    }
    public void withdraw(String a) throws WithdrawException {
        withdraw(Double.parseDouble(a));
    }
    @Override
    public String toString() {
        return  "The " + name + " account has " + balance + " baht and " + credit + " credits.";
    }

}
