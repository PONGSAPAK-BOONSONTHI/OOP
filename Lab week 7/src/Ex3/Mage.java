package Ex3;

public class Mage extends Player {

    public Mage() {
        setHP(10);
        setMP(20);
        setATK(5);
    }
    public void addEquipment(Item i) {
        i.use(this);
    }
    @Override
    public void attack(Player p) {
        p.attacked(this.getATK() * 2.5);
        this.setMP(this.getMP() - 5);
    }
    @Override
    public void attacked(double n) {
        this.setHP(this.getHP() - n);
        if (this.getHP() < 0) {
            this.setHP(0);
        }
    }
}
