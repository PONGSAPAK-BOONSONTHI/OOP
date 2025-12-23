package Ex1;

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        String name = "John Doe";
        p.setName(name);
        int age = 25;
        p.setAge(age);
        System.out.println("This person's name is " + p.getName() + " and they are " + p.getAge() + " years old.");
    }
}
