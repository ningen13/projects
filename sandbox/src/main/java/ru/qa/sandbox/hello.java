package ru.qa.sandbox;

import java.awt.*;

public class hello {

public static void main(String[] args) {

    hello("wut");
    hello("there");
    hello("Aleksey");

    Point p1 = new Point(3, 6);
    Point p2 = new Point(4, 5);
    System.out.println("Расстояние между двумя точками равно " + p1.distance(p2));


   Square s = new Square(3);
   System.out.println("Площадь квардрата со стороной " + s.l + " равна " + s.areasq());

   Rectangle r = new Rectangle(4, 5);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.arearec());

}

public static void hello (String someone) {

    System.out.println("Hello, " + someone + "!");
}

public static double arearec(Rectangle r) {

    return r.a * r.b;
}
}