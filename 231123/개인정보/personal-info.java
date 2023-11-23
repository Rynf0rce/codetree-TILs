// 5명의 이름, 키, 몸무게가 주어지면 이름순으로 정렬하여 출력하고
// 키가 큰 순으로 정렬하여 출력하는 프로그램을 작성해보세요. 단, 동일한 이름과 키가 주어지지 않는다고 가정해도 좋습니다.

import java.util.*;

class student implements Comparable<student>{
    String name;
    int height;
    double weight;

    public student(){}

    public student(String name, int height, double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    // 정수로 반환 0 보다 크면 양수를 0보다 작으면 음수를 (오름 차수)
    @Override
    public int compareTo(student input){
        return this.name.compareTo(input.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int num = sc.nextInt();
        student[] arr = new student[5];
        for(int i = 0 ; i < 5 ; i++){
            String name = sc.next();
            int height = sc.nextInt();
            double weight = sc.nextDouble();
            arr[i] = new student(name, height, weight);
        }

        Arrays.sort(arr);
        System.out.println("name");
        for(int i = 0; i < 5 ; i++){
            System.out.printf("%s %d %.1f\n",arr[i].name, arr[i].height, arr[i].weight);
        }
        System.out.println();


        // 방법 0 : class 내에 비교자(Comparator) 함수 정의하고 정수로 반환 class (name) implements comparable<name>{}
        // Arrays.sort(arr);
        // 방법 1 : sort 안에서 비교자(Comparator) 함수로 정의하기
        Arrays.sort(arr, new Comparator<student>(){
            @Override
            public int compare(student a, student b){
                return b.height - a.height;
            }
        });

        System.out.println("height");
        for(int i = 0; i < 5 ; i++){
            System.out.printf("%s %d %.1f\n",arr[i].name, arr[i].height, arr[i].weight);
        }
    }
}