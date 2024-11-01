import java.util.*;

public class Main {
    public static final int MAX_NUM = 8;
    public static int n = 0;
    public static boolean[] visited = new boolean[MAX_NUM + 1];
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void printArray(int idx){
        if(idx >= n){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = n ; i >= 1 ; i--){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            arr.add(i);
            printArray(idx + 1);
            arr.remove(arr.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        printArray(0);
    }
}