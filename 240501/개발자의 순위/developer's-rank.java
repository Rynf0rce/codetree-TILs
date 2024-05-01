import java.util.*;
import java.io.*;

class pair{
    int left, right;
    public pair(int left, int right){
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pair p = (pair) o;
        return left == p.left && right == p.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}

public class Main {
    public static HashSet<pair> ansSet = new HashSet<>();
    public static final int MAX_PEOPLE = 20;
    public static int[] arr = new int[MAX_PEOPLE];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            if(i == 0){
                for(int j = 0 ; j < N - 1 ; j++){
                    for(int k = j + 1 ; k < N ; k++){
                        ansSet.add(new pair(arr[j], arr[k]));
                    }
                }
            }
            else{
                for(int j = 0 ; j < N - 1 ; j++){
                    for(int k = j + 1 ; k < N ; k++){
                        if(ansSet.contains(new pair(arr[k], arr[j]))){
                            ansSet.remove(new pair(arr[k], arr[j]));
                        }
                    }
                }
            }
        }

        System.out.println(ansSet.size());



    }
}