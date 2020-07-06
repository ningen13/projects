package ru.qa.sandbox;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        return Math.sqrt((this.x - point.x) * (this.x - point.x) + (this.y - this.y) * (this.y - this.y));
    }
}
