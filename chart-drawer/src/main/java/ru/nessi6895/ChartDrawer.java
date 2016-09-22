package ru.nessi6895;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import ru.nessi6895.utils.Interval;

import javax.swing.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChartDrawer {
    public static void draw(String name, double[] coordinates, double[] values){

        XYSeries series = new XYSeries(name);

        for(int i = 0; i < coordinates.length; i++){
            series.add(coordinates[i], values[i]);
        }

        XYDataset dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(name, "x", "y", dataset,
                PlotOrientation.VERTICAL,
                true, true, true);
        JFrame frame = new JFrame("First example");
        frame.getContentPane().add(new ChartPanel(chart));
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void draw(String name, List<Double> coordinates, List<Double> values){
        double[] coordinatesArray = new double[coordinates.size()];
        double[] valuesArray = new double[values.size()];
        for(int i = 0; i < coordinates.size(); i++){
            coordinatesArray[i] = coordinates.get(i);
            valuesArray[i] = values.get(i);
        }
        draw(name, coordinatesArray, valuesArray);
    }

    public static void drawFunc(Interval interval, Function<Double, Double> func, int points){
        double[] result = new double[points];
        double[] coordinates = new double[points];
        for(int i = 0; i < points; i ++){
            coordinates[i] = interval.getLeft() + i * interval.getLength()/points;
            result[i] = func.apply(coordinates[i]);
        }
        draw("SomeFunc", coordinates, result);
    }
}