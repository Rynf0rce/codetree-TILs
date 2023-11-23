// n이 주어지고, n명인 학생수의 이름과
// 국어, 영어, 수학 세 과목의 점수가 주어지면 국어, 영어, 수학 순서대로 우선순위로 하여 과목 점수가 높은 학생부터 출력하는 프로그램을 작성해보세요.

import java.util.*;

class student implements Comparable<student>{
    int number;
    int height;
    int weight;

    public student(){}

    public student(int number, int height, int weight){
        this.number = number;
        this.height = height;
        this.weight = weight;
    }

    // 정수로 반환 0 보다 크면 양수를 0보다 작으면 음수를 (오름 차수)
    @Override
    public int compareTo(student input){
        if(this.height == input.height){
            if(this.weight == input.weight){
                return this.number - input.number;
            }
            else{
                return input.weight - this.weight;
            }
        }
        else{
            return input.height - this.height;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        student[] arr = new student[num];
        for(int i = 0 ; i < num ; i++){
            int number = i+1;
            int height = sc.nextInt();
            int weight = sc.nextInt();
            arr[i] = new student(number, height, weight);
        }


        // 방법 0 : class 내에 비교자(Comparator) 함수 정의하고 정수로 반환 class (name) implements comparable<name>{}
        // Arrays.sort(arr);
        // 방법 1 : sort 안에서 비교자(Comparator) 함수로 정의하기
        Arrays.sort(arr, new Comparator<student>(){
            @Override
            public int compare(student a, student b){
                if(a.height == b.height){
                    if(a.weight == b.weight){
                        return a.number - b.number;
                    }
                    else{
                        return b.weight - a.weight;
                    }
                }
                else{
                    return b.height - a.height;
                }
            }
        });

        for(int i = 0; i < num ; i++){
            System.out.printf("%d %d %d\n",arr[i].height, arr[i].weight, arr[i].number);
        }
    }
}