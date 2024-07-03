import java.util.*;

class pair implements Comparable<pair>{
    int x1;
    int x2;

    pair(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(pair input){
        return this.x1 - input.x1;
    }
}

public class Main {
    public static final int MAX_INPUT = 15;
    public static ArrayList<pair> vector = new ArrayList<>();
    public static ArrayList<Integer> select = new ArrayList<>();
    public static int n = 0;

    public static boolean outRange(pair p1, pair p2){
        return (p1.x2 < p2.x1 || p2.x2 < p1.x1);
    }
    
    public static int conFnc(int idx){
        int cnt = 0;

        if(idx >= n){
            return select.size() + 1;
        }

        for(int i = idx + 1 ; i < n ; i++){
            if(outRange(vector.get(idx), vector.get(i))){
                select.add(i);
                cnt = Math.max(cnt, conFnc(i));
                select.remove(select.size() - 1);
            }
        }

        cnt = Math.max(cnt, conFnc(idx + 1));

        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            vector.add(new pair(x1, x2));
        }

        Collections.sort(vector);

        System.out.println(conFnc(0));
    }
}