// 양의 정수를 원소로 갖는 길이가 N인 수열이 입력으로 주어졌을 때,
// 이 수열을 오름차순으로 정렬 했을 때 각각의 위치에 있던 원소가 어느 위치로 이동하는지 출력하는 코드를 작성해보세요.

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