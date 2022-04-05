package Trees_OOP;

/**
 *
 * @author khoai2601
 */
public class Person {

    private String Name;
    private int age;

    public Person() {
    }

    public Person(String Name, int age) {
        this.Name = Name;
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return Name + "-" + age;
    }

//    public boolean equals(Person person) {
//        if (this == person) {
//            return true;
//        }
//        if (person == null) {
//            return false;
//        }
//        return this.Name.equalsIgnoreCase(person.Name) && this.age == person.age;
//    }
//
//    public boolean compare(Person person) {
//        if (this.getName().compareToIgnoreCase(person.getName()) > 0) {
//            return true;
//        }
//        if (this.getName().compareToIgnoreCase(person.getName()) < 0) {
//            return false;
//        }
//        if (this.getName().compareToIgnoreCase(person.getName()) == 0) {
//            if (this.getAge() > person.getAge()) {
//                return true;
//            }
//            if (this.getAge() < person.getAge()) {
//                return false;
//            }
//        }
//        return true;
//    }

}
