public class Owner {
    protected final String name;
    protected Animal animal;
    
    public Owner() {
        this("", null);
    }
    public Owner (String name) {
        this(name, null);
    }
    public Owner (Animal animal) {
        this("", animal);
    }
    public Owner (String name, Animal animal) {
        this.name = name;
        this.animal = animal;
    }
    public String getName() {
        return name;
    }
    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public void feedFood(Food f) {
        this.animal.eat(f);
    }
    @Override
    public String toString() {
        return "Owner : name = " + name + ", " + animal.toString();
    }
    public void protectOwnerFrom(Animal a) {
        if (this.animal instanceof Dog dog) {
            dog.kick(a);
        } else if (this.animal instanceof Pigeous pigeous) {
            pigeous.wingAttack(a);
        }
    }
    
}
