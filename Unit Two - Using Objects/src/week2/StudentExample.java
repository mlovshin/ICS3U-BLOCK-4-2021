package week2;

public class StudentExample {
    public static void main(String[] args) {
        Student fred = new Student("Fred", "654321", 10 );  // fred is a reference to a Student in brackets
        Student max = new Student("Max", "12345", 10); // max is a refernce to a Student in brackets
        Student muriel = fred; // assigning muriel to fred with the same Student in brackets 
        muriel.increaseGrade();

        fred = null;
       // java throws a NullPointerException, fred doesn't equal Student anymore but muriel still has the value because she has an arrow to the bubble
        //non-static methods belongs to the OBJECT(Student) not the CLASS(public static void main)
        // attributes define the state
        // overloading is when you have

        max.addTest(87);
        max.addTest(94);
        max.addTest(98);
        max.addTest(67);
        max.displayAverage();

       
        System.out.println(max.getName() + "has an average of " + max.getAverage());


        Student david = new Student("David", "565858");



    }
    

    
}
