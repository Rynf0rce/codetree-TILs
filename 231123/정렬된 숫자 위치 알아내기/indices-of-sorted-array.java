import java.util.*;

class numIdx implements Comparable<numIdx>{
    int num;
    int idx;

    public numIdx(){}

    public numIdx(int num, int idx){
        this.num = num;
        this.idx = idx;
    }

    @Override
    public int compareTo(numIdx input){
        return this.num - input.num;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        numIdx[] arr = new numIdx[n];
        int[] idxArr = new int[n+1];
        
        for(int i = 0 ; i < arr.length ; i++){
            int num = sc.nextInt();
            arr[i] = new numIdx(num, i+1);
        }

        Arrays.sort(arr);

        for(int i = 0 ; i < arr.length ; i++){
            idxArr[arr[i].idx] = i+1;
        }

        for(int i = 1 ; i <= arr.length ; i++){
            System.out.print(idxArr[i] + " ");
        }

    }
}