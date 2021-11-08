package week10;

public class ArrayExamples {
    public static void main (String[] args) {
        int [] arr = new int [5];   
        
        // [] used to show the size of the array
        // arrays are refrence types, put the address in the box (where to find it)
    }

    private static void exampleTwo() {
        Animal[] animals = new Animal[3];
        animals[1] = new Animal();
    }

    private static void exampleOne(){
        int[] arr = new int[5]; 

        arr[4] = 2;
        arr[3] = 7;         // switches so that 4 gets a value of 7, and 3 gets a value of 2
                            // (array.length - 1 (or 2)) to find the last or second last digit of the array

        System.out.println(arr.length);


    }
}