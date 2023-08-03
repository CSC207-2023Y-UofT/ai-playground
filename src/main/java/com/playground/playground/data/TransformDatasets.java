package com.playground.playground.data;

import java.lang.Math;
import java.util.ArrayList;

public class TransformDatasets{
    
    public static ArrayList<List<Object>> transform(ArrayList<ArrayList<ArrayList<Double>>> data){
        ArrayList<List<Object>> dataset = new ArrayList<List<Object>>();
        int number0 = data.get(0).get(0).length;
        int number1 = data.get(1).get(0).length;

        for (int i = 0; i < number0; i++) {
            int weight = 0;
            List<Object> point = new List<Object>();
            ArrayList<Double> coord = new ArrayList<Double>();
            Double xp = data.get(0).get(0).get(i);
            Double yp = data.get(0).get(1).get(i);
            coord.add(xp);
            coord.add(yp);
            point.add(coord);
            point.add(weight);
            dataset.add(point);
        }

        for (int i = 0; i < number1; i++) {
            int weight = 1;
            List<Object> point = new List<Object>();
            ArrayList<Double> coord = new ArrayList<Double>();
            Double xp = data.get(1).get(0).get(i);
            Double yp = data.get(1).get(1).get(i);
            coord.add(xp);
            coord.add(yp);
            point.add(coord);
            point.add(weight);
            dataset.add(point);
        }

        return dataset;

    }
}