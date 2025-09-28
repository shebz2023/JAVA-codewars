interface Shape {
    double calculateArea();

}

class Circle implements Shape {
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 3.14 * radius * radius;
    }

}

class Rectangle implements Shape {
    int l, w;

    Rectangle(int l, int w) {
        this.l = l;
        this.w = w;
    }

    @Override
    public double calculateArea() {
        return l * w;
    }

}

class Triangle implements Shape {
    int h, b;

    Triangle(int b, int h) {
        this.b = b;
        this.h = h;
    }

    @Override
    public double calculateArea() {
        return 0.5 * b * h;
    }

}

class PrintArea {
    public double area(Shape shape) {
        return shape.calculateArea();
    }

}

public class polymorphism {

    public static void main(String[] args) {
        PrintArea printArea = new PrintArea();
        double result = printArea.area(new Circle(10));
        System.out.println("the area is" + result);
    }
}
