// n이 주어지고, n명인 학생수의 이름과 세 과목의 점수가 주어지면
// 총점이 낮은 순으로 정렬하여 출력하는 프로그램을 작성해보세요. 단, 이름과 총점이 같은 경우는 없습니다.

import java.util.*;

class student implements Comparable<student>{
    String name;
    int Korean;
    int English;
    int Math;

    public student(){}

    public student(String name, int Korean, int English, int Math){
        this.name = name;
        this.Korean = Korean;
        this.English = English;
        this.Math = Math;
    }

    // 정수로 반환 0 보다 크면 양수를 0보다 작으면 음수를 (오름 차수)
    @Override
    public int compareTo(student input){
        return (this.Korean + this.English + this.Math) - (input.Korean + input.English + input.Math);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        student[] arr = new student[num];
        for(int i = 0 ; i < num ; i++){
            String name = sc.next();
            int Korean = sc.nextInt();
            int English = sc.nextInt();
            int Math = sc.nextInt();
            arr[i] = new student(name, Korean, English, Math);
        }


        // 방법 0 : class 내에 비교자(Comparator) 함수 정의하고 정수로 반환 class (name) implements comparable<name>{}
        // Arrays.sort(arr);
        // 방법 1 : sort 안에서 비교자(Comparator) 함수로 정의하기
        Arrays.sort(arr, new Comparator<student>(){
            @Override
            public int compare(student a, student b){
                return (a.Korean + a.English + a.Math) - (b.Korean + b.English + b.Math);
            }
        });

        for(int i = 0; i < num ; i++){
            System.out.printf("%s %d %d %d\n",arr[i].name, arr[i].Korean, arr[i].English, arr[i].Math);
        }
    }
}