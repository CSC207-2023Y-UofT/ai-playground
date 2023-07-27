import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class chooseFeature {

    public static ArrayList<ArrayList<ArrayList<Double>>> generateTrainingData(){
        ArrayList<Integer> dfeatures = getFeature();
        ArrayList<ArrayList<ArrayList<Double>>> training_data = accumData(dfeatures);
        return training_data;
    }
    public static ArrayList<Integer> getFeature(){
        // responsible for finding which features and data set has been activated by the user
        // First element in the array list is which dataset will be used, the rest are features to be included
        return new ArrayList<>();
    }

    public static ArrayList<ArrayList<ArrayList<Double>>> accumData(ArrayList<Integer> data_feats){
        ArrayList<ArrayList<ArrayList<Double>>> base_data = getData(data_feats.get(0));
        ArrayList<Integer> features = new ArrayList<>(data_feats.subList(1, data_feats.size()));
        return applyFeat(features, base_data);
    }
    public static ArrayList<ArrayList<ArrayList<Double>>> getData(Integer set) {
        ArrayList<ArrayList<ArrayList<Double>>> datas = new ArrayList<ArrayList<ArrayList<Double>>>();
        if (set == 1) {
            datas = generateDatasets.generateCircular();}
        if (set == 2) {
            datas = generateDatasets.generateClusters();
        }
        if (set == 3) {
            datas = generateDatasets.generateQuadrantDatasets();
        }
        if (set == 4) {
            datas = generateDatasets.generateSpiralDatasets();
        }
        return datas;
    }
    public static ArrayList<ArrayList<ArrayList<Double>>> applyFeat(ArrayList<Integer> feat,
                                                                    ArrayList<ArrayList<ArrayList<Double>>> base){
        Map<Integer, Function<ArrayList<ArrayList<ArrayList<Double>>>,
                ArrayList<ArrayList<ArrayList<Double>>>>> funMap = new HashMap<>();
        funMap.put(1, chooseFeature::squareXValues);
        funMap.put(2, chooseFeature::squareYValues);
        funMap.put(3, chooseFeature::XtimesY);
        funMap.put(4, chooseFeature::SinXValues);
        funMap.put(5, chooseFeature::SinYVlaues);
        ArrayList<ArrayList<ArrayList<Double>>> newDataset = new ArrayList<>(base);
        for(int i : feat){
            newDataset.addAll(funMap.get(i).apply(base));
        }
        return newDataset;
    }


    public static ArrayList<ArrayList<ArrayList<Double>>>
    squareXValues(ArrayList<ArrayList<ArrayList<Double>>> dataset) {
        ArrayList<ArrayList<ArrayList<Double>>> squaredDataset = new ArrayList<>();
        for (ArrayList<ArrayList<Double>> data : dataset) {
            ArrayList<ArrayList<Double>> squaredData = new ArrayList<>();
            ArrayList<Double> xValues = data.get(0);
            ArrayList<Double> yValues = data.get(1);
            ArrayList<Double> squaredXValues = new ArrayList<>();
            for (Double x : xValues) {
                squaredXValues.add(x * x);
            }
            squaredData.add(squaredXValues);
            squaredData.add(new ArrayList<>(yValues));
            squaredDataset.add(squaredData);
        }
        return squaredDataset;
    }






}


