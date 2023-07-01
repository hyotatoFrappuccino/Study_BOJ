import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P9063 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>(); // 입력받은 좌표들의 목록
        for (int i = 0; i < N; i++) {
            int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(new Point(xy[0], xy[1])); // 좌표 객체를 만들어 목록에 추가
        }
        if (list.size() <= 1) // 지점이 1개라면 넓이는 0, 2개 이상이어야 직사각형을 만들 수 있음
            System.out.println(0);
        else {
//            주의! min, max값을 0으로 설정해주면 좌표가 음수일 경우 계산값이 올바르지 않으므로 주의해야 함.
            int east = list.get(0).getX();
            int west = list.get(0).getX();
            int south = list.get(0).getY();
            int north = list.get(0).getY();
            for (Point p : list){
                int x = p.getX();
                int y = p.getY();
//                동 : x좌표가 제일 큰 것
//                서 : x좌표가 제일 작은 것
//                남 : y좌표가 제일 작은 것
//                북 : y좌표가 제일 큰 것
                if (x > east) east = x;
                if (x < west) west = x;
                if (y < south) south = y;
                if (y > north) north = y;
            }
            System.out.println((east - west) * (north - south));
        }
    }
}

class Point {
    private final int x;
    private final int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}