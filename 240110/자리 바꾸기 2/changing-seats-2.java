import java.util.*;

public class Main {
    public static final int MAX_PEOPLE = 100000;
    public static final int MAX_CHANGE = 100000;

    public static HashSet<Integer>[] peopleSet = new HashSet[MAX_PEOPLE];

    public static int[] arr = new int[MAX_PEOPLE + 1];
    public static int[] selectedA = new int[MAX_CHANGE];
    public static int[] selectedB = new int[MAX_CHANGE];

    public static void swap(int idx1, int idx2){
        peopleSet[arr[idx1]].add(idx2);
        peopleSet[arr[idx2]].add(idx1);

        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for(int i = 1 ; i <= N ; i++){
            peopleSet[i] = new HashSet<Integer>();
            arr[i] = i;
            peopleSet[i].add(arr[i]);
        }

        int K = sc.nextInt();

        for(int i = 0 ; i < K ; i++){
            selectedA[i] = sc.nextInt();
            selectedB[i] = sc.nextInt();
        }

        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < K ; j++){
                swap(selectedA[j], selectedB[j]);
            }
        }

        for(int i = 1 ; i <= N ; i++){
            System.out.println(peopleSet[i].size());
        }

    }
}