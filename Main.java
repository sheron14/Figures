class Figures {  
  
    public Figures() {}  
    public void returnError() {
        throw new RuntimeException("There is no figure with such parameters.");  
    }
}  
  
class Circle extends Figures{  
    private double radius;  
  
    public Circle(double radius) {  
        super();
        if (radius <= 0) {
            returnError();
        }
        this.radius = radius;  
    }  
  
    public double getArea() {  
        return Math.PI * radius * radius;  
    }  
  
    public double getPerimeter() {  
        return 2 * Math.PI * radius;  
    }  
}  
  
class Triangle extends Figures{  
    private double sideA;  
    private double sideB;  
    private double sideC;  
  
    public Triangle(double sideA, double sideB, double sideC) {  
        super();
        if (sideA <= 0 || sideB <= 0 || sideC <= 0 ||   
            sideA + sideB <= sideC ||   
            sideA + sideC <= sideB ||   
            sideB + sideC <= sideA) {  
            returnError();
        }  
        this.sideA = sideA;  
        this.sideB = sideB;  
        this.sideC = sideC;  
    }  
  
    public double getArea() {  
        double semiPerimeter = (sideA + sideB + sideC) / 2;  
        return Math.sqrt(semiPerimeter *   
                         (semiPerimeter - sideA) *   
                         (semiPerimeter - sideB) *   
                         (semiPerimeter - sideC));  
    }  
  
    public double getPerimeter() {  
        return sideA + sideB + sideC;  
    }  
}  
  
class Rectangle extends Figures{  
    private double sideA;  
    private double sideB;  
  
    public Rectangle(double sideA, double sideB) {  
        super();
        if (sideA <= 0 || sideB <= 0) {  
            returnError();
        }  
        this.sideA = sideA;  
        this.sideB = sideB;  
    }  
  
    public double getArea() {  
        return sideA * sideB;  
    }  
  
    public double getPerimeter() {  
        return (sideA + sideB) * 2;  
    }  
}  

public class Main {  
    public static void main(String[] args) {  
        // Пример использования классов  
        try {  
  
            Circle circle = new Circle(7);  
            System.out.println("Circle Area: " + circle.getArea());  
            System.out.println("Circle Perimeter: " + circle.getPerimeter());  
  
            Triangle triangle = new Triangle(3, 4, 5);  
            System.out.println("Triangle Area: " + triangle.getArea());  
            System.out.println("Triangle Perimeter: " + triangle.getPerimeter());  
        } catch (RuntimeException e) {  
            System.err.println(e.getMessage());  
        }  
    }  
}  