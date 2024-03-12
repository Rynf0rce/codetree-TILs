import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 200000;
    public static final int MAX_COMPARE = 10;
    public static int[] target = new int[MAX_LENGTH];
    public static int[] arr = new int[MAX_COMPARE];
    public static int n = -1;
    public static int m = -1;

    public static boolean isBeautiful(int idx){
        ArrayList<Integer> targetList = new ArrayList<>();
        for(int i = idx ; i <= idx + m - 1 ; i++){
            targetList.add(target[i]);
        }
        Collections.sort(targetList);
        int gap = targetList.get(0) - arr[0];
        for(int i = 1 ; i < targetList.size() ; i++){
            if(targetList.get(i) - arr[i] != gap){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            target[i] = sc.nextInt();
        }
        m = sc.nextInt();
        for(int i = 0 ; i < m ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 0, m);
        
        ArrayList<Integer> ansList = new ArrayList<>();
        for(int i = 0 ; i < n - m + 1 ; i++){
            if(isBeautiful(i)){
                ansList.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ansList.size() + "\n");
        for(int i = 0 ; i < ansList.size() ; i++){
            sb.append((ansList.get(i) + 1) + "\n");
        }
        System.out.print(sb.toString());
    }
}