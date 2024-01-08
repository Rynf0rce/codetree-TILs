import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100000;
    public static int[] arr = new int[MAX_RANGE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> numList = new ArrayList<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int maxCnt = Integer.MIN_VALUE;

        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, Comparator.reverseOrder());

        for(int i = 0 ; i < keyList.size() ; i++) {
            int key = keyList.get(i);
			Integer cnt = map.get(key);
            if(maxCnt < cnt){
                numList.clear();
                numList.add(key);
                maxCnt = cnt;
            }
            else if(maxCnt == cnt){
                numList.add(key);
            }
		}

        for(int i = 0 ; i < numList.size() ; i++){
            System.out.print(numList.get(i) + " ");
        }
    }
}