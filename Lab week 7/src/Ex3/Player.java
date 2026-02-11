package Ex3;

public abstract class Player {
    private double ATK;
    private double EXP;
    private double HP;
    private double MP;
    private double Money;

    public void setATK(double ATK) {
        this.ATK = ATK;
    }
    public void setEXP(double EXP) {
        this.EXP = EXP;
    }
    public void setHP(double HP) {
        this.HP = HP;
    }
    public void setMP(double MP) {
        this.MP = MP;
    }
    public void setMoney(double Money) {
        this.Money = Money;
    }
    public double getATK() {
        return ATK;
    }
    public double getEXP() {
        return EXP;
    }
    public double getHP() {
        return HP;
    }
    public double getMP() {
        return MP;
    }
    public double getMoney() {
        return Money;
    }
    public abstract void attack(Player p);
    public abstract void attacked(double n);
    public String toString() {
        return "HP : " + HP + " MP : " + MP + "  ATK : " + ATK;
    }
}
