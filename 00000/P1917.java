import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class P1917 {
    static int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    static int[] dice;
    static int row, col;
    static int[][] diceInput;

    static StringBuilder output;

    static void input(String[] lines) {
        diceInput = new int[18][6];
        for (int i = 0; i < 18; i++) {
            diceInput[i] = Arrays.stream(lines[i].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i = 0; i < 3; i++) {
            int[][] arr = new int[6][6];
            boolean[][] visited = new boolean[6][6];
            dice = new int[7];
            System.arraycopy(diceInput, i * 6, arr, 0, 6);
            startPoint(arr);    //2.
            cubeMake(arr, visited, row, col);    //3.
            if (cubeCheck())        //4.
                output.append("yes\n");
            else
                output.append("no\n");
        }

        return output.toString();
    }

    static void cubeMake(int[][] arr, boolean[][] visited, int row, int col) {
        int[] temp = new int[7];
        dice[1] = 1;        //아랫면 확인
        visited[row][col] = true;    //방문 확인
        for (int i = 0; i < 4; i++) {
            int tempRow = row + directions[i][0];
            int tempCol = col + directions[i][1];
            if (tempRow >= 0 && tempCol >= 0 && tempRow < 6 && tempCol < 6 && !visited[tempRow][tempCol]) {
                if (arr[tempRow][tempCol] == 1) {
                    cubeChange(i, temp);    //정육면체 회전
                    cubeMake(arr, visited, tempRow, tempCol);    //종이 접기
                    cubeReverse(i, temp);    //정육면체 되돌리기
                }
            }
        }

    }
    static void cubeReverse(int direction, int[] temp) {
        cubeChange(3 - direction, temp);
    }

    static void cubeChange(int direction, int[] temp) {
        if (direction == 0)        //남쪽
            south(temp);
        else if (direction == 1)    //동쪽
            east(temp);
        else if (direction == 2)    //서쪽
            west(temp);
        else        //북쪽
            north(temp);

        tempToDice(temp);
    }
    static void tempToDice(int[] temp) {
        System.arraycopy(temp, 1, dice, 1, 6);
    }
    static void startPoint(int[][] arr) {
        for (int j = 0; j < 6; j++) {
            if (arr[0][j] == 1) {
                row = 0;
                col = j;
                return;
            }
        }
        for (int j = 0; j < 6; j++) {
            if (arr[1][j] == 1) {
                row = 1;
                col = j;
                return;
            }
        }
        for (int j = 0; j < 6; j++) {
            if (arr[2][j] == 1) {
                row = 2;
                col = j;
                return;
            }
        }
        for (int j = 0; j < 6; j++) {
            if (arr[3][j] == 1) {
                row = 3;
                col = j;
                return;
            }
        }
        for (int j = 0; j < 6; j++) {
            if (arr[4][j] == 1) {
                row = 4;
                col = j;
                return;
            }
        }
        for (int j = 0; j < 6; j++) {
            if (arr[5][j] == 1) {
                row = 5;
                col = j;
                return;
            }
        }
    }

    static boolean cubeCheck() {
        return IntStream.range(1, 7).noneMatch(i -> dice[i] == 0);
    }

    //주사위가 아랫면 기준 남쪽방향으로 굴러갈 때 정육면체 변화
    static void south(int[] temp) {
        temp[4] = dice[1];
        temp[1] = dice[2];
        temp[2] = dice[3];
        temp[3] = dice[4];
        temp[5] = dice[5];
        temp[6] = dice[6];
    }

    //주사위가 아랫면 기준 동쪽방향으로 굴러갈 때 정육면체 변화
    static void east(int[] temp) {
        temp[5] = dice[1];
        temp[2] = dice[2];
        temp[6] = dice[3];
        temp[4] = dice[4];
        temp[3] = dice[5];
        temp[1] = dice[6];
    }

    //주사위가 아랫면 기준 서쪽방향으로 굴러갈 때 정육면체 변화
    static void west(int[] temp) {
        temp[6] = dice[1];
        temp[2] = dice[2];
        temp[5] = dice[3];
        temp[4] = dice[4];
        temp[1] = dice[5];
        temp[3] = dice[6];
    }

    //주사위가 아랫면 기준 북쪽방향으로 굴러갈 때 정육면체 변화
    static void north(int[] temp) {
        temp[2] = dice[1];
        temp[3] = dice[2];
        temp[4] = dice[3];
        temp[1] = dice[4];
        temp[5] = dice[5];
        temp[6] = dice[6];
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