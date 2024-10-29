import java.util.*;
import java.io.*;

class info implements Comparable<info>{
    int p, m, t;
    public info(int p, int m, int t){
        this.p = p;
        this.m = m;
        this.t = t;
    }
    @Override
    public int compareTo(info i){
        return this.t - i.t;
    }
}

public class Main {
    public static final int MAX_PEOPLE = 50;
    public static final int MAX_CHEEZE = 50;
    public static boolean[] infectedArr = new boolean[MAX_PEOPLE + 1];
    public static boolean[] cheezeArr = new boolean[MAX_CHEEZE + 1];
    public static ArrayList<info> arr = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int subjet = Integer.parseInt(st.nextToken());
        int numOfCheeze = Integer.parseInt(st.nextToken());
        int numOfRecord = Integer.parseInt(st.nextToken());
        int numOfPatient = Integer.parseInt(st.nextToken());

        // n th - subject / n th - cheeze / time
        for(int i = 0 ; i < numOfRecord ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr.add(new info(p, m, t));
        }

        Collections.sort(arr);

        for(int i = 0 ; i < numOfPatient ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for(int j = 0 ; j < numOfRecord ; j++){
                if(arr.get(j).t > t){
                    break;
                }

                if(arr.get(j).p == p){
                    cheezeArr[arr.get(j).m] = true;
                }
            }
        }

        for(int i = 1 ; i <= numOfCheeze ; i++){
            if(!cheezeArr[i]){
                continue;
            }

            for(int j = 0 ; j < numOfRecord ; j++){
                if(arr.get(j).m == i){
                    infectedArr[j] = true;
                }
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= subjet ; i++){
            if(infectedArr[i]){
                ans++;
            }
        }
        System.out.print(ans);
    }
}