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

        List<HashMap.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());

        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
                if(o2.getValue() == o1.getValue()){
                    return o2.getKey() - o1.getKey();
                }
                else{
                    return o2.getValue() - o1.getValue();
                }
            }
        });

        for(int i = 0 ; i < k ; i++){
            System.out.print(entryList.get(i).getKey() + " ");
            // System.out.println("key : " + entryList.get(i).getKey() + ", value : " + entryList.get(i).getValue());
        }
        
        // for(Map.Entry<Integer, Integer> entry : entryList){
        //     System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
        // }
    }
}