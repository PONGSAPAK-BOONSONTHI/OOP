package Ex3;

public class Novice extends Player {
    
    public Novice() {
        setHP(10);
        setMP(10);
        setATK(5);
    }
    public void addEquipment(Item i) {
        i.use(this);
    }
    @Override
    public void attack(Player p) {
        p.attacked(this.getATK());
    }

    @Override
    public void attacked(double n) {
        this.setHP(this.getHP() - n);
        if (this.getHP() < 0) {
            this.setHP(0);
        }
    }
}
