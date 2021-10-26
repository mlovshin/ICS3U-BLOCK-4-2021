package week8;

public class Die {
        // attributes define the state of an instance of the class at any particular time
        // private means they are only visible inside the class (we don't want other people to sue them)
        private int numSides;      
        private int topSide;

        /** Constructors
         * Has the same names as the class
         * Initizalizes the state of the class (attribiutes)
         * returns the Object (althought we do not say return)
        */

        /**
         * If we do not Explicityly create our own contructors JAVA will supply a NO ARGUMENT constructor that does not initialize the state of the class (attribute)
         */
        

        public Die() {
            numSides = 6;
            topSide = (int) ((Math.random()) * numSides) + 1;

        }
        public Die(int numSides) {
            this.numSides = numSides;
            topSide = (int) (Math.random() * numSides) + 1;
        }
        public int getTopSide() {
            return topSide;
        }
        public void roll() {
            topSide = (int)((Math.random()) * numSides) + 1;
        }
        public boolean equals(Object obj) {
            if (obj instanceof Die) {
                return this.topSide == ((Die)obj).topSide;      // Die puts it into the proper class (or field)
            } else {
                return false;
            }
            
        }
}