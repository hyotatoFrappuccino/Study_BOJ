import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P14226 {
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int S = Integer.parseInt(br.readLine());
        visited = new boolean[1100][1100];

        // process
        bw.append(String.valueOf(bfs(S)));

        // output
        bw.flush();
    }

    private static int bfs(int S) {
        Deque<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0, 0});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int now = poll[0];
            int time = poll[1];
            int clipLen = poll[2];

            if (now == S) return time;

            if (now < 0 || now > S) continue;

//          1.  클립보드에서 불러와 now + clipboardLen (클립보드가 존재해야 함)
            if (clipLen > 0 && now + clipLen <= S && !visited[clipLen][now + clipLen]) {
                q.offer(new int[]{now + clipLen, time + 1, clipLen});
                visited[clipLen][now + clipLen] = true;
            }

//          2. now 복사 > 클립보드에 저장
            if (!visited[now][now]) {
                q.offer(new int[]{now, time + 1, now});
            }

//          3. now에서 1개 삭제
            if (now > 0 && !visited[clipLen][now - 1]) {
                q.offer(new int[]{now - 1, time + 1, clipLen});
                visited[clipLen][now - 1] = true;
            }
        }
        return 0;
    }
}