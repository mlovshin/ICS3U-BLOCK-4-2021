package week4;

public class BayviewGlenPools {
    public static void main(String[] args) {
        final int length = 20;
        final int width = 8;
        final int shallowLength = 5;
        final int transition = 7;
        final int shallowHeight = 3;
        final int deepHeight = 8;

        final int linerCost = 2;

        double getVolume = getVolume(length, width, shallowLength, transition, shallowHeight, deepHeight);
        double getSurfaceArea = getSurfaceArea(length, width, shallowLength, transition, shallowHeight, deepHeight);

        
    }
    private static double getVolume(int length, int width, int shallowLength, int transition, int shallowHeight,
    int deepHeight) {
        double shallowVolume = shallowLength * width * shallowHeight;

        double transitionBase = Math.sqrt(Math.pow(transition, 2)) - Math.pow(deepHeight - shallowHeight, 2);   // basically the hypotenuse a^2 + b^2 = c^2, write it out to find the base hypotenuse
        double deepLength = length - shallowLength - transitionBase;
        double deepVolume = deepLength * width * deepHeight;

        double transitionVolume = transitionBase * width * (deepHeight - shallowHeight)* 0.5;
        double aboveTransitionVolume = shallowHeight * width * transitionBase;

        return transitionVolume + shallowVolume + deepVolume + aboveTransitionVolume;           // 982
    }







private static double getSurfaceArea(int length, int width, int shallowLength, int transition, int shallowHeight,
    int deepHeight) {
        double transitionBase = Math.sqrt(Math.pow(transition, 2)) - Math.pow(deepHeight - shallowHeight, 2);   // basically the hypotenuse a^2 + b^2 = c^2, write it out to find the base hypotenuse

        double saShallow = 2 * ((width * shallowLength)+ (shallowHeight * shallowLength) + (shallowHeight * width));
        double deepLength = length - shallowLength - transitionBase;
        double saDeep = 2 * ((width * deepLength) + (deepHeight * deepLength) + (deepHeight * width));
        double saTransition = ((transitionBase) + (deepHeight - shallowHeight) / 2);
        return saShallow + saDeep + saTransition;

        // 510



    }


   

    
}
