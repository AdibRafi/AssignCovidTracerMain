

public class PersonTest {
    public static void main(String[] a) {
        /*//without polymorphism
        Person p = new Person("Ali","Normal");
        System.out.println(p);

        Person p1 = new Person("Bob", "Case");
        System.out.println(p1);

        Person p2 = new Person("Cindy", "Close");
        System.out.println(p2);

        Person p3 = new Person("Danny", "Normal");
        System.out.println(p3);

        Person p4 = new Person("Afiq", "Normal");
        System.out.println(p3);*/

        //with Polymorphism
        System.out.println("With Polymorphism");
        Person[] persons = {
                new Person("Abu","Normal"), new Person("Ben", "Close"), new Person("James", "Case"), new Person("Donna", "Normal")
        };
        for (Person obj : persons)
            System.out.println(obj);

    }
}
