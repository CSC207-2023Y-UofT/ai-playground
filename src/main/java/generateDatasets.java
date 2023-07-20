import java.lang.Math;
import java.util.ArrayList;


public class generateDatasets {

    public static void main(String[] args) {

    }



    public static ArrayList<ArrayList<Double>> generateCircular() {
        ArrayList<ArrayList<Double>> dataset = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> x = new ArrayList<Double>();
        ArrayList<Double> y = new ArrayList<Double>();
        int radius = 7;
        for (int i = 0; i < 1000; i++) {
            double deviation = (Math.random() * 4) - 2;
            double angle = Math.random() * 2 * Math.PI;
            double xp = Math.cos(angle) * (radius + deviation);
            double yp = Math.sin(angle) * (radius + deviation);
            x.add(xp);
            y.add(yp);
        }
        dataset.add(x);
        dataset.add(y);
        return dataset;
    }
}