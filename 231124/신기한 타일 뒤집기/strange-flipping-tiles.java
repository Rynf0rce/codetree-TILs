// 일직선으로 무한히 나열된 회색 타일이 있습니다. 
// 이 타일은 신기한 타일이기 때문에, 현재 타일의 색이 어떤 색인지와는 상관없이 왼쪽으로 뒤집으면 흰색으로 바뀌고, 오른쪽으로 뒤집으면 검은색으로 바뀌게 됩니다.
// 아무 타일에서 시작하여 n번의 명령에 걸쳐 움직입니다.  타일의 색은 덧칠해지면 마지막으로 칠해진 색으로 바뀌는데, 만약 타일 하나가 순서 상관없이 흰색과 검은색으로 각각 두 번 이상 칠해지면 회색으로 바뀌고 더 이상 바뀌지 않습니다.
// 명령은 "x L", "x R" 형태로만 주어지며, "x L"의 경우 왼쪽으로 이동하며 순서대로 현재 위치 타일포함 총 x칸의 타일을 왼쪽으로 뒤집습니다. 
// "x R"의 경우 오른쪽으로 이동하며 순서대로 현재 위치 타일포함 총 x칸의 타일을 오른쪽으로 뒤집습니다. 각 명령 이후에는 마지막으로 뒤집은 타일 위치에 서있는다고 가정합니다.
// 모든 명령을 실행한 뒤의 흰색, 검은색 타일 수를 각각 출력하는 프로그램을 작성해보세요.

import java.util.*;

class idxColor{
    char color;
    int Lcount;
    int Rcount;

    idxColor(){}

    idxColor(char color){
        this.color = color;
        this.Lcount = 0;
        this.Rcount = 0;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), current = 100000, cnt = 0;
        idxColor[] arr = new idxColor[200001];
        for(int i = 0; i < arr.length ; i++){
            arr[i] = new idxColor('N');
        }

        for(int i = 0 ; i < num ; i++){
            int step = sc.nextInt();
            char direct = sc.next().charAt(0);
            switch(direct){
                case 'R' :
                    for(int j = current ; j < current + step ; j++){
                         arr[j].color = 'B';
                    }
                    current += (step - 1);
                    break;
                case 'L' :
                    for(int j = current ; j > current - step ; j--){
                        arr[j].color = 'W';
                    }
                    current -= (step - 1);
                    break;
                default :
                    break;
            }
        }
        int white = 0;
        int black = 0;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i].color == 'W'){
                white++;
            }
            else if(arr[i].color == 'B'){
                black++;
            }
        }
        System.out.printf("%d %d", white, black);
    }
}