import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 목표 문자열을 배열에 담기
        char[] target = new char[n];
        for(int i=0; i<n; i++){
            target[i] = st.nextToken().charAt(0); // 'a' 또는 'b'
        }
        
        // 전부 동일 문자로 구성되어 있으면 색칠 1번이면 충분
        boolean allA=true, allB=true;
        for(char c: target){
            if(c=='b') allA=false;
            if(c=='a') allB=false;
        }
        if(allA || allB){
            System.out.println(1);
            return;
        }
        
        // 연속된 a 구간 개수, 연속된 b 구간 개수 세기
        int countA = 0; // 연속 'a' 구간 개수
        int countB = 0; // 연속 'b' 구간 개수
        // 첫 문자가 무엇인지에 따라 시작
        char prev = target[0];
        if(prev == 'a') countA++;
        else            countB++;
        
        for(int i=1; i<n; i++){
            if(target[i] != prev){
                if(target[i]=='a') countA++;
                else               countB++;
            }
            prev = target[i];
        }
        
        // (Case A) 전체를 'a'로 칠하고, b 구간만 추가 칠
        int ansA = 1 + countB; 
        // (Case B) 전체를 'b'로 칠하고, a 구간만 추가 칠
        int ansB = 1 + countA;
        
        int ans = Math.min(ansA, ansB);
        System.out.println(ans);
    }
}
