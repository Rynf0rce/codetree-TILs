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
        if(this.left == l.left){
            return this.right - l.right;
        }
        return this.left - l.left;
    }
}

public class Main {
    public static int n = 0;
    public static int ans = 0;
    public static ArrayList<line> arr = new ArrayList<>();
    public static ArrayList<line> selected = new ArrayList<>();

    public static boolean isPossible(){
        ArrayList<line> temp = new ArrayList<>(selected);

        if(temp.isEmpty()){
            return true;
        }
 
        Collections.sort(temp);

        line l = temp.get(0);
        for(int i = 1 ; i < temp.size() ; i++){
            if(l.left <= temp.get(i).left && temp.get(i).left <= l.right){
                return false;
            }
            l = temp.get(i);
        }
        return true;
    }
    
    public static void simulation(int idx){
        if(idx >= n){
            if(isPossible()){
                ans = Math.max(ans, selected.size());
            }
            return;
        }

        for(int i = 0 ; i <= 1 ; i++){
            if(i == 0){
                simulation(idx + 1);
            }
            else{
                selected.add(arr.get(idx));
                simulation(idx + 1);
                selected.remove(selected.size() - 1);
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            arr.add(new line(left, right));
        }

        simulation(0);

        System.out.print(ans);
    }
}