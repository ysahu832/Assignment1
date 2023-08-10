package javacore;
class Rectangle {
    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public void setRectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }
}

class Box extends Rectangle {
    private double height;

    public Box(double length, double width, double height) {
        super(length, width);
        this.height = height;
    }

    public double getVolume() {
        return length * width * height;
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Box box = new Box(20.0, 10.0, 6.0);

        System.out.println("Box area: " + box.getArea());
        System.out.println("Box volume: " + box.getVolume());
        
        box.setRectangle(8.0, 4.0);
        System.out.println("Updated box area: " + box.getArea());
        System.out.println("Box volume: " + box.getVolume());
    }
}