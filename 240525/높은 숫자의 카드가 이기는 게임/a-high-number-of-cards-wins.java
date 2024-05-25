import java.util.*;
import java.io.*;
public class Main {
    public static TreeSet<Integer> ts = new TreeSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= 2 * n ; i++){
            ts.add(i);
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int removedNum = Integer.parseInt(br.readLine());
            ts.remove(removedNum);
            if(ts.higher(removedNum) == null){
                ts.remove(ts.first());
            }
            else{
                ts.remove(ts.higher(removedNum));
                ans++;
            }
        }
        System.out.print(ans);
    }
}