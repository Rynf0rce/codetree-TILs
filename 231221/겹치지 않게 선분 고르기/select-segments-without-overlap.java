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
    public static ArrayList<Boolean> select = new ArrayList<>();
    public static int n = 0;

    public static boolean outRange(int x1, int x2, int y1, int y2){
        return (y1 > x2 || y2 < x1);
    }
    
    public static int chackFold(){
        int cnt = 0;
        int x2 = 0;
        for(int i = 0 ; i < select.size() ; i++){
            if(select.get(i)){
                cnt++;
                if(x2 == 0){
                    x2 = vector.get(i).x2;
                }
                else{
                    if(x2 > vector.get(i).x1){
                        return -1;
                    }
                }
            }
        }
        
        return cnt;
    }

    public static int conFnc(){
        int maxVal = 0;
        if(select.size() >= n){
            return chackFold();
        }
        for(int i = 0 ; i < n ; i++){
            select.add(true);
            maxVal = Math.max(maxVal, conFnc());
            select.remove(select.size() - 1);

            select.add(false);
            maxVal = Math.max(maxVal, conFnc());
            select.remove(select.size() - 1);
        }
        
        return maxVal;
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

        System.out.println(conFnc());
    }
}