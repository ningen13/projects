package ru.qa.sandbox;

public class hello {

public static void main(String[] args) {

    hello("wut");
    hello("there");
    hello("Aleksey");

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