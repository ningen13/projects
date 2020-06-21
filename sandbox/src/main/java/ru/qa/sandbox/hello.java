package ru.qa.sandbox;

public class hello {

public static void main(String[] args) {

    hello("wut");
    hello("there");
    hello("Aleksey");

double length = 3;
System.out.println("Площадь квардрата со стороной " + length + " равна " + areasq(length));

    double a = 5;
    double b = 6;
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " равна " + arearec(a, b));

}

public static void hello (String someone) {
    System.out.println("Hello, " + someone + "!");
}

public static double areasq(double length) {
    return length * length;
}

public static double arearec(double a, double b) {
    return a * b;
}
}