import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HW6_AI_2 {
    static int inputSize = 784;
    static int hiddenNodes = 100; // 50~200개
    static double learningRate = 0.001; // 0.1~0.5% (0.001 ~ 0.005)
    static int trainingDataNumber = 60000;
    static int testDataNumber = 10000;
    static int epochs = 100; // 100 이상
    static double[][] hiddenWeight = new double[inputSize][hiddenNodes];
    static double[] hiddenThreshold = new double[hiddenNodes];
    static double[] outputThreshold = new double[hiddenNodes];
    static double[][] outputWeights = new double[inputSize][hiddenNodes];


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("HW6_MNIST.txt"));
        initialize(hiddenThreshold, hiddenWeight);
        initialize(outputThreshold, outputWeights);
        String line;
        int epoch = 0;

        while ((line = reader.readLine()) != null && epoch < epochs) {

        }

//        String lines;
//        int epochs = 0;
//        while((lines = reader.readLine()) != null) {
//            double[] input = new double[inputSize];
//            double[] hiddenLayerValues = new double[hiddenNodes];
//            double[] output = new double[1];
//            double[] outputLayerValues = new double[1];
//            double[] errorGradient = new double[1];
//
////            // One-hot encoding for output
////            // 2 step : activation method call(hidden & output layer)
////            // 3 step : training weight value
////            // observation loss rate
////            if(all training data is calculated) {
////                // calculate loss rate
////                // epoch increase
////                if(filled in the number of training iterations) {
////                // start the test
////                // initialize fail count and use test data fail count
////                }
////            }
//        }
    }

    public static void initialize(double[] threshold, double[][] weight) {
        for (int i = 0; i < threshold.length; i++) {
            threshold[i] = (Math.random() * (4.8 / weight[i].length)) - (2.4 / weight[i].length);

            for (int j = 0; j < weight[i].length; j++) {
                weight[i][j] = (Math.random() * (4.8 / weight[i].length)) - (2.4 / weight[i].length);
            }
        }
    }

    public static void activation(double[] input, double[][] weight, double[] threshold, double[] result) {
        for (int i = 0; i < weight.length; i++) {
            double resultVal = -threshold[i];
            for (int j = 0; j < weight[i].length; j++) {
                resultVal += input[i] * weight[i][j];
            }
            result[i] = 1 / (1 + Math.exp(-resultVal));
        }
    }

    public static double calculateLoss(double[] predicted, double[] target) {
        double sum = 0.0;
        for (int i = 0; i < predicted.length; i++) {
            sum += Math.pow(target[i] - predicted[i], 2);
        }
        return sum / predicted.length;
    }
}
