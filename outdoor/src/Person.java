public class Person {
    int age;

    public Person(int age){
        this.age = age;
    }

    public static void main(String[] args) {
        Person newPerson = new Person(20);
        celebrateBirthday(newPerson);
        System.out.println(newPerson.age);
    }
    public static void celebrateBirthday(Person p){
        p.age = p.age +1;
    }
}
