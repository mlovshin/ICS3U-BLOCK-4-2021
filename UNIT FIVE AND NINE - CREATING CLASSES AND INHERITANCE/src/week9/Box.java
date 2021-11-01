package week9;

public class Box extends Rectangle{     //implicit, they will create a constructor for you if you do not create one
    /**
     * If you do not explicitly write a constuctor, then java will implicity write one for you that takes NO ARGUMENTS and calls the parent class' NO ARGUMENT constructor
     */
    /*
    public Box() {
        super(); - refers to the parent class
        this - instance of a class
    }
    */

    private int height;

    public Box(int l, int w, int h) {
        /** 
         * we do not get to directly access the parent class' private attributes and methods
         * if you don't call the constructor, java will call the parent' no-argument construtor for you
        
        length = l;
        width = w;
        */
        /**
         * first statement of a character MUST be a call to the classes parent constructor
         * uses the parent function to call the length and width */

        super(l, w);
        height = h;
    }

    public Box(int side) {
        super(side);
        height = side;
    }

    
}
