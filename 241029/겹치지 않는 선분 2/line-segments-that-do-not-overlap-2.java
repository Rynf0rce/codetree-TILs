import java.util.*;
import java.io.*;

class line implements Comparable<line>{
    int left, right;
    public line(int left, int right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(line l){
        return this.left - l.left;
    }
}

public class Main {
    public static final int MAX_LENGTH = 100;
    public static ArrayList<line> arr = new ArrayList<>();
    public static boolean[] solo = new boolean[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            arr.add(new line(left, right));
        }

        Collections.sort(arr);

        for(int i = 0 ; i < arr.size() ; i++){
            for(int j = i + 1 ; j < arr.size(); j++){
                // System.out.println(arr.get(i).left + " " + arr.get(i).right + " " + arr.get(j).right);
                if(arr.get(j).right < arr.get(i).right){
                    solo[i] = true;
                    solo[j] = true;
                    break;
                }
            }
        }

        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            if(!solo[i]){
                ans++;
            }
        }
        System.out.print(ans);
    }
}