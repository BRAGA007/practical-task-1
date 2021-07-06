import java.util.Scanner;
public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value a: "); // a,b,c - coefficients of the equation  ax^2+bx+c=0
        double a = scanner.nextDouble();
        System.out.print("Enter the value b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter the value c: ");
        double c = scanner.nextDouble();
        double d = Discriminant.calculation(a,b,c);
        if (d > 0) {
            double x1 = (-b - Math.sqrt(d)) / (2 * a);
            double x2 = (-b + Math.sqrt(d)) / (2 * a);
            System.out.println("Roots of equation: x1 = " + x1 + ", x2 = " + x2);
        } else if (d == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("The equation has a single root: x = " + x);
        } else {
            System.out.println("The equation has no real roots");
        }
    }
class Discriminant{ // nested class for calculating the discriminant
	public static double calculation(Double a, Double b, Double c) {
		double discriminant =  b * b - 4 * a * c;
		return discriminant;
	}
}
}