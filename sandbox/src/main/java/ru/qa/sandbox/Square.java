package ru.qa.sandbox;

public class Square {
    public double l;

    public Square(double len) {
        this.l = len;
    }

    public double areasq() {
        return this.l * this.l;
    }
}
