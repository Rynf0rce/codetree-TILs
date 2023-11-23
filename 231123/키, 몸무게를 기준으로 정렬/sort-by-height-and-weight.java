// n명의 이름, 키, 몸무게가 주어지면 키를 기준으로 오름차순으로 정렬하여 출력하는 프로그램을 작성해보세요.
// 단, 키가 동일한 경우에는 몸무게가 더 큰 사람이 먼저 나오도록 정렬해야 합니다. 키, 몸무게가 둘 다 동일한 경우는 없다고 가정해도 좋습니다.

import java.util.*;

class student implements Comparable<student>{
    String name;
    int height;
    int weight;

    public student(){}

    public student(String name, int height, int weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    // 정수로 반환 0 보다 크면 양수를 0보다 작으면 음수를 (오름 차수)
    @Override
    public int compareTo(student input){
        if(this.height == input.height){
            return input.weight - this.weight;
        }
        else{
            return this.height - input.height;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        student[] arr = new student[num];
        for(int i = 0 ; i < num ; i++){
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            arr[i] = new student(name, height, weight);
        }

        Arrays.sort(arr);
        for(int i = 0; i < num; i++){
            System.out.printf("%s %d %d\n",arr[i].name, arr[i].height, arr[i].weight);
        }
    }
}