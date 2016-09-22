package ru.nessi6895;

import java.util.ArrayList;
import java.util.List;

import static ru.nessi6895.ChartDrawer.*;
import static ru.nessi6895.CalculatorUtils.*;

public class Calculator1 {
    public void calc(int a, double d, int N, double U0, double U1) {
        double h = 1./ (N - 1);
        double[] coordinates = getCoordinates(N, h);
        double[] values = new double[N];
        double[] A = new double[N];
        double[] B = new double[N];

        values[0] = U0;
        values[N - 1] = U1;

        double firstCoeff = -(a*h + 2*d);
        double secondCoeff = 4*d;
        double thirdCoeff = a*h - 2*d;

        A[1] = -firstCoeff*U0/secondCoeff;
        B[1] = - thirdCoeff/secondCoeff;

        for (int i = 2; i < N - 1; i++) {
            A[i] = -firstCoeff*A[i-1]/(secondCoeff + firstCoeff*B[i-1]);
            B[i] = -thirdCoeff/(secondCoeff + firstCoeff*B[i-1]);
        }
        for (int i = N - 2; i >= 0; i--) {
            values[i] = A[i] + B[i] * values[i+1];
        }

        String name = N + " points, D = " + d + " a = " + a;

        draw(name, coordinates, values);
    }
}