import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Character> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr.add(st.nextToken().charAt(0));
        }

        char target = 'A';
        int cnt = 0;
        while(!arr.isEmpty()){
            for(int i = 0 ; i < arr.size() ; i++){
                if(arr.get(i) == target){
                    cnt += i;
                    target++;
                    arr.remove(i);
                }
            }
        }
        System.out.print(cnt);
    }
}