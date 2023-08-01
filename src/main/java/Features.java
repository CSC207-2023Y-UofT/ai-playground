import java.util.ArrayList;

public class Features {
    private static void buildAxisArray(int axis, ArrayList<ArrayList<ArrayList<Double>>> squaredDataset,
                                       ArrayList<ArrayList<Double>> squaredData, ArrayList<Double> otherValues,
                                       ArrayList<Double> squaredValues) {
        if (axis == 0) {
            squaredData.add(squaredValues);
            squaredData.add(new ArrayList<>(otherValues));
        } else {
            squaredData.add(new ArrayList<>(otherValues));
            squaredData.add(squaredValues);
        }
        squaredDataset.add(squaredData);
    }

    public static ArrayList<ArrayList<ArrayList<Double>>>
    squareVal(ArrayList<ArrayList<ArrayList<Double>>> dataset, int axis) {
        ArrayList<ArrayList<ArrayList<Double>>> squaredDataset = new ArrayList<>();
        for (ArrayList<ArrayList<Double>> data : dataset) {
            ArrayList<ArrayList<Double>> squaredData = new ArrayList<>();
            ArrayList<Double> valuesToSquare = data.get(axis);
            ArrayList<Double> otherValues = data.get(1 - axis);
            ArrayList<Double> squaredValues = new ArrayList<>();
            for (Double value : valuesToSquare) {
                squaredValues.add(value * value);
            }
            buildAxisArray(axis, squaredDataset, squaredData, otherValues, squaredValues);
        }
        return squaredDataset;
        //0 REFERS TO X-AXIS 1 = Y-AXIS
    }
    public static ArrayList<ArrayList<ArrayList<Double>>>
    sinVal(ArrayList<ArrayList<ArrayList<Double>>> dataset, int axis) {
        ArrayList<ArrayList<ArrayList<Double>>> resultDataset = new ArrayList<>();
        for (ArrayList<ArrayList<Double>> data : dataset) {
            ArrayList<ArrayList<Double>> transformedData = new ArrayList<>();
            ArrayList<Double> valuesToTransform = data.get(axis);
            ArrayList<Double> otherValues = data.get(1 - axis);
            ArrayList<Double> transformedValues = new ArrayList<>();
            for (Double value : valuesToTransform) {
                transformedValues.add(Math.sin(value));
            }
            buildAxisArray(axis, resultDataset, transformedData, otherValues, transformedValues);
        }
        return resultDataset;
    }

    public static ArrayList<ArrayList<ArrayList<Double>>>
    multiplyVal(ArrayList<ArrayList<ArrayList<Double>>> dataset) {
        ArrayList<ArrayList<ArrayList<Double>>> resultDataset = new ArrayList<>();

        for (ArrayList<ArrayList<Double>> data : dataset) {
            ArrayList<Double> xValues = data.get(0);
            ArrayList<Double> yValues = data.get(1);

            ArrayList<ArrayList<Double>> multipliedData = new ArrayList<>();
            ArrayList<Double> multipliedValues = new ArrayList<>();

            for (int i = 0; i < xValues.size(); i++) {
                multipliedValues.add(xValues.get(i) * yValues.get(i));
            }

            multipliedData.add(multipliedValues);
            resultDataset.add(multipliedData);
        }

        return resultDataset;
    }
}
