package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainDefault {
	private static String[] readLines() throws IOException {
    	//System.in을 통해 데이터를 입력받고 String[]으로 전달하는 메서드
        int LEN = 2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = new String[LEN];
        for (int i = 0; i < LEN; i++) {
            lines[i] = br.readLine();
        }

        br.close();
        return lines;
    }
    
    static void input(String[] lines){
    	//입력받은 데이터들로 문제 풀 준비를 하는 메서드

    }
    
    static String process(){
    	//문제 풀이 과정이 담긴 메서드
        return "Test";
    }
    
	public static void main(String[] args) throws IOException {
    	input(readLines());
        System.out.println(process());
    }
}