import java.util.*;

public class Main {
    public static final int MAX_PEOPLE = 4;
    public static final int MAX_ORDER = 100;
    public static int[] orderArr = new int[MAX_ORDER];
    public static int[] posArr = new int[MAX_PEOPLE];
    public static ArrayList<Integer> commandList = new ArrayList<>();
    public static int n;
    public static int m;
    public static int k;
    public static int maxVal = Integer.MIN_VALUE;

    public static void posArrReset(){
        for(int i = 0 ; i < k ; i++){
            posArr[i] = 0;
        }
    }

    public static void play(){
        posArrReset();
        for(int i = 0 ; i < commandList.size() ; i++){
            posArr[commandList.get(i)] += orderArr[i];
        }
    }

    public static int chackArrive(){
        int cnt = 0;
        for(int i = 0 ; i < k ; i++){
            if(posArr[i] >= m){
                cnt++;
            }
        }
        return cnt;
    }

    public static void setIdx(int num){
        if(num > n){
            play();
            maxVal = Math.max(maxVal, chackArrive());
            return;
        }

        for(int i = 0 ; i < k ; i++){
            commandList.add(i);
            setIdx(num + 1);
            commandList.remove(commandList.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt() - 1;
        k = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            orderArr[i] = sc.nextInt();
        }

        setIdx(1);

        System.out.print(maxVal);

    }
}