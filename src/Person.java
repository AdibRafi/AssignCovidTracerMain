
/*class Person {
    String name;
    Person(){}
    Person(String name){
        this.name = name;
    }
}*/
public class Person{
    private String name;
    private String status;
    public Person() {}
    public Person(String n) {this.name = n;}
    public Person(String n,String s) { this.name = n;this.status=s;}
    public String getName() {return name;}





    @Override
    public String toString() {
        return "Person: name = " + name;
    }
}
