import java.util.*;

public class Main {
    public static int[] arr = new int[3];
    public static boolean[] visited = new boolean[3];
    public static ArrayList<Integer> ansList = new ArrayList<>();

    public static void makecase(int cnt, int val){
        if(!ansList.contains(val)){
            ansList.add(val);
        }

        for(int i = 0 ; i < 3 ; i++){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            makecase(cnt + 1, val * arr[i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 3 ; i++){
            arr[i] = sc.nextInt();
        }

        makecase(0, 1);

        Collections.sort(ansList, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                if(a % 2 == 1 && b % 2 == 0){
                    return 1;
                }
                else if(a % 2 == 0 && b % 2 == 1){
                    return -1;
                }
                else if(a % 2 == 1 && b % 2 == 1){
                    return a - b;
                }
                else{
                    return a - b;
                }
            }
        } );

        // for(int num : ansList){
        //     System.out.println(num);
        // }
        System.out.print(ansList.get(ansList.size() - 1));
    }
}