import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> alphaMap = new HashMap<>();
        char[] arr = sc.next().toCharArray();
        int k = sc.nextInt();

        int j = -1;
        int output = 0;
        for(int i = 0 ; i < arr.length ; i++){
            while(j + 1 < arr.length && (alphaMap.containsKey(arr[j + 1]) || (alphaMap.size() < k) )){
                alphaMap.put(arr[j + 1], alphaMap.getOrDefault(arr[j + 1], 0) + 1);
                j++;
            }

            output = Math.max(output, j - i + 1);
            if(alphaMap.get(arr[i]) == 1){
                alphaMap.remove(arr[i]);
            }
            else{
                alphaMap.put(arr[i], alphaMap.get(arr[i]) - 1);
            } 
        }
        System.out.println(output);
    }
}