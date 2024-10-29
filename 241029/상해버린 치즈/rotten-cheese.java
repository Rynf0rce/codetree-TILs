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
    public static boolean[] cheezeArr = new boolean[MAX_CHEEZE + 1];
    public static int rottencheeze = -1;
    public static ArrayList<info> arr = new ArrayList<>();
    public static HashSet<Integer> hs = new HashSet<>();
    
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

            hs.add(p);

            for(int j = 0 ; j < numOfRecord ; j++){
                if(arr.get(j).t > t){
                    break;
                }

                if(arr.get(j).p == p){
                    cheezeArr[arr.get(j).m] = true;
                }
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= numOfCheeze ; i++){
            if(!cheezeArr[i]){
                continue;
            }

            boolean[] infectedArr = new boolean[MAX_PEOPLE + 1];
            boolean[] visited = new boolean[MAX_PEOPLE + 1];

            int visit = 0;
            for(int j = 0 ; j < numOfRecord ; j++){
                if(arr.get(j).m == i){
                    infectedArr[arr.get(j).p] = true;
                }

                if(!visited[arr.get(j).p] && hs.contains(arr.get(j).p)){
                    visit++;
                    visited[arr.get(j).p] = true;
                }
            }

            if(visit != hs.size()){
                continue;
            }

            int cnt = 0;
            for(int j = 1 ; j <= numOfCheeze ; j++){
                if(infectedArr[j]){
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}