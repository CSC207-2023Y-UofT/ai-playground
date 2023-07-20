import java.lang.Math;
import java.util.ArrayList;


public class generateDatasets {

    public static void main(String[] args) {

    }


    public static ArrayList<ArrayList<ArrayList<Double>>> generateCircular() {
        ArrayList<ArrayList<ArrayList<Double>>> dataset = new ArrayList<ArrayList<ArrayList<Double>>>();
        ArrayList<ArrayList<Double>> dataset0 = new ArrayList<ArrayList<Double>>();
        ArrayList<ArrayList<Double>> dataset1 = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> x0 = new ArrayList<Double>();
        ArrayList<Double> y0 = new ArrayList<Double>();
        ArrayList<Double> x1 = new ArrayList<Double>();
        ArrayList<Double> y1 = new ArrayList<Double>();
        int radius0 = 7;
        for (int i = 0; i < 1000; i++) {
            double deviation0 = (Math.random() * 4) - 2;
            double angle = Math.random() * 2 * Math.PI;
            double xp = Math.cos(angle) * (radius0 + deviation0);
            double yp = Math.sin(angle) * (radius0 + deviation0);
            x0.add(xp);
            y0.add(yp);
        }
        dataset0.add(x0);
        dataset0.add(y0);
        dataset.add(dataset0);
        int radius1 = 4;
        for (int i = 0; i < 1000; i++) {
            double deviation1 = Math.random();
            double angle = Math.random() * 2 * Math.PI;
            double xp = Math.cos(angle) * radius1 * deviation1;
            double yp = Math.sin(angle) * radius1 * deviation1;
            x1.add(xp);
            y1.add(yp);
        }
        dataset1.add(x1);
        dataset1.add(y1);
        dataset.add(dataset1);
        return dataset;
    }

}