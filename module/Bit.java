public class Bit {
    public static void main(String[] args) {
        int number = (1 << 4) - 1; // 변환하고자 하는 정수
        printBinary(number);
    }

    // 정수를 이진수로 변환하여 출력하는 함수
    public static void printBinary(int number) {
        if (number == 0) {
            System.out.println("0");
            return;
        }

        StringBuilder binary = new StringBuilder();
        while (number > 0) {
            int remainder = number % 2;
            binary.insert(0, remainder); // 나머지를 앞에 추가하여 이진수 형태로 만듦
            number = number / 2;
        }

        System.out.println(binary);
    }
}
