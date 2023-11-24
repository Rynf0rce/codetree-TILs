// 위치 0에서 시작하여 n번의 명령에 걸쳐 움직인 뒤, 2번 이상 지나간 영역의 크기를 출력하는 프로그램을 작성해보세요.
// 단 명령은 “x L“, “x R” 형태로만 주어집니다. "x L" 의 경우 왼쪽으로 x만큼 이동해야 함을, "x R"의 경우 오른쪽으로 x만큼 이동해야 함을 뜻합니다.
import java.util.*;

class idxColor{
    char color;
    int Lcount;
    int Rcount;

    idxColor(){
        this.color = 'N';
        this.Lcount = 0;
        this.Rcount = 0;
    }
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


        //num = 5;
        //int[] testarr = new int[]{1,1,1,2,1};
        //char[] testdir = new char[]{'L','L','R', 'R','L'};
        for(int i = 0 ; i < num ; i++){
            int step = sc.nextInt();  //testarr[i];//
            char direct = sc.next().charAt(0);// testdir[i];//
            switch(direct){
                case 'R' :
                    for(int j = current ; j < current + step ; j++){
                        arr[j].Rcount++;
                        if(arr[j].Rcount > 1 && arr[j].Lcount > 1){
                            arr[j].color = 'A';
                        }
                        else{
                             arr[j].color = 'B';
                        }
                    }
                    current += (step - 1);
                    break;
                case 'L' :
                    for(int j = current ; j > current - step ; j--){
                        arr[j].Lcount++;
                        if(arr[j].Rcount > 1 && arr[j].Lcount > 1){
                            arr[j].color = 'A';
                        }
                        else{
                            arr[j].color = 'W';
                        }
                    }
                    current -= (step - 1);
                    break;
                default :
                    break;
            }
        }
        int white = 0;
        int black = 0;
        int ash = 0;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i].color == 'W'){
                white++;
            }
            else if(arr[i].color == 'B'){
                black++;
            }
            else if(arr[i].color == 'A'){
                ash++;
            }
        }
        System.out.printf("%d %d %d", white, black, ash);
    }
}