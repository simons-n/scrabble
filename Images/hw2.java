/*
Nick Simons & Caroline Whitman
hw2_p1.java
7 Sept 2016
csci208
*/

public class Csci208_hw2 {

    public enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public static class Dog {
        private int age;
        private int weight;

        public Dog(int age, int weight) {
            this.age = age;
            this.weight = weight;
        }
    }

    public static void problemOne() {

        System.out.println("ENUM");
        Month m1 = Month.JANUARY;
        Month m2 = Month.FEBRUARY;
        Month m3 = Month.FEBRUARY;
        if (m1.ordinal() < m2.ordinal()) {
            System.out.println("January < February\n");
        }

        Dog myDog = new Dog(5, 10);
        System.out.println(
                "My dog is " + myDog.age + " years old and weighs " + myDog.weight + " pounds.\n");

        System.out.println("ARRAY");
        int[] myArray = new int[10];
        myArray[0] = 10;
        myArray[1] = 20;
        System.out.println("myArray[0] = " + myArray[0]);
        System.out.println("myArray[1] = " + myArray[1] + "\n");
    }

    public static void problemTwo() {
        int i = 4;
        double d = 4.5;
        double sum = i + d;
        System.out.println("int + double: (double) sum = " + sum);

        int intSum = 0;
        //intSum = d + i;
        System.out.println("int + double saved into intSum: lossy conversions "
                           + "not allowed in Java");

        char c1 = 'a';
        System.out.println("char / double = " + (c1 / d));

        //i = true;
        System.out.println("Assign boolean value to an int type variable. This"
                           + "results in an incompatable type error because "
                           + "boolean cannot be converted to an int.");
    }

    public static void problemThree() {
        int a = 4;
        String b = "cats";
	
	// UNCOMMENT THE FOLLOWING 2 LINES TO GET THE COMPILE-TIME ERROR

        //int sum = a + b;
        //System.out.println("sum " + sum);
        /*
        This program initializes an int, a, with the value of 4, and initializes
        a string, b, with "cats". a and b are added together and stored in an
        an int-typed variable, sum. This produces a compile-time error because
        "String cannot be converted to int". This would compile on Python, but
        on runtime, would result in the same error.
         */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("PROBLEM 1\n");

        problemOne();
        System.out.println("PROBLEM 2\n");
        problemTwo();
        System.out.println("PROBLEM 3\n");
        problemThree();
    }

}
