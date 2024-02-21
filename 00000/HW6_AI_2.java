import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class HW6_AI_2 {
    static int inputSize = 784;
    static int hiddenNodes = 200; // 50~200개
    static double learningRate = 0.001; // 0.1~0.5% (0.001 ~ 0.005)
    static int trainingDataNumber = 49000;
    static int testDataNumber = 21000;
    static int epochs = 100; // 100 이상
    static double[][] hiddenWeight = new double[inputSize][hiddenNodes];
    static double[] hiddenThreshold = new double[inputSize];
    static double[][] outputWeight = new double[hiddenNodes][inputSize];
    static double[] outputThreshold = new double[hiddenNodes];


    public static void main(String[] args) throws IOException {
        initialize(hiddenThreshold, hiddenWeight);
        initialize(outputThreshold, outputWeight);
        for (int epoch = 0; epoch < epochs; epoch++) {
            BufferedReader reader = new BufferedReader(new FileReader("HW6_MNIST.txt"));
            String line;
            double totalLoss = 0.0;
            while ((line = reader.readLine()) != null) {
                double[] input = new double[inputSize];
                int matrixLen = (int) Math.sqrt(inputSize);
                for (int i = 0; i < matrixLen; i++) {
                    line = reader.readLine();
                    int[] fileInput = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                    for (int j = 0; j < matrixLen; j++) {
                        input[i*matrixLen + j] = (double) fileInput[j] / 255;
                    }
                }
                double[] hiddenOutput = new double[inputSize];
                double[] finalOutput = new double[inputSize];

                // Forward pass
                activation(input, hiddenWeight, hiddenThreshold, hiddenOutput);
                activation(hiddenOutput, outputWeight, outputThreshold, finalOutput);

                double[] outputError = new double[inputSize];
                for (int i = 0; i < inputSize; i++) {
                    outputError[i] = input[i] - finalOutput[i];
                    totalLoss += outputError[i] * outputError[i]; // 제곱 오차를 더함
                }
                // Backpropagation
                backpropagation(input, hiddenOutput, finalOutput);



//                double[] output = new double[inputSize];
//                activation(input, hiddenWeight, hiddenThreshold, output);
//                activation(input, outputWeight, outputThreshold, output);
                // training weight value
            }
            double averageLoss = totalLoss / 70000;
            System.out.println("Epoch " + (epoch + 1) + ", Average Loss: " + averageLoss);

            reader.close();
        }
    }

    public static void backpropagation(double[] input, double[] hiddenOutput, double[] finalOutput) {
        // Backpropagation for output layer
        double[] outputError = new double[inputSize];
        for (int i = 0; i < inputSize; i++) {
            outputError[i] = input[i] - finalOutput[i];
        }

        // Backpropagation for hidden layer
        double[] hiddenError = new double[hiddenNodes];
        for (int i = 0; i < hiddenNodes; i++) {
            double sum = 0.0;
            for (int j = 0; j < inputSize; j++) {
                sum += outputError[j] * outputWeight[i][j];
            }
            hiddenError[i] = hiddenOutput[i] * (1 - hiddenOutput[i]) * sum;
        }

        // Call the weight update function
        updateWeights(input, hiddenOutput, finalOutput, outputError, hiddenError);
    }

    public static void updateWeights(double[] input, double[] hiddenOutput, double[] finalOutput, double[] outputError, double[] hiddenError) {
        // Update weights for output layer
        for (int i = 0; i < hiddenNodes; i++) {
            for (int j = 0; j < 28; j++) {
                outputWeight[i][j] += learningRate * outputError[j] * hiddenOutput[i];
            }
            outputThreshold[i] -= learningRate * outputError[i];
        }

        // Update weights for hidden layer
        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < hiddenNodes; j++) {
                hiddenWeight[i][j] += learningRate * hiddenError[j] * input[i];
            }
            hiddenThreshold[i] -= learningRate * hiddenError[i];
        }
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
                resultVal += input[j] * weight[i][j];
            }
            result[i] = 1 / (1 + Math.exp(-resultVal));
        }
    }
}
