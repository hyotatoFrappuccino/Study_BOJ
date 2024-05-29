import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14891 {
    static int T = 4;
    static int K;
    static Gear[] gears;
    static List<int[]> rotateList;
    static Map<Gear, Integer> futureRotate;
    static int result;

    static void input(String[] lines) {
        gears = new Gear[T];
        for (int i = 0; i < T; i++) {
            int[] input = strToIntArray(lines[i]);
            gears[i] = new Gear(input);
        }
        for (int i = 1; i < T; i++) {
            gears[i].setLeftGear(gears[i - 1]);
        }
        for (int i = 0; i < T - 1; i++) {
            gears[i].setRightGear(gears[i + 1]);
        }
        K = Integer.parseInt(lines[4]);
        rotateList = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(lines[5 + i]);
            int num = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            rotateList.add(new int[]{num, direction});
        }
        result = 0;
        futureRotate = new HashMap<>();
    }

    static String process() {
        // K번 회전
        for (int[] rotate : rotateList) {
            int num = rotate[0] - 1;
            int direction = rotate[1];
            futureRotate.clear();
            gears[num].rotate(direction, "left", true);
            gears[num].rotate(direction, "right", true);
            gears[num].rotateThis(direction);
            for (Gear gear : futureRotate.keySet()) {
                gear.rotateThis(futureRotate.get(gear));
            }
        }

        if (gears[0].getPole("top") == 1) {
            result += 1;
        }
        if (gears[1].getPole("top") == 1) {
            result += 2;
        }
        if (gears[2].getPole("top") == 1) {
            result += 4;
        }
        if (gears[3].getPole("top") == 1) {
            result += 8;
        }

        return String.valueOf(result);
    }

    private static int[] strToIntArray(String line) {
        return line.chars()
                .limit(8)
                .map(c -> c - '0')
                .toArray();
    }

    static class Gear {
        private final Deque<Integer> q = new LinkedList<>();
        private Gear leftGear = null;
        private Gear rightGear = null;


        public Gear(int[] list) {
            Arrays.stream(list).forEach(q::add);
        }

        /**
         *
         * @param directionRotation 회전방향 1: 시계방향, -1: 반시계방향
         * @param direction 맞물리는 방향 left: 좌측, right: 우측
         */
        public void rotate(int directionRotation, String direction, boolean firstGear) {
            // 좌, 우로 퍼짐
            if (direction.equals("left") && leftGear != null && leftGear.getPole("right") != this.getPole("left")) {
                leftGear.rotate(directionRotation == 1 ? -1 : 1, direction, false);
            } else if (direction.equals("right") && rightGear != null && rightGear.getPole("left") != this.getPole("right")) {
                rightGear.rotate(directionRotation == 1 ? -1 : 1, direction, false);
            }
            if (!firstGear) {
                futureRotate.put(this, directionRotation);
            }
        }

        public void rotateThis(int directionRotation) {
            // 본인 회전
            if (directionRotation == 1) {
                q.addFirst(q.pollLast());
            } else if (directionRotation == -1) {
                q.addLast(q.pollFirst());
            }
        }

        public int getPole(String location) {
            int loc = 0;
            int idx = 0;
            if (location.equals("left")) {
                loc = 6;
            } else if (location.equals("right")) {
                loc = 2;
            }

            for (int item : q) {
                if (idx++ == loc)
                    return item;
            }
            return -1;
        }


        public void setLeftGear(Gear leftGear) {
            this.leftGear = leftGear;
        }

        public void setRightGear(Gear rightGear) {
            this.rightGear = rightGear;
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