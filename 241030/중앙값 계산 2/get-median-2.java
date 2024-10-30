import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            arr.add(Integer.parseInt(st.nextToken()));

            if(i % 2 == 1){
                Collections.sort(arr);
                System.out.print(arr.get(arr.size()/2) + " ");
            }
        }
    }
}