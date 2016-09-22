package ru.nessi6895;

public class CalculatorUtils {
    public static double[] getCoordinates(int N, double h){
        double[] coordinates = new double[N];
        for(int i = 0; i < N; i++) coordinates[i] = i * h;
        return coordinates;
    }
}
