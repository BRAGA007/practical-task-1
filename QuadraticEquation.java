import java.util.Scanner;
public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение a: "); // a,b,c - коэффиценты уравнения типа ax^2+bx+c=0
        double a = scanner.nextDouble();
        System.out.print("Введите значение b: ");
        double b = scanner.nextDouble();
        System.out.print("Введите значение c: ");
        double c = scanner.nextDouble();
        double d = Discriminant.calculation(a,b,c);
        if (d > 0) {
            double x1 = (-b - Math.sqrt(d)) / (2 * a);
            double x2 = (-b + Math.sqrt(d)) / (2 * a);
            System.out.println("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
        } else if (d == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("Уравнение имеет единственный корень: x = " + x);
        } else {
            System.out.println("Уравнение не имеет действительных корней");
        }
    }
class Discriminant{ // вложенный класс для вычисления дискриминанта
	public static double calculation(Double a, Double b, Double c) {
		double discriminant =  b * b - 4 * a * c;
		return discriminant;
	}
}
}