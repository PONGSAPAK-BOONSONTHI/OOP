public class Seller extends Employee{
    public Food sell(Employee e) {
        Wallet E_wallet = e.getWallet();
        Food f = new Food();
        if (E_wallet.getBalance() >= Food.getPrice()) {
            this.getWallet().setBalance(this.getWallet().getBalance() + Food.getPrice());
            E_wallet.setBalance(E_wallet.getBalance() - Food.getPrice());
            return f;
        }
        System.out.println("Your money is not enough.");
        return null;
    }
}