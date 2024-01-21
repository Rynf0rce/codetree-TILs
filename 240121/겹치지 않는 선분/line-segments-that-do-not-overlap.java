import java.util.*;

public class Main {
    public static final int MAX_POINT = 100000;
    public static int[] leftArr = new int[MAX_POINT];
    public static int[] rightArr = new int[MAX_POINT];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> lineMap = new HashMap<>();

        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int x1 = sc.nextInt();
            leftArr[i] = x1;
            int x2 = sc.nextInt();
            rightArr[i] = x2;
            lineMap.put(x1, x2);
        }

        Arrays.sort(leftArr, 0, n);
        Arrays.sort(rightArr, 0, n);
        
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(lineMap.get(leftArr[i]) == rightArr[i]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}