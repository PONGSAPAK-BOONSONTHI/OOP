public class Seller extends Employee{
    public Food sell(Employee e) {
        Wallet E_wallet = e.getWallet();
        Food f = new Food();
        if (E_wallet.getBalance() >= f.getPrice()) {
            this.getWallet().setBalance(this.getWallet().getBalance() + f.getPrice());
            E_wallet.setBalance(E_wallet.getBalance() - f.getPrice());
            return f;
        }
        System.out.println("Your money is not enough.");
        return null;
    }
}