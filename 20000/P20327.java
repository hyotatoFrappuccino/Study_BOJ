import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P20327 {
    static int N;
    static int R;
    static int[][] matrix;
    static int[] oper;
    static int[] step;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int len = (int) Math.pow(2, N);
        matrix = new int[len][len];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        oper = new int[R];
        step = new int[R];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(lines[len + i + 1]);
            oper[i] = Integer.parseInt(st.nextToken());
            step[i] = Integer.parseInt(st.nextToken());
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i = 0; i < R; i++) {
            switch (oper[i]) {
                case 1:
                    oper1(step[i]);
                    break;
                case 2:
                    oper2(step[i]);
                    break;
                case 3:
                    oper3(step[i]);
                    break;
                case 4:
                    oper4(step[i]);
                    break;
                case 5:
                    oper5(step[i]);
                    break;
                case 6:
                    oper6(step[i]);
                    break;
                case 7:
                    oper7(step[i]);
                    break;
                case 8:
                    oper8(step[i]);
                    break;
            }
        }
        printMatrix(matrix);


        return output.toString();
    }

    static void oper1(int l) {
        int len = (int) Math.pow(2, l);
        // i, j = 한 부분의 시작점
        for (int i = 0; i < matrix.length; i += len) {
            for (int j = 0; j < matrix[0].length; j += len) {
                // 이 부분에서 상하반전
                for (int k = 0; k < len / 2; k++) {
                    for (int m = 0; m < len; m++) {
                        swap(i + k, j + m, i + len - k - 1, j + m);
                    }
                }
            }
        }
    }

    static void oper2(int l) {
        int len = (int) Math.pow(2, l);
        // i, j = 한 부분의 시작점
        for (int i = 0; i < matrix.length; i += len) {
            for (int j = 0; j < matrix[0].length; j += len) {
                // 이 부분에서 좌우반전
                for (int k = 0; k < len; k++) {
                    for (int m = 0; m < len / 2; m++) {
                        swap(i + k, j + m, i + k, j + len - m - 1);
                    }
                }
            }
        }
    }

    static void oper3(int l) {
        int len = (int) Math.pow(2, l);
        int n = matrix.length;
        for (int i = 0; i < n; i += len) {
            for (int j = 0; j < n; j += len) {
                // 부분 배열을 오른쪽으로 90도 회전
                for (int x = 0; x < len / 2; x++) {
                    for (int y = x; y < len - x - 1; y++) {
                        // 4개의 위치를 회전
                        int temp = matrix[i + x][j + y];
                        matrix[i + x][j + y] = matrix[i + len - 1 - y][j + x];
                        matrix[i + len - 1 - y][j + x] = matrix[i + len - 1 - x][j + len - 1 - y];
                        matrix[i + len - 1 - x][j + len - 1 - y] = matrix[i + y][j + len - 1 - x];
                        matrix[i + y][j + len - 1 - x] = temp;
                    }
                }
            }
        }
    }

    // 각 부분 배열을 오른쪽으로 90도 회전
