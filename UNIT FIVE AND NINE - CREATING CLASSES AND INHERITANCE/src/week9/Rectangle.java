package week9;

public class Rectangle {
    private int length;
    private int width;


    public Rectangle(int l, int w) {
    length = 1;
    width = w;

}

    public Rectangle(int side) {
        length = side;
        width = side;
}

    public int getArea() {
        return length * width;
}

    public int getPerimeter() {
        return 2 * length + 2 * width;
}

    public boolean isSquare() {
        return length == width;
}

    public String toString() {
        return "Rectangle with a width of " + width + "and length of " + length;
}
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        
        if ( obj instanceof Rectangle) {
            Rectangle r = (Rectangle) obj;
            return length == r.length && width == r.width;
        } else {
            return false;
        }

        }
    }

