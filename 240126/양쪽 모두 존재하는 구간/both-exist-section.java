import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arr = new int[MAX_LENGTH];
    public static HashMap<Integer, Integer> numMap = new HashMap<>();
    public static HashMap<Integer, Integer> insideMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            numMap.put(arr[i], numMap.getOrDefault(arr[i], 0) + 1);
        }

        int j = -1;
        int output = MAX_LENGTH + 1;
        for(int i = 0 ; i < n ; i++){
            while(j + 1 < n && numMap.get(arr[j + 1]) > 1 && insideMap.size() < m) {
                numMap.put(arr[j + 1], numMap.getOrDefault(arr[j + 1], 0) - 1);
                insideMap.put(arr[j + 1], insideMap.getOrDefault(arr[j + 1], 0) + 1);
                j++;
            }

            if(insideMap.size() == m){
                output = Math.min(output, j - i + 1);
            }

            numMap.put(arr[i], numMap.getOrDefault(arr[i], 0) + 1);
            if(insideMap.get(arr[i]) <= 1){
                insideMap.remove(arr[i]);
            }
            else{
                insideMap.put(arr[i], insideMap.getOrDefault(arr[i], 0) - 1);
            }    
        }

        System.out.print(output);     
    }
}