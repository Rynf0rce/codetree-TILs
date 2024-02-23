import java.util.*;
import java.io.*;

class fight implements Comparable<fight>{
    int a, b;
    public fight(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(fight f){
        if(this.a == f.a){
            return this.b - f.b;
        }
        else{
            return this.a - f.a;
        }
    }
}

public class Main {
    public static int MAX_PEOPLE = 100000;
    public static int[] team = new int[MAX_PEOPLE + 1];
    public static ArrayList<fight> fightList = new ArrayList<>();
    
    public static int find(int idx){
        if(team[idx] == idx){
            return idx;
        }
        int rootIdx = find(team[idx]);
        team[idx] = rootIdx;
        return rootIdx;
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA > rootB){
            team[rootA] = rootB;
        }
        else{
            team[rootB] = rootA;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            team[i] = i;
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a > b){
                fightList.add(new fight(b, a));
            }
            else{
                fightList.add(new fight(a, b));
            }
        }

        Collections.sort(fightList);
        int redTeam = fightList.get(0).a;
        int whiteTeam = fightList.get(0).b;
        for(int i = 1 ; i < fightList.size() ; i++){
            int left = fightList.get(i).a;
            int right = fightList.get(i).b;

            if(find(left) == find(right)){
                System.out.print(0);
                System.exit(0);
            }

            if(find(left) == redTeam){
                union(whiteTeam, right);
            }
            else if(find(left) == whiteTeam){
                union(redTeam, right);
            }
            else if(find(right) == redTeam){
                union(whiteTeam, left);
            }
            else if(find(right) == whiteTeam){
                union(redTeam, left);
            }
        }

        System.out.println(1);
    }
}