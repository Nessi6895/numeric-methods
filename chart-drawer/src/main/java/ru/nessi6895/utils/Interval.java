package ru.nessi6895.utils;

public class Interval {
    private final double left;
    private final double right;

    public Interval(double left, double right) {
        this.left = left;
        this.right = right;
    }

    public double getLeft() {
        return left;
    }

    public double getRight() {
        return right;
    }

    public double getLength(){
        return right - left;
    }
}