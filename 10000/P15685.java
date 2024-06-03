import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15685 {
    static int N;
    static List<DragonCurve> list;
    static int result;
    static int[][] directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};


    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int[] input = Arrays.stream(lines[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            DragonCurve dragonCurve = new DragonCurve(new Point(input[1], input[0], input[2]), input[3]);
            list.add(dragonCurve);
        }
        result = 0;
    }

    static String process() {
        for (DragonCurve dragonCurve : list) {
            for (int gen = 1; gen <= dragonCurve.getGeneration(); gen++) {
                List<Point> curves = dragonCurve.getCurves();
                int x = dragonCurve.getEndX();
                int y = dragonCurve.getEndY();
                for (int idx = curves.size() - 1; idx >= 0; idx--) {
                    Point p = curves.get(idx);
                    int direction = getRotateDirection(p.getDirection());
                    Point newP = new Point(x, y, direction);
                    dragonCurve.addCurve(newP);
                    int[] xy = getNextPos(x, y, direction);
                    x = xy[0];
                    y = xy[1];

                }
                dragonCurve.setEndX(x);
                dragonCurve.setEndY(y);
            }
            Point lastP = new Point(dragonCurve.getEndX(), dragonCurve.getEndY(), 0);
            dragonCurve.addCurve(lastP);
        }
        boolean[][] matrix = new boolean[101][101];

        for (DragonCurve dragonCurve : list) {
            for (Point p : dragonCurve.getCurves()) {
                int x = p.getX();
                int y = p.getY();
                matrix[x][y] = true;
            }
        }

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                if (matrix[i][j] && matrix[i][j + 1] && matrix[i + 1][j] && matrix[i + 1][j + 1]) {
                    result++;
                }
            }
        }

        return String.valueOf(result);
    }

    static class DragonCurve {
        private final List<Point> curves;
        private int endX;
        private int endY;
        private final int generation;

        public DragonCurve(Point initPoint, int generation) {
            curves = new ArrayList<>();
            this.addCurve(initPoint);
            this.generation = generation;
            int[] nextPos = getNextPos(initPoint.getX(), initPoint.getY(), initPoint.getDirection());
            endX = nextPos[0];
            endY = nextPos[1];
        }

        public void addCurve(Point curve) {
            curves.add(curve);
        }

        public List<Point> getCurves() {
            return curves;
        }

        public int getEndX() {
            return endX;
        }

        public int getEndY() {
            return endY;
        }

        public int getGeneration() {
            return generation;
        }

        public void setEndX(int endX) {
            this.endX = endX;
        }

        public void setEndY(int endY) {
            this.endY = endY;
        }
    }

    static public int[] getNextPos(int x, int y, int direction) {
        return new int[]{x + directions[direction][0], y + directions[direction][1]};
    }

    static public int getRotateDirection(int direction) {
        return (direction + 1) % 4;
    }

    static class Point {
        private final int x;
        private final int y;
        private final int direction;

        public Point(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDirection() {
            return direction;
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