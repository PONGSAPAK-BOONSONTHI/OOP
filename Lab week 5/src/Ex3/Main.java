package Ex3;

// public class Main {
//     public static void main(String[] args) {
//         Player p1 = new Player();
//         p1.setName("Bank");
//         p1.setTeam("Gate OR");
//         Player p2 = new Player();
//         p2.setName("Khim");
//         p2.setTeam("Gate OR");
//         if (p1.isSameTeam(p2))
//             System.out.println(p1.getName() + " is a same team with " + p2.getName());
//         else
//             System.out.println(p1.getName() + " is not a same team with " + p2.getName());
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Player p1 = new Player();
//         p1.setName("Bank");
//         p1.setTeam("Gate OR");
//         System.out.println(p1.name);
//     }
// }

// public class Main {
// public static void main(String[] args) {
// FootballPlayer p1 = new FootballPlayer();
// p1.setName("Harry");
// p1.setTeam("Gryffindor");
// p1.setPlayerNumber(1);
// p1.setPosition("keeper");
// FootballPlayer p2 = new FootballPlayer();
// p2.setName("Jame");
// p2.setTeam("Gryffindor");
// p2.setPlayerNumber(1);
// p2.setPosition("keeper");
// System.out.println("We are same position : " + p1.isSamePosition(p2));
// System.out.println("We are same team : " + p1.isSameTeam(p2));
// }
// }

public class Main {
    public static void main(String[] args) {
        FootballPlayer p1 = new FootballPlayer();
        p1.setName("Harry");
        p1.setTeam("Gryffindor");
        p1.setPlayerNumber(1);
        p1.setPosition("keeper");
        FootballPlayer p2 = new FootballPlayer();
        p2.setName("Jame");
        p2.setTeam("Gryffindor");
        p2.setPlayerNumber(1);
        p2.setPosition("fullback");
        System.out.println("We are same position : " + p1.isSamePosition(p2));
        System.out.println("We are same team : " + p1.isSameTeam(p2));
    }
}