//    static void oper3(int l) {
//        int len = (int) Math.pow(2, l);
//        // i, j = 한 부분의 시작점
//        for (int i = 0; i < matrix.length; i += len) {
//            for (int j = 0; j < matrix[0].length; j += len) {
//                // 이 부분에서 오른쪽으로 90도 회전
//                for (int depth = 0; depth < l; depth++) {
//                    int listLen = len - 2 * depth;
//
//                    List<Integer> top = new ArrayList<>();
//                    for (int m = 0; m < listLen - 1; m++) {
//                        top.add(matrix[i + depth][j + depth + m]);
//                    }
//
//                    List<Integer> bottom = new ArrayList<>();
//                    for (int m = 1; m < listLen; m++) {
//                        bottom.add(matrix[i + len - depth - 1][j + depth + m]);
//                    }
//
//                    List<Integer> left = new ArrayList<>();
//                    for (int m = 1; m < listLen; m++) {
//                        left.add(matrix[i + depth + m][j + depth]);
//                    }
//
//                    List<Integer> right = new ArrayList<>();
//                    for (int m = 0; m < listLen - 1; m++) {
//                        right.add(matrix[i + depth + m][j + len - depth - 1]);
//                    }
//
//                    // top
//                    for (int m = 0; m < listLen - 1; m++) {
//                        matrix[i + depth][j + depth + m] = left.remove(0);
//                    }
//
//                    // left
//                    for (int m = 1; m < listLen; m++) {
//                        matrix[i + depth + m][j + depth] = bottom.remove(bottom.size() - 1);
//                    }
//
//                    // bottom
//                    for (int m = 1; m < listLen; m++) {
//                        matrix[i + len - depth - 1][j + depth + m] = right.remove(0);
//                    }
//
//                    // right
//                    for (int m = 0; m < listLen - 1; m++) {
//                        matrix[i + depth + m][j + len - depth - 1] = top.remove(top.size() - 1);
//                    }
//                }
//            }
//        }
//    }

    // 각 부분 배열을 왼쪽으로 90도 회전
    static void oper4(int l) {
        for (int i = 0; i < 3; i++) {
            oper3(l);
        }
//        int len = (int) Math.pow(2, l);
//        // i, j = 한 부분의 시작점
//        for (int i = 0; i < matrix.length; i += len) {
//            for (int j = 0; j < matrix[0].length; j += len) {
//                // 이 부분에서 오른쪽으로 90도 회전
//                for (int depth = 0; depth < l; depth++) {
//                    int listLen = len - 2 * depth;
//
//                    List<Integer> top = new ArrayList<>();
//                    for (int m = 0; m < listLen - 1; m++) {
//                        top.add(matrix[i + depth][j + depth + m]);
//                    }
//
//                    List<Integer> bottom = new ArrayList<>();
//                    for (int m = 1; m < listLen; m++) {
//                        bottom.add(matrix[i + len - depth - 1][j + depth + m]);
//                    }
//
//                    List<Integer> left = new ArrayList<>();
//                    for (int m = 1; m < listLen; m++) {
//                        left.add(matrix[i + depth + m][j + depth]);
//                    }
//
//                    List<Integer> right = new ArrayList<>();
//                    for (int m = 0; m < listLen - 1; m++) {
//                        right.add(matrix[i + depth + m][j + len - depth - 1]);
//                    }
//
//                    // top
//                    for (int m = 0; m < listLen - 1; m++) {
//                        matrix[i + depth][j + depth + m] = right.remove(0);
//                    }
//
//                    // left
//                    for (int m = 1; m < listLen; m++) {
//                        matrix[i + depth + m][j + depth] = top.remove(top.size() - 1);
//                    }
//
//                    // bottom
//                    for (int m = 1; m < listLen; m++) {
//                        matrix[i + len - depth - 1][j + depth + m] = left.remove(0);
//                    }
//
//                    // right
//                    for (int m = 0; m < listLen - 1; m++) {
//                        matrix[i + depth + m][j + len - depth - 1] = bottom.remove(bottom.size() - 1);
//                    }
//                }
//            }
//        }
    }
    static void oper5(int l) {
        int len = (int) Math.pow(2, l);
        // i, j = 한 부분의 시작점
        for (int i = 0; i < matrix.length / 2; i += len) {
            for (int j = 0; j < matrix[0].length; j += len) {
                swapMatrix(i, j, matrix.length - len - i, j, len);
            }
        }
    }
    static void oper6(int l) {
        int len = (int) Math.pow(2, l);
        // i, j = 한 부분의 시작점
        for (int i = 0; i < matrix.length; i += len) {
            for (int j = 0; j < matrix[0].length / 2; j += len) {
                swapMatrix(i, j, i, matrix.length - len - j, len);
            }
        }
    }

    static void oper7(int l) {
        int len = (int) Math.pow(2, l);
        for (int depth = 0; depth < matrix.length / 2 / len; depth++) {

            int i, j;
            List<int[][]> top = new ArrayList<>();
            i = len * depth;
            for (j = len * depth; j < matrix.length - len * (depth + 1); j += len) {
                int[][] temp = new int[len][len];
                for (int k = 0; k < len; k++) {
                    for (int m = 0; m < len; m++) {
                        temp[k][m] = matrix[i + k][j + m];
                    }
                }
                top.add(temp);
            }


            List<int[][]> bottom = new ArrayList<>();
            i = matrix.length - len * (depth + 1);
            for (j = len * (depth + 1); j < matrix.length - len * depth; j += len) {
                int[][] temp = new int[len][len];
                for (int k = 0; k < len; k++) {
                    for (int m = 0; m < len; m++) {
                        temp[k][m] = matrix[i + k][j + m];
                    }
                }
                bottom.add(temp);
            }

            List<int[][]> left = new ArrayList<>();
            j = len * depth;
            for (i = len * (depth + 1); i < matrix.length - len * depth; i += len) {
                int[][] temp = new int[len][len];
                for (int k = 0; k < len; k++) {
                    for (int m = 0; m < len; m++) {
                        temp[k][m] = matrix[i + k][j + m];
                    }
                }
                left.add(temp);
            }

            List<int[][]> right = new ArrayList<>();
            j = matrix.length - len * (depth + 1);
            for (i = len * depth; i < matrix.length - len * (depth + 1); i += len) {
                int[][] temp = new int[len][len];
                for (int k = 0; k < len; k++) {
                    for (int m = 0; m < len; m++) {
                        temp[k][m] = matrix[i + k][j + m];
                    }
                }
                right.add(temp);
            }

            // left -> top
            ListIterator<int[][]> leftIt = left.listIterator(left.size());
            i = len * depth;
            for (j = len * depth; j < matrix.length - len * (depth + 1); j += len) {
                int[][] temp = leftIt.previous();
                for (int k = 0; k < len; k++) {
                    for (int m = 0; m < len; m++) {
                        matrix[i + k][j + m] = temp[k][m];
                    }
                }
            }

            // right -> bottom
            ListIterator<int[][]> rightIt = right.listIterator(right.size());
            i = matrix.length - len * (depth + 1);
            for (j = len * (depth + 1); j < matrix.length - len * depth; j += len) {
                int[][] temp = rightIt.previous();
                for (int k = 0; k < len; k++) {
                    for (int m = 0; m < len; m++) {
                        matrix[i + k][j + m] = temp[k][m];
                    }
                }
            }

            // bottom -> left
            Iterator<int[][]> btIt = bottom.iterator();
            j = len * depth;
            for (i = len * (depth + 1); i < matrix.length - len * depth; i += len) {
                int[][] temp = btIt.next();
                for (int k = 0; k < len; k++) {
                    for (int m = 0; m < len; m++) {
                        matrix[i + k][j + m] = temp[k][m];
                    }
                }
            }

            // top -> right
            Iterator<int[][]> topIt = top.iterator();
            j = matrix.length - len * (depth + 1);
            for (i = len * depth; i < matrix.length - len * (depth + 1); i += len) {
                int[][] temp = topIt.next();
                for (int k = 0; k < len; k++) {
                    for (int m = 0; m < len; m++) {
                        matrix[i + k][j + m] = temp[k][m];
                    }
                }
            }
        }
    }

    static void oper8(int l) {
        for (int i = 0; i < 3; i++) {
            oper7(l);
        }
//        int len = (int) Math.pow(2, l);
//        for (int depth = 0; depth < matrix.length / 2 / len; depth++) {
//
//            int i, j;
//            List<int[][]> top = new ArrayList<>();
//            i = len * depth;
//            for (j = len * depth; j < matrix.length - len * (depth + 1); j += len) {
//                int[][] temp = new int[len][len];
//                for (int k = 0; k < len; k++) {
//                    for (int m = 0; m < len; m++) {
//                        temp[k][m] = matrix[i + k][j + m];
//                    }
//                }
//                top.add(temp);
//            }
//
//
//            List<int[][]> bottom = new ArrayList<>();
//            i = matrix.length - len * (depth + 1);
//            for (j = len * (depth + 1); j < matrix.length - len * depth; j += len) {
//                int[][] temp = new int[len][len];
//                for (int k = 0; k < len; k++) {
//                    for (int m = 0; m < len; m++) {
//                        temp[k][m] = matrix[i + k][j + m];
//                    }
//                }
//                bottom.add(temp);
//            }
//
//            List<int[][]> left = new ArrayList<>();
//            j = len * depth;
//            for (i = len * (depth + 1); i < matrix.length - len * depth; i += len) {
//                int[][] temp = new int[len][len];
//                for (int k = 0; k < len; k++) {
//                    for (int m = 0; m < len; m++) {
//                        temp[k][m] = matrix[i + k][j + m];
//                    }
//                }
//                left.add(temp);
//            }
//
//            List<int[][]> right = new ArrayList<>();
//            j = matrix.length - len * (depth + 1);
//            for (i = len * depth; i < matrix.length - len * (depth + 1); i += len) {
//                int[][] temp = new int[len][len];
//                for (int k = 0; k < len; k++) {
//                    for (int m = 0; m < len; m++) {
//                        temp[k][m] = matrix[i + k][j + m];
//                    }
//                }
//                right.add(temp);
//            }
//
//            // left -> bottom
//            ListIterator<int[][]> leftIt = left.listIterator(left.size());
//            i = matrix.length - len * (depth + 1);
//            for (j = len * (depth + 1); j < matrix.length - len * depth; j += len) {
//                int[][] temp = leftIt.previous();
//                for (int k = 0; k < len; k++) {
//                    for (int m = 0; m < len; m++) {
//                        matrix[i + k][j + m] = temp[k][m];
//                    }
//                }
//            }
//
//            // right -> top
//            ListIterator<int[][]> rightIt = right.listIterator(right.size());
//            i = len * depth;
//            for (j = len * depth; j < matrix.length - len * (depth + 1); j += len) {
//                int[][] temp = rightIt.previous();
//                for (int k = 0; k < len; k++) {
//                    for (int m = 0; m < len; m++) {
//                        matrix[i + k][j + m] = temp[k][m];
//                    }
//                }
//            }
//
//            // bottom -> right
//            Iterator<int[][]> btIt = bottom.iterator();
//            j = matrix.length - len * (depth + 1);
//            for (i = len * depth; i < matrix.length - len * (depth + 1); i += len) {
//                int[][] temp = btIt.next();
//                for (int k = 0; k < len; k++) {
//                    for (int m = 0; m < len; m++) {
//                        matrix[i + k][j + m] = temp[k][m];
//                    }
//                }
//            }
//
//            // top -> left
//            Iterator<int[][]> topIt = top.iterator();
//            j = len * depth;
//            for (i = len * (depth + 1); i < matrix.length - len * depth; i += len) {
//                int[][] temp = topIt.next();
//                for (int k = 0; k < len; k++) {
//                    for (int m = 0; m < len; m++) {
//                        matrix[i + k][j + m] = temp[k][m];
//                    }
//                }
//            }
//        }
    }

    static void swap(int i, int j, int ii, int jj) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[ii][jj];
        matrix[ii][jj] = temp;
    }

    static void swapMatrix(int i, int j, int ii, int jj, int len) {
        for (int k = 0; k < len; k++) {
            for (int l = 0; l < len; l++) {
                swap(i + k, j + l, ii + k, jj + l);
            }
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                output.append(ints[j]);
                if (j < matrix[0].length - 1) {
                    output.append(" ");
                }
            }
            output.append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input(readLines());
        System.out.println(process());
    }

    private static String[] readLines() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }
        br.close();

        String[] linesArray = new String[lines.size()];
        linesArray = lines.toArray(linesArray);
        return linesArray;
    }
}